/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.study.protobufstudy;

import com.googlecode.protobuf.format.JsonFormat;
import com.kangjian.rpc.RPCDemo;

public class ProtoToJson {
    /**
     * proto 转化成json-string
     * 在返回的过程中可以使用ObjectMapper readTree 这样返回的是正常的json结构
     * @param args
     */
    public static void main(String args[]) {
        RPCDemo.Person person = RPCDemo.Person.newBuilder()
                .setAget(12).setMail("asdfsa@XX.com")
                .setName("test")
                .setId(1)
                .build();
        System.out.println(JsonFormat.printToString(person));

    }
}
