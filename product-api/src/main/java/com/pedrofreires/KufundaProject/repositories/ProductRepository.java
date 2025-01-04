package com.pedrofreires.KufundaProject.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pedrofreires.KufundaProject.domain.products.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query(
        value = "select p from product p join category c on p.category.id = c.id where c.id = :categoryId"
    )
    public List<Product> getProductByCategoryId(@Param("categoryId") Long categoryId);
    public Product findByProductIdentifier(String productIndentifier);
}
