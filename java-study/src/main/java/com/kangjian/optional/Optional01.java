package com.kangjian.optional;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class Optional01 {
    public static void main(String args[]) {
        Optional<Integer> optionalInteger = Optional.of(3);
        int num = optionalInteger.get();
        System.out.println("Get num res is :" + num);

        Optional<Integer> optionalInteger1 = Optional.ofNullable(null);
        System.out.println("num is :"  +   optionalInteger1.get());
    }
}
