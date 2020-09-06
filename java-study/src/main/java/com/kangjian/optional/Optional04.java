package com.kangjian.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Optional04 {
    public static void main(String args[]) {
        Optional<List<String>> optionalStrings = Optional.of(Arrays.asList("o1", "o2", "o3"));
        optionalStrings.ifPresent(strings -> {
            System.out.println(strings);
        });
    }
}
