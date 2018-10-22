package com.kangjian.springbootstudy.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
@ConfigurationProperties(prefix = "ss", ignoreUnknownFields = false)
public class ReadConf {
    private String host;
    private int port;

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;

    }

    public void setPort(int port) {

        this.port = port;
    }

    public void setHost(String host) {

        this.host = host;
    }
}
