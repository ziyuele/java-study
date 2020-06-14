--- init database (test)
create database test;

-- init tables (test_table)
CREATE table if not exists test_table (
                                          `id` int auto_increment COMMENT '自增主键',
                                          `name` varchar(255) COMMENT '姓名',
                                          `age` int        COMMENT '年龄',
                                          PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4 COMMENT '测试表'