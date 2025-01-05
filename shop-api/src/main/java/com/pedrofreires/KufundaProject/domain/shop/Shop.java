package com.pedrofreires.KufundaProject.domain.shop;

import com.pedrofreires.KufundaProject.domain.Item.Item;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float total;
    private Date date;
    private String userIdentifier;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))
    private List<Item> items;

    public static Shop convert(ShopDTO shopDTO){
        Shop shop = new Shop();
        shop.setTotal(shopDTO.getTotal());
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setCreated_at(shopDTO.getCreated_at());

        shop.setItems(shopDTO
                        .getItems()
                        .stream()
                        .map(Item::convert)
                        .collect(Collectors.toList())
        );
        return shop;
    }

    public Long getId() {
        return id;
    }
    public Float getTotal() {
        return total;
    }
    public String getUserIdentifier() {
        return userIdentifier;
    }
    public Date getCreated_at() {
        return date;
    }
    public List<Item> getItems(){
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public void setCreated_at(Date created_at) {
        this.date = created_at;
    }
    public void setTotal(Float total) {
        this.total = total;
    }
    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }
}
