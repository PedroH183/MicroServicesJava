package com.pedrofreires.converter.dtos;

public class ItemDTO {

    private String productIdentifier;
    private Float price;

    public Float getPrice() {
        return price;
    }
    public String getProductIdentifier() {
        return productIdentifier;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }
}