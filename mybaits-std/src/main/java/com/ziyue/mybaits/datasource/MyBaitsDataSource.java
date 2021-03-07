package com.ziyue.mybaits.datasource;

        import org.apache.ibatis.mapping.Environment;
        import org.apache.ibatis.session.Configuration;
        import org.apache.ibatis.session.SqlSessionFactory;
        import org.apache.ibatis.session.SqlSessionFactoryBuilder;
        import org.apache.log4j.Logger;

        import javax.sql.DataSource;
        import java.io.InputStream;
        import java.io.PrintWriter;
        import java.sql.Connection;
        import java.sql.SQLException;
        import java.sql.SQLFeatureNotSupportedException;

public class MyBaitsDataSource {

    private static final Logger logger = Logger.getLogger(MyBaitsDataSource.class);

    /**
     *  通过XML配置文件创建SqlSessionFactory
     * @return
     */
    public static SqlSessionFactory createSessionFactoryWithXML() {
        InputStream inputStream = MyBaitsDataSource.class.getClassLoader().getResourceAsStream("mybaits-config.xml");
        return  new SqlSessionFactoryBuilder().build(inputStream, "dev");
    }

    /**
     *  通过Propreties 文件创建SqlSessionFactory
     * @return
     */
    public static SqlSessionFactory createSessionFactoryWithProperties() {
        Configuration configuration = new Configuration();
        //Environment environment = new Environment();
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        return null;
    }
}
