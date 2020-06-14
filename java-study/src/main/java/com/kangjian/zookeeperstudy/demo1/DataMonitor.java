package com.kangjian.zookeeperstudy.demo1;

import java.util.Arrays;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.KeeperException.Code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataMonitor implements Watcher , AsyncCallback.StatCallback {

    ZooKeeper zk;
    String node;
    Watcher chainedWatcher;
    DataMonitorListener dataMonitorListener;
    boolean dead;
    byte preData[];

    public DataMonitor(ZooKeeper zooKeeper, String node, Watcher chainedWatcher, DataMonitorListener listener) {
        this.zk = zooKeeper;
        this.node = node;
        this.chainedWatcher = chainedWatcher;
        this.dataMonitorListener = listener;

        zk.exists(node, true, this, null);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        String path = watchedEvent.getPath();
        if (watchedEvent.getType() == Event.EventType.None) {
           switch (watchedEvent.getState()) {
               case SyncConnected:
                   log.info("current status is {}", watchedEvent.getState());
                   break;
               case Expired:
                   dead = true;
                   dataMonitorListener.closing(KeeperException.Code.SessionExpired);
                   break;
               default:
                   log.info("current state is :{}", watchedEvent.getState());
           }
        } else {
            if (path != null && path.equals(node)) {
                zk.exists(node, true, this, null);
            }
        }

        if (chainedWatcher != null) {
            chainedWatcher.process(watchedEvent);
        }
    }

    // 异步回调结果的处理
    @Override
    public void processResult(int i, String s, Object o, Stat stat) {
        log.info("stat is :{}", stat.toString());
        log.info("code is :{}", i);
        boolean exists;
        switch (i) {
            case Code.Ok:
                exists = true;
                break;
            case Code.NoNode:
                log.warn("node not exist");
                exists = false;
                break;
            case Code.SessionExpired:
            case Code.NoAuth:
                dead = true;
                dataMonitorListener.closing(i);
            default:
                log.info("call back code is");
                zk.exists(node, true, this, null);
                return;
        }
        byte b[] = null;
        if (exists) {
            try {
                b = zk.getData(node, false, null);
                log.info("get data from zk is :" + new String(b));
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                return;
            }
        }

        if ((b == null && b != preData) || (b != null && !Arrays.equals(preData, b))) {
            dataMonitorListener.exists(b);
            preData = b;
        }
    }

    // 用来执行本地的某一个命令
    public interface DataMonitorListener{
       void exists(byte data[]);
       void closing(int rc);
    }
}
