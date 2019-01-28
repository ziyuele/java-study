package com.kangjian.annotation;

import javax.validation.constraints.NotNull;

public class Test1  {
    public void test(@NotNull Integer x) {
        System.out.println(x);
    }
}
