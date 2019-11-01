/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Tmp15 {
    private int name =  0;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tmp15 tmp15 = (Tmp15) o;
        return name == tmp15.name;
    }

    @Override
    public int hashCode() {
        return new Random().nextInt(100);
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Tmp15(int name) {
        this.name = name;
    }

    public static  void main(String args[]) {
//        Map<Tmp15, String> map = new HashMap<>();
//        Tmp15 tmp15 = new Tmp15(23);
//        Tmp15 tmp151 = new Tmp15(25);
//        map.put(tmp15, "dd");
//        map.put(tmp151, "ee");
//        System.out.println(map.get(tmp15));
//        System.out.println(map.containsKey(tmp15));
        int arr[] = {0,1,2,2,3,0,4,2};
        removeElement(arr, 2);

    }

    public static  int removeElement(int[] nums, int val) {
        int count = 0;
        int tmp_length = nums.length - 1;
        int tmp_flag = 0;
        while (tmp_flag <= tmp_length) {
            if (nums[tmp_flag] == val) {
                System.out.println(nums[tmp_flag] + " dddd " + tmp_flag);
                for (int x = tmp_flag; x < tmp_length; x++) {
                    nums[x] = nums[x+1];
                }
                for (int s = 0; s < nums.length; s ++){
                    System.out.print(nums[s] + ",");
                }
                System.out.println();
                tmp_length --;
                count ++;
            }else{
                tmp_flag ++;
            }
        }
        String s = "jh";
        return count;
    }
}
