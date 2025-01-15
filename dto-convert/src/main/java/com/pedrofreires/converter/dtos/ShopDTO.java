package com.pedrofreires.converter.dtos;

import java.util.Date;
import java.util.List;


public class ShopDTO {

    private Date created_at;

    private Float total;
    private List<ItemDTO> items;
    private String userIdentifier;

    public Date getCreated_at() {
        return created_at;
    }
    public Float getTotal() {
        return total;
    }
    public String getUserIdentifier() {
        return userIdentifier;
    }
    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> itemsDto) {
        this.items = itemsDto;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    public void setTotal(Float total) {
        this.total = total;
    }
    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }
}
