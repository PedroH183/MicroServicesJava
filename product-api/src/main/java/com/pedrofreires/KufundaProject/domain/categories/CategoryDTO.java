package com.pedrofreires.KufundaProject.domain.categories;

import javax.validation.constraints.NotNull;

public class CategoryDTO {
    // Data Transfer Object to Category

    @NotNull
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

    public static CategoryDTO convert(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }
}
