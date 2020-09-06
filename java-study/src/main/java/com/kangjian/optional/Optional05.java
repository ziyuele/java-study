package com.kangjian.optional;

import java.util.Optional;

public class Optional05 {
    public static void main(String args[]) {
        Optional<Integer> optionalInteger = Optional.of(3);
        int o = optionalInteger.filter(r -> r > 0).get();
        System.out.println(o);
    }
}
