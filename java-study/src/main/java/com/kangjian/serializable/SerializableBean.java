package com.kangjian.serializable;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SerializableBean implements Serializable {
    private String name;
    private int age;
    private String sex;

    public SerializableBean(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public SerializableBean() {}

    @Override
    public String toString() {
        return "SerializableBean{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", sex='" + sex + '\''
                + '}';
    }
}
