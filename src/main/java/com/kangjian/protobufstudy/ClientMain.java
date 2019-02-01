package com.kangjian.protobufstudy;

import com.kangjian.rpc.PersonServiceGrpc;
import com.kangjian.rpc.RPCDemo.Response;
import com.kangjian.rpc.RPCDemo.Person;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientMain {
    private static ManagedChannel channel;
    private static PersonServiceGrpc.PersonServiceBlockingStub stub;

    public static void main(String args[]) {
        channel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext(true).build();
        stub = PersonServiceGrpc.newBlockingStub(channel);
        Person person = Person.newBuilder().setAget(12).setMail("asdfsa@XX.com").setName("test").setId(1).build();
        Response response = stub.createPerson(person);
        System.out.println(response.toString() + "dfdfdfdff");
    }

}
