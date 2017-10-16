package com.kangjian.thrifts;

import com.kangjian.thrift.api.HelloService;
import com.kangjian.thrift.api.HelloServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThriftServer {
    public ThriftServer(){}
    int port = 10000;
    private Logger logger = LoggerFactory.getLogger(ThriftServer.class);
    private TServer server = null;
    public void start()throws TTransportException {
        //trans level (Transport) set lestion port   chuan shu ceng
        TServerSocket socket = new TServerSocket(port);
        // proto level  xie yi ceng
        TBinaryProtocol.Factory protoFactory = new TBinaryProtocol.Factory(true,true);
        //service level chu li ceng
        HelloService.Processor processor = new HelloService.Processor(new HelloServiceImpl());
        // service level   fu wu  cong
        server = new TThreadPoolServer(new TThreadPoolServer.Args(socket)
        .protocolFactory(protoFactory)
        .processor(processor));

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        server.serve();
                    }
                }
        ).start();
        //logger.info("service start port:" + port);
        System.out.println("service started port:" + port);

    }
    public void close(){
        server.stop();
    }

}