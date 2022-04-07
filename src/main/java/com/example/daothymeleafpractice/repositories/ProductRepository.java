package com.example.daothymeleafpractice.repositories;

import com.example.daothymeleafpractice.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, String> {
}
