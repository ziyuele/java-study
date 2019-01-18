package com.kangjian.springbootstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class SpringBootMain {

    @Autowired
    private ReadConf readConf;

    public static void main(String args[]) {
       SpringApplication.run(SpringBootMain.class, args);
    }
}
