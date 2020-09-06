package com.kangjian.optional;

import java.util.Optional;

public class Optional08 {
    public static void main(String args[]) {
        Optional<String>   optionalS = Optional.of("Test do");
        Optional<String[]> d  = optionalS.flatMap(s -> (Optional.of(s.split(" "))));
        for (String s :d.get()) {
            System.out.println(s);
        }
    }
}
