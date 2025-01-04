package com.pedrofreires.KufundaProject.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrofreires.KufundaProject.domain.categories.Category;


@Repository
public interface CategorieRepository extends JpaRepository<Category, Long>{

    // quando for usar  o query buscar campos por meios das tabelas tipo c.[attribute]
    @Query(value= "select c from category c where LOWER(c.nome) like :nome% ")
    public List<Category> searchCategoriesByName(@Param("nome") String nome);
}
