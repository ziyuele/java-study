package com.kangjian.protobufstudy;

import com.kangjian.rpc.PersonServiceGrpc;
import com.kangjian.rpc.RPCDemo.Person;
import com.kangjian.rpc.RPCDemo.IdRequest;
import com.kangjian.rpc.RPCDemo.Response;

import io.grpc.stub.StreamObserver;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class ServerClientProtoHandler extends PersonServiceGrpc.PersonServiceImplBase {

    @Override
    public void createPerson(Person request, StreamObserver<Response> responseObserver) {
        Person.Builder person = Person.newBuilder();
        person.setAget(1).setId(0).setName("kangjian").setMail("xxx@xx.com");
        Response.Builder response = Response.newBuilder().setPerson(person.build());
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getPerson(IdRequest request, StreamObserver<Response> responseObserver) {
        super.getPerson(request, responseObserver);
    }

    @Override
    public void updatePerson(IdRequest request, StreamObserver<Response> responseObserver) {
        super.updatePerson(request, responseObserver);
    }

    @Override
    public void deletePerson(IdRequest request, StreamObserver<Response> responseObserver) {
        super.deletePerson(request, responseObserver);
    }
}
