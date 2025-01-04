package com.pedrofreires.KufundaProject.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pedrofreires.KufundaProject.domain.products.ProductDTO;
import com.pedrofreires.KufundaProject.domain.products.ProductNotFoundException;
import com.pedrofreires.KufundaProject.services.ProductService;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<ProductDTO> getProducts() {
        return productService.getAll();
    }

    @GetMapping("/product/category/{categoryId}")
    public List<ProductDTO> getProductByCategory( @PathVariable Long categoryId ) { 
        return productService.getProductByCategoryId(categoryId);
    }

    @GetMapping("/product/{productIdentifier}")
        ProductDTO findById(@PathVariable String productIdentifier) {
        return productService.findByProductIdentifier(productIdentifier);
    }

    @PostMapping("/product")
    ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @DeleteMapping("/product/{id}")
    Boolean delete(@PathVariable Long id) throws ProductNotFoundException {
        return productService.delete(id);
    }
}