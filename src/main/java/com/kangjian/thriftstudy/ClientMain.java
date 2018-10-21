package com.kangjian.thriftstudy;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;

public class ClientMain {
    private static int SERVICE_PORT = 8001;
    private static int RPC_TIME_OUT = 10000;

    private static void  buildRequest() throws TException {
        String username = "test";
        TTransport tTransport = new TFramedTransport(new TSocket("127.0.0.1", SERVICE_PORT, RPC_TIME_OUT));
        tTransport.open();
        TProtocol protocol = new TBinaryProtocol(tTransport);
        HelloService.Client client = new HelloService.Client(protocol);

        client.hello(username);
        //System.out.println(result);
    }

    public static void main(String args[]) throws Exception{
        buildRequest();
    }
}
