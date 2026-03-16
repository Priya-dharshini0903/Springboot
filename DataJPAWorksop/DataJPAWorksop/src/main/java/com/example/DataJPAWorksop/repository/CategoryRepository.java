package com.example.DataJPAWorksop.repository;

import com.example.DataJPAWorksop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
