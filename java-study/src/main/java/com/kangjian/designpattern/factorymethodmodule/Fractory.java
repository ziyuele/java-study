package com.kangjian.designpattern.factorymethodmodule;

public abstract  class Fractory {
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);

    public final Product create(String owner) {
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }
}
