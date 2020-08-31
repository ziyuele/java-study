package com.kangjian.optional;

import java.util.Optional;

public class Optional03 {
    public static void main(String args[]) {
        Optional<Integer> optional = Optional.of(3);
        Optional<Integer> retOpt =  optional.map(o -> o + 1);
        System.out.println(retOpt.get());
    }
}
