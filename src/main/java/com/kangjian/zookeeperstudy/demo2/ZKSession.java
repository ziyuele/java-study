package com.kangjian.zookeeperstudy.demo2;

import java.util.List;

public interface ZKSession {

    /**
     *  create zk path
     * @param path zk path
     */
    void create(String path);

    /**
     *  create zk path and write data
     * @param path zk path
     * @param data data to write
     */
    void create(String path, String data);

    /**
     * delete  zk path
     * @param path zk path
     */
    void delete(String path);

    /**
     *  upadate data path data
     * @param path zk path
     * @param data data to wirte
     */
    void update(String path, String data);

    /**
     *  get data from zk path
     * @param path zk path
     * @return data from path
     */
    String get(String path);

    /**
     *  get node children from zk path
     * @param path zk path
     * @return child list
     */
    List<String> child(String path);
}
