package com.pedrofreires.KufundaProject.domain.products;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.pedrofreires.KufundaProject.domain.categories.CategoryDTO;



public class ProductDTO {

    @NotBlank
    private String productIdentifier;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private Float preco;

    @NotNull
    private CategoryDTO category;

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setDescricao(product.getDescricao());
        productDTO.setProductIdentifier( product.getProductIdentifier() );

        if (product.getCategory() != null) {
            productDTO.setCategory( CategoryDTO.convert(product.getCategory()) );
        }
        return productDTO;
    }

    public CategoryDTO getCategory() {
        return category;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getNome() {
        return nome;
    }
    public Float getPreco() {
        return preco;
    }
    public String getProductIdentifier() {
        return productIdentifier;
    }
    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }
    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }
}