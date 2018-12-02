package com.kangjian.springbootstudy;

import com.kangjian.springbootstudy.demo.ReadConf;
import com.kangjian.springbootstudy.demo.Test;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootMain {

    @Autowired
    private ReadConf readConf;

    public static void main(String args[]) {
       SpringApplication.run(SpringBootMain.class, args);
       System.out.println(Test.getReadConf().getHost() + "asdfsafdsfsf");
    }
}
