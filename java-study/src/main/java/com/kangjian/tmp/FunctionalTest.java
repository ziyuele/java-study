package com.kangjian.tmp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FunctionalTest {
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

    public void  testInterface() {
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("dddd");
        unitActionJudgeFun().judgeScale("", "", "", 0, new ArrayList());
    }
}
