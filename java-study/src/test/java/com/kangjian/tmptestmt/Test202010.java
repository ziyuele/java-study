package com.kangjian.tmptestmt;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Test202010 {

    @Test
    public void testNull() {
       boolean bb = getBoolean();
       log.info("ret is  {}", bb);
    }

    @Test
    public void testGetOrDefault() {
       Map<String, String> map = new HashMap<>();
       String rest = map.getOrDefault(null, null);
       log.info("rest is :{}", rest);

    }

    @Test
    public void testGroupBy() {
        List<Demo> demoList = new ArrayList<>();
        demoList.add(new Demo());
        demoList.add(new Demo());
        demoList.add(new Demo());
        demoList.add(new Demo("kj"));
        demoList.add(new Demo("kj"));
        demoList.add(new Demo("kj"));
        Map<String, List<Demo>> demoMap = demoList.stream().collect(Collectors.groupingBy(Demo::getName));
        log.info(demoMap.toString());
    }

    @Test
    public void  testBoolean() {
       if (1 < 2 && (1 > 3 || 1 < 0)) {
           log.info("is ok");
       }  else {
           log.info("not ok");
       }
    }

    @Test
    public void testAddAll() {
        Set<String> set = new HashSet<>();
        set.add("kangjain");
        Set<String> set1 = new HashSet<>();
        set1.add("1");
        set1.add("2");
        set.addAll(set1);
        log.info(set.toString());
    }

    private boolean getBoolean() {
        Boolean b = null;
        try {
            return b;
        } catch (Exception e) {
           log.info(e.getMessage(), e);
        }
        return false;
    }




    @Data
    class Demo {
        private String name;
        private String createTime;

        public Demo() {
            this.name = "kangjian";
            this.createTime = System.nanoTime() + "";
        }

        public Demo(String name) {
            this.name = name;
            this.createTime = System.nanoTime() + "";
        }
    }

    @FunctionalInterface
    public interface UnitActionJudgeFun {
        /**
         * Action是否可以执行判断，比如扩容前判断机房余量是否充裕
         *
         * @param appkey 服务
         * @param idc    机房
         * @param env    环境
         * @param num    扩缩数
         * @return true:机房可以扩缩；false：机房不可扩缩
         */
        boolean judgeScale(String appkey, String idc, String env, int num, List groupTagList);
    }

    UnitActionJudgeFun unitActionJudgeFun() {
        return (a, b, c, d, e) -> {
            System.out.println(e);
            return false;
        };
    }

    @Test
    public void  testInterface() {
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("dddd");
        unitActionJudgeFun().judgeScale("", "", "", 0, new ArrayList());
    }

    @Test
    public void testEquals() {
        String s = null;
        String s1 = null;
        Boolean b
         = Objects.equals(s, s1);
        log.info("ret is : {}", b) ;
    }
}
