package com.pedrofreires.KufundaProject.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pedrofreires.converter.dtos.ProductDTO;

@Service
class ProductService{

    public ProductDTO getProductByIndentifier(String indentifier){
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/product/" + indentifier;

        ResponseEntity<ProductDTO> responseEntity = restTemplate
                                .getForEntity(url, ProductDTO.class);

        return responseEntity.getBody();
    }
}