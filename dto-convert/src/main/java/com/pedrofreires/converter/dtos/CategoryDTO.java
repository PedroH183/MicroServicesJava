package com.pedrofreires.converter.dtos;

public class CategoryDTO {
    // Data Transfer Object to Category

    private Long id;
    private String nome;

    public String getNome() {
        return nome;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}