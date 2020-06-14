package com.kangjian.study.protobufstudy;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 *  this is grpc server  binding on port : 8899
 */

@Slf4j
public class GRPCServer {
    private Server server;
    private ServerClientProtoHandler handler;

    public GRPCServer(ServerClientProtoHandler handler) {
        this.handler = handler;
    }
    public void start () {
        try {
            log.info("server start on port: {}", 8899);
           this.server = ServerBuilder.forPort(8899).addService(handler).build().start();
           this.server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
