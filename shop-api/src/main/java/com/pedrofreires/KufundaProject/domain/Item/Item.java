package com.pedrofreires.KufundaProject.domain.Item;

import javax.persistence.Embeddable;
import com.pedrofreires.converter.dtos.ItemDTO;

@Embeddable
public class Item {

    private Float price;
    private String productIdentifier;

    public static Item convert(ItemDTO itemDTO){
        Item item = new Item();
        item.setPrice(itemDTO.getPrice());
        item.setProductIdentifier(itemDTO.getProductIdentifier());
        return item;
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
