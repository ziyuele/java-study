package com.kangjian.tmp;

import com.sun.deploy.security.ValidationState;

/**
 * test for 范型
 */

public class Tmp5 {
    public static void main(String args[]){
        String s = new Test<String>("kangjian").getT();
        System.out.println(s);
    }

}
class Test<TYPE>{
    TYPE T;
    Test(TYPE T){
        this.T = T;
    }
    public TYPE getT(){
        return this.T;
    }
}

