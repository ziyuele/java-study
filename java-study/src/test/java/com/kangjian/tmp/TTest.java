/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import com.google.errorprone.annotations.SuppressPackageLocation;
import com.kangjian.util.Json1Bean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
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

    @Test
    public void testChange() {
        Json1Bean bean = new Json1Bean();
        log.info(bean.toString());

    }


}
