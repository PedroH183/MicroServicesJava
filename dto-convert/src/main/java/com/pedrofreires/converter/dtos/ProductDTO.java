package com.pedrofreires.converter.dtos;

public class ProductDTO {

    private String nome;
    private Float preco;
    private String descricao;
    private CategoryDTO category;
    private String productIdentifier;

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