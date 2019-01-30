package com.kangjian.protobufstudy;

public class Main {
    public static void main (String args[]) {
        GRPCServer server = new GRPCServer(new ServerClientProtoHandler());
        server.start();
    }
}
