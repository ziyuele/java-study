package com.kangjian.study.protobufstudy;

public class ServerMain {
    public static void main (String args[]) throws Exception{
        GRPCServer server = new GRPCServer(new ServerClientProtoHandler());
        server.start();
    }
}
