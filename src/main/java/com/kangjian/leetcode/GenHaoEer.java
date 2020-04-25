/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

public class GenHaoEer {

    public static void main(String args[]) {
        float ret = GetGenHao2(0.01F, 0F, 2F);
        System.out.println(ret);
    }

    public static float GetGenHao2(float f, float start, float end) {
        float tryRet = (start + end) / 2F;
        if (Math.abs(tryRet * tryRet - 2F) < f) {
            return tryRet;
        } else if (tryRet * tryRet > 2F) {
            return GetGenHao2(f, start, tryRet);
        } else {
            return GetGenHao2(f, tryRet, end);
        }

    }
}
