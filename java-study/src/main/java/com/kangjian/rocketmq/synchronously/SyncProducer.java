/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.rocketmq.synchronously;

import java.io.UnsupportedEncodingException;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import com.kangjian.commons.Configure;
import com.kangjian.commons.RemoteConfig;

public class SyncProducer {
    static Configure configure;
    static RemoteConfig remoteConfig;
    public static void main(String args[])
            throws MQClientException, RemotingException, InterruptedException, MQBrokerException,
            UnsupportedEncodingException {
        configure = Configure.get();
        remoteConfig = RemoteConfig.get();

        DefaultMQProducer producer = new DefaultMQProducer(configure.getMQGroup());
        System.out.println(remoteConfig.getRocketMQConfig());
        producer.setNamesrvAddr(remoteConfig.getRocketMQConfig());

        producer.start();

        for (int i=0; i < 10; i ++) {
            Message message = new Message(configure.getSyncTopic(), (i + "kj").getBytes("utf-8"));
            SendResult sendResult = producer.send(message);
            System.out.println(sendResult);
        }
        producer.shutdown();
    }
}
