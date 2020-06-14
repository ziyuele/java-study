/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.commons.zk;

import java.io.IOException;
import java.util.List;


import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZKSessionImpl extends ZKSessionStore implements ZKSession, Watcher{

    private ZooKeeper zooKeeper;

    private String hostPort;
    private int sessionTimeOut;
    private static final Object OBJECT_LOCK = new Object();
    private static final String defaultCharSet = "UTF-8";
    // extend methods from ZKSessionStore
    public ZKSessionImpl() {}
    public  ZKSessionImpl(String hostPort,int sessionTimeOut) {
        createClient(hostPort, sessionTimeOut);
    }
    @Override
    public ZooKeeper createClient(String hostPort, int sessionTimeOut) {
        this.hostPort = hostPort;
        this.sessionTimeOut = sessionTimeOut;
        try {
            this.zooKeeper = new ZooKeeper(hostPort, sessionTimeOut, this);
            return this.zooKeeper;
        } catch (IOException e) {
           log.error(e.getMessage(), e);
           throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void createClient() {
        createClient(hostPort, sessionTimeOut);
    }

    // implements methods from ZKSession
    /*
    this method can not create dir folder like /home/dddd/ddddd
     */
    @Override
    public void create(final String path) {
        try {
            new ZooKeeperAction<Void>() {
                @Override
                Void run() throws KeeperException, InterruptedException {
                    // dataPath, data, auth createMode
                    // throws KeeperException InterruptException
                    zooKeeper.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
                    return null;
                }
            }.action();
        } catch (KeeperException e) {
            if (e.code() == KeeperException.Code.NODEEXISTS) {
                log.warn("node already exists");
                return;
            }
            log.error(e.getMessage(), e);
        } catch (Exception e1) {
            log.error(e1.getMessage(), e1);
        }
    }

    @Override
    public void create(String path, String data) {
        try {
            new ZooKeeperAction<Void>() {
                @Override
                Void run() throws KeeperException, InterruptedException {
                    zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                    return null;
                }
            }.action();
        } catch (KeeperException e) {
            log.warn(e.getMessage(), e);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }
    }


    @Override
    public void delete(String path) {
        try {
            new ZooKeeperAction<Void>(){
                @Override
                Void run() throws KeeperException, InterruptedException {
                    // don't use version use default -1
                    zooKeeper.delete(path, -1);
                    return null;
                }
            }.action();
        } catch (KeeperException e) {
           if (e.code() == KeeperException.Code.NONODE)  {
               log.warn("node not exist");
           }
           log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

    @Override
    public void update(String path, String data) {
        try {
            new ZooKeeperAction<Void>() {
                @Override
                Void run() throws KeeperException, InterruptedException {
                    zooKeeper.setData(path, data.getBytes(), -1);
                    return null;
                }
            }.action();
        } catch (KeeperException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public String get(String path) {
        try {
            return new ZooKeeperAction<String>() {
                @Override
                String run() throws KeeperException, InterruptedException {
                   byte[] res =  zooKeeper.getData(path, false, null);
                   try {
                       return new String(res, defaultCharSet);
                   } catch (Exception e) {
                       throw new RuntimeException(e.getMessage(), e);
                   }
                }
            }.action();
        } catch (KeeperException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public List<String> child(String path) {
       try {
           return new ZooKeeperAction<List<String>>() {
               @Override
               List<String> run() throws KeeperException, InterruptedException {
                   return zooKeeper.getChildren(path, false);
               }
           }.action();
       } catch (KeeperException e) {
           log.error(e.getMessage(), e);
           throw new RuntimeException(e.getMessage(), e);
       } catch (Exception e) {
           log.error(e.getMessage(), e);
           throw new RuntimeException(e.getMessage(), e);
       }

    }



    // implements method from Watcher
    @Override
    public void process(WatchedEvent event) {
        if (event.getType() == Event.EventType.None) {
            // why need to synchronized
            // if there is one more connection
            // make sure it is thread safe
            synchronized(OBJECT_LOCK) {
                switch (event.getState()) {
                    case Expired:
                        log.warn("connection expired try to recreate it");
                        createClient();
                        break;
                    case Disconnected:
                        log.warn("connection loss");
                        throw new RuntimeException("zk Disconnected");
                    default:
                        log.info("current zk status is :{}", event.getState());
                }
            }
        }
    }

    abstract class ZooKeeperAction<T> {
       abstract T run() throws KeeperException, InterruptedException;

       public T action() throws Exception{
           StringUtil.isNullOrEmpty("dd");
           return run();
       }
    }
}
