package com.pedrofreires.KufundaProject.domain.products;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import com.pedrofreires.KufundaProject.domain.categories.Category;

@Entity(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Float preco;
    private String descricao;
    private String productIdentifier;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public static Product convert(ProductDTO productDTO) {

        Product product = new Product();

        product.setNome(productDTO.getNome());
        product.setPreco(productDTO.getPreco());
        product.setDescricao(productDTO.getDescricao());
        product.setProductIdentifier( productDTO.getProductIdentifier());

        if (productDTO.getCategory() != null) {
            product.setCategory( Category.convert( productDTO.getCategory() ) );
        }
        return product;
    }

    public Category getCategory() {
        return category;
    }
    public String getDescricao() {
        return descricao;
    }
    public long getId() {
        return id;
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

    public void setCategory(Category category) {
        this.category = category;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setId(long id) {
        this.id = id;
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