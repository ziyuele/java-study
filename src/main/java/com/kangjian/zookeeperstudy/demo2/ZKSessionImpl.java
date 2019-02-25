/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.zookeeperstudy.demo2;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZKSessionImpl extends ZKSessionStore implements ZKSession, Watcher{

    private ZooKeeper zooKeeper;

    private String hostPort;
    private int sessionTimeOut;
    private static final Object OBJECT_LOCK = new Object();
    // extend methods from ZKSessionStore
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
                    zooKeeper.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
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

    }

    @Override
    public void delete(String path) {

    }

    @Override
    public void update(String path, String data) {

    }

    @Override
    public String get(String path) {
        return null;
    }

    @Override
    public List<String> child(String path) {
        return null;
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
           return run();
       }
    }
}
