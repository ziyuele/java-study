package com.ziyue.springboot.std.service.impl;

import com.ziyue.springboot.std.service.PrintService;
import org.springframework.stereotype.Service;

@Service("test1")
public class PrintServiceImplTwo implements PrintService {

    @Override
    public void print(String s) {
        System.out.print(s);
    }
}
