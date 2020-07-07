package com.ziyue.springboot.std.service.impl;

import com.ziyue.springboot.std.service.PrintService;
import org.springframework.stereotype.Service;


@Service("test")
public class PrintServiceImpleOne implements PrintService {

    @Override
    public void print(String s) {
        System.err.print(s);
    }
}
