package com.pedrofreires.KufundaProject.domain.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pedrofreires.KufundaProject.domain.Item.ItemDTO;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ShopDTO {

    private Date created_at;

    @NotNull
    private Float total;

    @NotBlank
    private String userIdentifier;

    @NotNull
    private List<ItemDTO> itemsDto;

    public static ShopDTO convert(Shop shop){
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setCreated_at(shop.getCreated_at());
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        return shopDTO;
    }

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
        if(itemsDto == null){
            return new ArrayList<>();
        }
        return itemsDto;
    }

    public void setItems(List<ItemDTO> itemsDto) {
        this.itemsDto = itemsDto;
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
