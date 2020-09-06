package com.kangjian.optional;

import java.util.Optional;

public class Optional07 {
    public static void main(String args[]) throws Exception {
        // orELse
        Optional<String> optionals = Optional.of("stringValue");
        String ret = optionals.orElse("test");
        System.out.println(ret);
        Optional<String> optionals1 = Optional.empty();
        String ret1 = optionals1.orElse("test");
        System.out.println(ret1);


        // orElseGet
        Optional<String> optionalGet = Optional.of("stringValue");
        String getRet = optionalGet.orElseGet(() -> "test");
        System.out.println(getRet);
        Optional<String> optionalGet1 = Optional.empty();
        String getRet1 = optionals1.orElseGet(() -> "test");
        System.out.println(ret1);

        // orElseThrow
        // orElseGet
        Optional<String> optionalThrrow = Optional.of("stringValue");
        String throwRet = optionalGet.orElseThrow(() -> new Exception());
        System.out.println(throwRet);
        Optional<String> optionalThrrow1 = Optional.empty();
        String throwRet1 = optionals1.orElseThrow(() -> new Exception());
        System.out.println(throwRet1);
    }
}
