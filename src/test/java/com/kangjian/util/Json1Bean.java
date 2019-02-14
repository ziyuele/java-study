package com.kangjian.util;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Json1Bean implements Serializable {
    private String name = "kangjian";
    private int age = 25;
    private boolean sex = true;
}
