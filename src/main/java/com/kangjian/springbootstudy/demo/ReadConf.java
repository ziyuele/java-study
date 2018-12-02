package com.kangjian.springbootstudy.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ReadConf {


    @Value("${ss.host}")
    private String host;
    //@Value("${ss.port}")
    //private int port;

    public String getHost() {
        return host;

    }

    public void setHost(String host) {

        this.host = host;
    }

}
