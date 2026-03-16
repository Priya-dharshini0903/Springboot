package com.example.DataJPAWorksop.service;

import com.example.DataJPAWorksop.dto.ProductDTO;
import com.example.DataJPAWorksop.entity.Category;
import com.example.DataJPAWorksop.entity.Product;
import com.example.DataJPAWorksop.projection.ProductView;
import com.example.DataJPAWorksop.repository.CategoryRepository;
import com.example.DataJPAWorksop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

        //1. Field Injection 2. Constructor Injection 3. Setter Injection
        private final ProductRepository repo;
        private final CategoryRepository catRepo;

    @Autowired
    public ProductService(ProductRepository repo, CategoryRepository catRepo) {
        this.repo = repo;
        this.catRepo = catRepo;
    }

        public String createProduct(Product product) {
            System.out.println("Creating product: " + product.getName());
            System.out.println("Category: " + product.getCategory().getName());

            Category category = new Category();
            category.setName(product.getCategory().getName());

            product.setCategory(category);
            category.getProducts().add(product);


            catRepo.save(category);
            repo.save(product);
            return "Category & Product is created successfully";
        }

        public List<Product> getAllProducts() {
            return repo.findAll();
        }

    public List<Product> getProductsWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        // select * from product order by name asc limit size offset page*size
        return repo.findAll(pageable).getContent();
    }

    public List<ProductView> getProductsWithProjection(double price) {
        return repo.findByPriceGreaterThan(price);
    }

    public List<ProductDTO> getProductByName(String name){
            return repo.findByNameContaining(name);
    }

}

