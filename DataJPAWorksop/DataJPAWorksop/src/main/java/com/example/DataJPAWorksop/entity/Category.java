package com.example.DataJPAWorksop.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy="category", cascade= CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Long getId(){
        return this.id;
    }
    public String getName(){
        return  this.name;
    }

    public List<Product> getProducts() {
        return products;
    }

    // Setter for products
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setName(String name) {
        this.name = name;
    }
}
