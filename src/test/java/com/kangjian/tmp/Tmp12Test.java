/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tmp12Test {

    public static int x = 0;

    @Test
    public void test1() {
        String name = null;
        log.info(name.isEmpty() + "");
        String name1 = "";
        log.info(name1.isEmpty() + "");
    }

    @Test
    public void testReplace() {

        String url = "/apis/v1alpha1/management/${domain}/ak/${baasRole}/list";
        String res = url.replaceAll("\\$\\{domain\\}", "SEARCHE")
                .replaceAll("\\$\\{baasRole\\}", "beehive_rd");
        System.out.println(url);
        System.out.println("---------------");
        System.out.println(res);
    }

    @Test
    public void testString() {
        String tmp = ",";
        System.out.println(tmp.split(",").length);
        List<String> baasRoleList = Arrays.asList(tmp.trim().split(","));
        System.out.println(baasRoleList.size());
        System.out.println(baasRoleList.contains(""));
    }

    @Test
    public void testIsEmpty() {
        String s = "";
        String ss = null;
        System.out.println(s.isEmpty());
    }

    @Test
    public void switchTest() {
        int x = 0;
        for (; x < 10; x++) {
            System.out.println("round:" + x);
        }
    }

    @Test
    public void hexText() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.toHexString(180392095176L));
        System.out.println(new BigInteger("2a00357962", 16));
        long current = 180392130914L;
        // First is 180392095176
        long acturl = 180392095176L;
        System.out.println(acturl - current);
    }

    @Test
    public void buildCruatorConnections() throws Exception {
        String ipList = "";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        curatorFramework.start();

    }

    @Test
    public void buildCruatorConnections1() throws Exception {
        String ipList = "";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        CuratorFramework curatorFramework1 = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        CuratorFramework curatorFramework2 = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        CuratorFramework curatorFramework3 = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        CuratorFramework curatorFramework4 = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        curatorFramework.start();
        curatorFramework1.start();
        curatorFramework2.start();
        curatorFramework3.start();
        curatorFramework4.start();
        Thread.sleep(300000);
    }

    @Test
    public void buildCruatorConnections2() throws Exception {
        String ipList = "";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        CuratorFramework curatorFramework1 = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        CuratorFramework curatorFramework2 = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        CuratorFramework curatorFramework3 = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        CuratorFramework curatorFramework4 = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        curatorFramework.start();
        curatorFramework1.start();
        curatorFramework2.start();
        curatorFramework3.start();
        curatorFramework4.start();
        Thread.sleep(300000);
    }

    @Test
    public void buildCruatorConnections3() throws Exception {
        String ipList = "";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        CuratorFramework curatorFramework1 = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        CuratorFramework curatorFramework2 = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        CuratorFramework curatorFramework3 = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        CuratorFramework curatorFramework4 = CuratorFrameworkFactory.newClient(ipList, retryPolicy);
        curatorFramework.start();
        curatorFramework1.start();
        curatorFramework2.start();
        curatorFramework3.start();
        curatorFramework4.start();
        Thread.sleep(300000);
    }

    @Test
    public void soeckeTest() throws Exception {
        Socket socket = new Socket("", 8181);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("srvr".getBytes("UTF-8"));
        socket.shutdownOutput();
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = in.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        String[] res = sb.toString().split("\n");
        System.out.println(res.length);
        for (String re : res) {
            System.out.println("== " + re);
        }
        in.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void threadPoolTest() throws Exception {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setCorePoolSize(2000);
        for (int x = 0; x < executor.getCorePoolSize(); x++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        getConnectionsTest();
                    }
                }
            });
        }
        Thread.sleep(30000);
    }

    @Test
    public void getConnectionsTest() {
        InetSocketAddress inetSocketAddress = InetSocketAddress.createUnresolved("", 8182);
        int res = getconnections(inetSocketAddress);
        System.out.println(res);
    }

    private int getconnections(InetSocketAddress inetSocketAddress) {
        Socket socket = null;
        int connectNum = Integer.MAX_VALUE;
        try {
            socket = new Socket(inetSocketAddress.getHostString(), inetSocketAddress.getPort());
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("monr".getBytes("UTF-8"));
            socket.shutdownOutput();
            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = in.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len, "UTF-8"));
            }
            String[] res = sb.toString().split("\n");
            for (String re : res) {
                if (re.trim().contains("zk_client_connections") || re.trim().contains("Connections")) {
                    connectNum = Integer.parseInt(re.split(":")[1].trim());
                }
            }
            in.close();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            if (null != socket) {
                try {
                    socket.close();
                } catch (Exception e1) {
                    e.printStackTrace();
                }
            }
        }
        return connectNum;
    }

    @Test
    public void volatileTest() throws Exception {
        List<Thread> list = new ArrayList<>();
        for (int x = 0; x < 20480; x++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(10));
                        Tmp12Test.x = Tmp12Test.x + 1;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            list.add(t);
        }
        for (Thread thread : list) {
            thread.start();
            thread.join();
        }
        System.out.println(x);
    }
}
