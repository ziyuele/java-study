/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import org.springframework.lang.Nullable;

import lombok.NonNull;


// Jsr 305
public class NullableAnnoation {

    public void printString(@NonNull String s) {
        System.out.println(s);

    }

    public void printStringHasNull(@Nullable String s) {
        System.out.println(s);

    }

    public static void main(String args[]) {
        new NullableAnnoation().printStringHasNull(null);
        new NullableAnnoation().printString(null);
    }
}
