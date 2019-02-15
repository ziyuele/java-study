package com.kangjian.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;
import java.util.regex.Pattern;

public class SerializableTest {

    public static void main(String args[]) throws Exception{

        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);

        UUID uuidl = UUID.randomUUID();
        System.out.println(uuidl);
        System.exit(0);


        String file = "SerializableData";
        SerializableBean serializableBean = new SerializableBean("kangjian", 13, "man");
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(serializableBean);
        objectOutputStream.flush();
        objectOutputStream.close();

        Thread.sleep(3);
        System.out.println("start to read object from file");

        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(file));
        SerializableBean serializableBean1 = (SerializableBean) objectInputStream.readObject();
        System.out.println(serializableBean1.toString());
    }
}
