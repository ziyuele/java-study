/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.rocketmq.synchronously;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import com.kangjian.commons.Configure;
import com.kangjian.commons.RemoteConfig;

public class Consumer {
    static Configure configure;
    static RemoteConfig remoteConfig;

    public static void main(String args[]) throws MQClientException {
        configure = Configure.get();
        remoteConfig = RemoteConfig.get();
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(configure.getMQGroup());
        consumer.setNamesrvAddr(remoteConfig.getRocketMQConfig());
        consumer.subscribe(configure.getSyncTopic(), "*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                            ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
                    try {
                        System.out.print(new String(messageExt.getBody(), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();

    }
}
