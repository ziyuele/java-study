/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import lombok.val;
import org.apache.curator.framework.CuratorFramework;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

@Ignore
public class Thread13Test {



    public enum DataSourceType {
        SCM("scm://"), HDFS("hdfs://"), P2P("p2p://"), FTP("ftp://"), HTTP("http://"), HTTPS("https://"), REF("ref://");

        private String prefix;

        DataSourceType(String prefix) {
            this.prefix = prefix;
        }

        public String getPrefix() {
            return prefix;
        }
    }

    String s = "{\n"
            + "    \"baseEnv\": \"system\",\n"
            + "    \"type\": \"2\",\n"
            + "    \"priority\": \"0\",\n"
            + "    \"resource\": {\n"
            + "        \"cpu\": {\n"
            + "            \"numCores\": \"1\",\n"
            + "            \"overUseEnabled\": true\n"
            + "        },\n"
            + "        \"memory\": {\n"
            + "            \"sizeMB\": \"10\",\n"
            + "            \"overUseEnabled\": true\n"
            + "        },\n"
            + "        \"disks\": {\n"
            + "            \"workspace\": {\n"
            + "                \"sizeMB\": \"10240\",\n"
            + "                \"numInodes\": \"1000\",\n"
            + "                \"type\": \"home\",\n"
            + "                \"media\": \"\",\n"
            + "                \"available\": true,\n"
            + "                \"mountPoint\": {\n"
            + "                    \"source\": \"\\/home\",\n"
            + "                    \"target\": \"\\/home\\/work\\/search\\/0.myapp-behive\"\n"
            + "                }\n"
            + "            }\n"
            + "        },\n"
            + "        \"network\": {\n"
            + "            \"inBandwidthMBPS\": \"10\",\n"
            + "            \"outBandwidthMBPS\": \"10\",\n"
            + "            \"inBandwidthOverUseEnabled\": true,\n"
            + "            \"outBandwidthOverUseEnabled\": true\n"
            + "        },\n"
            + "        \"port\": {\n"
            + "            \"range\": {\n"
            + "                \"first\": \"6560\",\n"
            + "                \"last\": \"6579\"\n"
            + "            }\n"
            + "        },\n"
            + "        \"process\": {\n"
            + "            \"numThreads\": \"1000\"\n"
            + "        },\n"
            + "        \"gpus\": \"\"\n"
            + "    }\n"
            + "}" ;


    @Test
    public void testList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (String s : list) {
            System.out.println(s);
            if (s.equals("3"));
            list.add("33");
        }

    }

    @Test
    public void testString() {
        String s = "kangjan test";
        System.out.println(s.split(" ")[0].trim());
    }


    @Test
    public void testObjectMapper() throws  Exception {
        //System.out.println(s);
        ObjectMapper om = new ObjectMapper();
        System.out.println(om.readTree(s).get("type").asInt());
        System.out.println(om.readValue(om.readTree(s).get("resource").toString(), Map.class));
    }

    @Test
    public void testTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               System.out.println("this is timer test");
            }
        }, 0, 1000);
        while(true) {

        }

    }

    @Test
    public void testProcessBuilder() {

        try {
            List<String> comd = new ArrayList<>();
            comd.add("sh");
            comd.add("/tmp/test.sh");
            ProcessBuilder processBuilder = new ProcessBuilder(comd);
            System.out.println(processBuilder.command());
            Process process = processBuilder.start();
            System.out.println(process.waitFor(10, TimeUnit.SECONDS));
            System.out.println(process.exitValue());
        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (InterruptedException e1) {
            System.out.println(e1.getMessage());
        }

    }

    @Test
    public void testGetClassName()  throws  Exception {
        ThreadTTest threadTest = Class.forName("com.kangjian.tmp.ThreadTTest").asSubclass(ThreadTTest.class).newInstance();
        threadTest.test();
        System.out.println(ThreadTTest.class.getSimpleName());
    }

    @Test
    public void formatTest() throws Exception {
        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(format.format(currentTime));
        System.out.println(format.parse(format.format(currentTime)).getTime());
    }

    @Test
    public void updateHashMap() {
        Map<String, String> res = new ConcurrentHashMap<>();
        res.put("hhh", "ttt");
        res.put("ddd", "ttt");
        res.put("hhh", "ccc");
        System.out.println(res.toString());
    }

    @Test
    public void testEnum() {
        TTest t = new TTest();
        t.setType(TTest.DataSourceType.valueOf("SCM"));
        DataSourceType type = DataSourceType.FTP;
        System.out.println(type.toString());
    }

    @Test
    public void testDu() throws IOException, InterruptedException {
        File file = new File("/Users/kangjian03/devEnv");
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("env");
        Process process = processBuilder.start();
        process.waitFor(20, TimeUnit.SECONDS);
        BufferedInputStream inputStream = new BufferedInputStream(process.getInputStream());
        byte b[] = new byte[inputStream.available()];
        inputStream.read(b, 0, b.length);
        String res = new String(b);
        System.out.println(res);
        System.out.println(res.replaceAll("\t| ", " ").split(" ")[0]);
    }


    @Test
    public void testGetLock() {
        System.out.println(Long.MAX_VALUE);
    }

    @Test
    public void testRadom() {
        Map map = new ConcurrentHashMap();
        Map map1 = new HashMap(  );
        //map.put( null, "test" );
        map1.put( null, "test" );
    }

    @Test
    public void sortTest() {
        List<Integer> list = new ArrayList();
        List<Integer> integers = list.stream().filter(r -> r >5).collect(Collectors.toList());
        System.out.println(integers);
    }

    private int getNum(int x) {
        return x < 0? Integer.MAX_VALUE: x;
    }


}
