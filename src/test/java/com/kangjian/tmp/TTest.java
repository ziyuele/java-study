/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import org.junit.Test;

public class TTest {

    private DataSourceType type;
    private String name;

    public DataSourceType getType() {
        return type;
    }

    public void setType(DataSourceType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    enum DataSourceType {
        SCM("scm://"), HDFS("hdfs://"), P2P("p2p://"), FTP("ftp://"), HTTP("http://"), HTTPS("https://"), REF("ref://");

        private String prefix;

        DataSourceType(String prefix) {
            this.prefix = prefix;
        }

        public String getPrefix() {
            return prefix;
        }
     }



}
