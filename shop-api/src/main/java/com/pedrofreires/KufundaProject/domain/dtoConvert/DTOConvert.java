package com.pedrofreires.KufundaProject.domain.dtoConvert;

import java.util.stream.Collectors;

import com.pedrofreires.converter.dtos.ItemDTO;
import com.pedrofreires.converter.dtos.ShopDTO;
import com.pedrofreires.KufundaProject.domain.Item.Item;
import com.pedrofreires.KufundaProject.domain.shop.Shop;


public class DTOConvert {

    public static ItemDTO convert(Item item){
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setPrice(null);
        itemDTO.setProductIdentifier(null);

        return itemDTO;
    }

    public static ShopDTO convert(Shop shop){
        ShopDTO shopDTO = new ShopDTO();

        shopDTO.setCreated_at(shop.getCreated_at());
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setUserIdentifier(shop.getUserIdentifier());

        shopDTO.setItems(
            shop.getItems().stream().map(DTOConvert::convert).collect(Collectors.toList())
        );

        return shopDTO;
    }
}
