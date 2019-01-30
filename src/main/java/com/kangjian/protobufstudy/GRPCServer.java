package com.kangjian.protobufstudy;

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

    public GRPCServer(ServerClientProtoHandler handler) {
       this.server = ServerBuilder.forPort(8899)
               .addService(handler).build();
    }
    public void start () {
        try {
            log.info("server start on port: {}", this.server.getPort());
            server.start();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
