package com.kangjian.thriftstudy;

import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class ServerMain {

    private static int SERVICE_PORT = 8001;
    private static TServer server;

    private static void startServer() throws TTransportException {

//        TServerSocket tServer = new TServerSocket(SERVICE_PORT);
//        TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(tServer)
//                .protocolFactory(new TBinaryProtocol.Factory(true, true))
//                .processorFactory(new TProcessorFactory(new HelloService.AsyncProcessor<>(new HelloServiceImpl())))
//                .minWorkerThreads(3)
//                .maxWorkerThreads(5));
//        System.out.println("service start...");
//        server.serve();

        TProcessor tProcessor = new HelloService.AsyncProcessor<HelloService.AsyncIface>(new HelloServiceImpl());


        TServerTransport serverTransport = new TServerSocket(SERVICE_PORT);
        server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport)
                .processorFactory(new TProcessorFactory(tProcessor))
                .protocolFactory(new TBinaryProtocol.Factory(true, true)));
    }

    public static void main(String args[])throws  Exception {
        startServer();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Before Java8");
//            }
//        }).start();
        new Thread(() -> server.serve()).start();

    }
}
