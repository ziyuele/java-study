package com.ziyue.mybaits.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.InputStream;

public class MyBaitsDataSource {

    private static final Logger logger = Logger.getLogger(MyBaitsDataSource.class);

    public static SqlSessionFactory CreateSessionFactory() {
        logger.info("init sessionFactory");
        MyBaitsDataSource.class.getClassLoader().getResource("mybaits-config.xml");
        InputStream inputStream = MyBaitsDataSource.class.getClassLoader().getResourceAsStream("mybaits-config.xml");
        return  new SqlSessionFactoryBuilder().build(inputStream, "dev");
    }
}
