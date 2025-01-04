package com.pedrofreires.KufundaProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedrofreires.KufundaProject.services.CategorieService;
import com.pedrofreires.KufundaProject.domain.categories.Category;
import com.pedrofreires.KufundaProject.domain.categories.CategoryDTO;


@RestController
public class CategoryController{

    @Autowired
    CategorieService categorieService;


    @GetMapping("/category")
    public List<Category> getAllCategories() {
        return categorieService.getAll();
    }

    @GetMapping("/category/search")
    public List<Category> getCategoryByName(@RequestParam(name="nome", required = true) String nome) {
        return categorieService.getCategoriesByName(nome);
    }

    @PostMapping("/category")
    public Long createCategory(@RequestBody CategoryDTO categoryDTO){
        return categorieService.createNewCategory(categoryDTO);
    }

    @DeleteMapping("/category/{id}")
    public Boolean deleteCategory(@PathVariable Long id){
        return categorieService.deleteById(id);
    }
}