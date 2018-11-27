package com.kangjian.designpattern.adaptermodule1;

public abstract class Bander {
    private String string;

    public Bander(String sting){
        this.string = sting;
    }

    public void showWithParen(){
        System.out.println( "("+ string + ")" );
    }

    public void showWithAster(){
        System.out.println( "*" + string + "*" );
    }
}
