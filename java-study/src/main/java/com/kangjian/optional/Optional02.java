package com.kangjian.optional;

import java.util.Optional;

public class Optional02 {
    public static void main(String args[]) {
        Optional<Integer> optionalInteger = Optional.of(1);
        boolean isPresent = optionalInteger.isPresent();
        System.out.println("optionalInteger present is : " + isPresent);

        Optional<Integer> nullOptional = Optional.empty();
        isPresent = nullOptional.isPresent();
        System.out.println("optionalInteger present is " + isPresent);

        Optional<Integer> nullableOpt = Optional.ofNullable(null);
        isPresent = nullableOpt.isPresent();
        System.out.println("optionalInteger present is " + isPresent);
    }
}
