package com.kangjian.designpattern.prototypemodule;

public class UnderlinePen implements Product{

    private char unlinechar;

    public UnderlinePen(char unlinechar){
        this.unlinechar = unlinechar;
    }

    @Override
    public void use(String s) {
       System.out.println("\"" + s + "\"");
       for (int x = 0; x < s.length() + 2 ; x++){
           System.out.print(unlinechar);
       }
       System.out.println();

    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
