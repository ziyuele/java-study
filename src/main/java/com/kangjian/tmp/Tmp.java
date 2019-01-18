package com.kangjian.tmp;

/**
 * jstack test
 */
public class Tmp {
    public  static void main(String args[]){
        while (true){
            System.out.println("ddd");
            int a = new Test(3).getX();
            System.out.println(a);

        }
    }
}

class Test{
    private final int x;
    public Test(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
