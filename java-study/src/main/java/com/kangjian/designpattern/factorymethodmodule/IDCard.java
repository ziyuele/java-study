package com.kangjian.designpattern.factorymethodmodule;

public class IDCard extends Product{
    private String owner;

    IDCard(String owner) {
        System.out.println("creaet " + owner + "'s IDCard");
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void use() {
       System.out.println("use" + owner + "'s card");
    }
}
