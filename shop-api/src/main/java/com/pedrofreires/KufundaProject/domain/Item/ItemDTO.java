package com.pedrofreires.KufundaProject.domain.Item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemDTO {
    
    @NotBlank
    private String productIdentifier;

    @NotNull
    private Float price;

    public static ItemDTO convert(Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setPrice(item.getPrice());
        itemDTO.setProductIdentifier(item.getProductIdentifier());
        return itemDTO;
    }

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
