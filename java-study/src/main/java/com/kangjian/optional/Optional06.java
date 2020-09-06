package com.kangjian.optional;

import java.util.Optional;

public class Optional06 {
    public static void main(String args[]) {
        Optional<String> optionalS = Optional.of("test1 test2");
        //optionalS.flatMap(f -> f.split(" ")).get();
    }
}
