package com.pedrofreires.KufundaProject.domain.categories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String nome;

    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Category convert(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setNome(categoryDTO.getNome());
        return category;
    }
}
