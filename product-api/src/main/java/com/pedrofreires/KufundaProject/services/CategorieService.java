package com.pedrofreires.KufundaProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.pedrofreires.KufundaProject.domain.categories.Category;
import com.pedrofreires.KufundaProject.domain.categories.CategoryDTO;
import com.pedrofreires.KufundaProject.repositories.CategorieRepository;


@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;


    public List<Category> getAll(){
        return categorieRepository.findAll();
    }

    public Long createNewCategory(CategoryDTO categoryDTO){
        Category category = categorieRepository.save(Category.convert(categoryDTO));
        return category.getId();
    }

    public Boolean deleteById(Long id){
        Optional<Category> category = categorieRepository.findById(id);

        if( category.isPresent() ){
            categorieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Category> getCategoriesByName(String nome) {
        return categorieRepository.searchCategoriesByName(nome);
    }
}
