/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.rocketmq.synchronously;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MessageQueueDTO {

    private long createTime;
    public MessageQueueDTO() {
        this.createTime = System.currentTimeMillis();
    }
}
