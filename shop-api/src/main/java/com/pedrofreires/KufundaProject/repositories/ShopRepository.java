package com.pedrofreires.KufundaProject.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrofreires.KufundaProject.domain.shop.Shop;


@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{

    List<Shop> findAllByDateGreaterThanEqual(Date date);
    public List<Shop> findAllByTotalGreaterThan(Float total);
    public List<Shop> findAllByUserIdentifier(String userIdentifier);
}
