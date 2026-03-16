package com.example.DataJPAWorksop.repository;

import com.example.DataJPAWorksop.dto.ProductDTO;
import com.example.DataJPAWorksop.entity.Product;
import com.example.DataJPAWorksop.projection.ProductView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<ProductView> findByPriceGreaterThan(double price);
    List<ProductDTO> findByNameContaining(String name);
}
