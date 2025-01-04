package com.pedrofreires.KufundaProject.domain.products;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    }
}
