package com.kangjian.designpattern.singletonmodule;

import java.util.Objects;

public class Test {
    private int x;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return x == test.x;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x);
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {

        this.x = x;
    }
}
