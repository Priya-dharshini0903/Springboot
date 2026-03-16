package com.example.DataJPAWorksop.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminator;

@Entity
@Table(name="products")
public class Product {
        //ORM - Object Relational Mapping

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;  // column

        @Column(name = "product_name", nullable = false, length = 100)
        String name;

        @Column(nullable = false)
        double price;

        String description;

        @ManyToOne
        @JoinColumn(name="category_id")
        private Category category;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }

    public Category getCategory(){
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
