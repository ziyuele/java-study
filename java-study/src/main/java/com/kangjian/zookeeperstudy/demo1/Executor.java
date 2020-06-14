package com.kangjian.zookeeperstudy.demo1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Executor implements Watcher, DataMonitor.DataMonitorListener, Runnable{
    private String fileName;
    private ZooKeeper zk;
    private DataMonitor dataMonitor;
    private Process child;
    private String exec;

    public Executor(String hostPort, String zNode, String fileName, String exec) throws KeeperException {
        this.fileName = fileName;
        this.exec = exec;
        try {

            /*
             * three arguments : host-port, sessionTimeout, watcher[implements from watcher]
             */

            this.zk = new ZooKeeper(hostPort, 3000, this);
            this.dataMonitor = new DataMonitor(zk, zNode, null, this);
        } catch (IOException ioe) {
            log.error("error to init zookeeper");
            System.exit(-1);
        }

    }

    public void run() {
        try {
            synchronized(this) {
                while (!dataMonitor.dead) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
     }

    @Override
    public void process(WatchedEvent watchedEvent) {
        dataMonitor.process(watchedEvent);
    }

    @Override
    public void exists(byte[] data) {
        if (data == null) {
            if (child != null) {
                System.out.println("killing process");
                child.destroy();
                try {
                    child.waitFor();
                } catch (InterruptedException e){
                }
            }
        } else {
            if (child != null) {
                System.out.println("stopping child");
                child.destroy();
                try {
                    child.waitFor();
                } catch (InterruptedException e) {

                }
            }
            try{
                // 将zk读取到的数据写入到文件里面去
                FileOutputStream fos = new FileOutputStream(fileName);
                fos.write(data);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
               // 执行一段命令· 并将执行的命令打印在控制台
                log.info("starting child");
                child = Runtime.getRuntime().exec(exec);
                new StreamWriter(child.getInputStream(), System.out);
                new StreamWriter(child.getErrorStream(), System.err);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static  class StreamWriter extends Thread {
        OutputStream os;
        InputStream is;
        StreamWriter(InputStream is, OutputStream os) {
           this.is = is;
           this.os = os;
           start();
        }

        public void run() {
           byte b[] = new byte[80];
           int rc;
           try {
               while ((rc = is.read(b)) > 0) {
                   os.write(b, 0, rc);
               }
           } catch (IOException e) {

           }
        }
    }

    @Override
    public void closing(int rc) {
        synchronized(this) {
            notifyAll();
        }
    }
}

