package com.example.DataJPAWorksop.controller;


import com.example.DataJPAWorksop.dto.ProductDTO;
import com.example.DataJPAWorksop.entity.Product;
import com.example.DataJPAWorksop.projection.ProductView;
import com.example.DataJPAWorksop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //vs @Controller
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping("/products")
    public String createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping("/products/page/{page}/size/{size}")
    public List<Product> getByPagination(@PathVariable int page, @PathVariable int size) {
        return service.getProductsWithPagination(page, size);
    }

    @GetMapping("/products/price/{price}")
    public List<ProductView> getProductByprice(@PathVariable int price) {
        return service.getProductsWithProjection(price);
    }

    @GetMapping("/products/name/{name}")
    public List<ProductDTO> getProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }


}