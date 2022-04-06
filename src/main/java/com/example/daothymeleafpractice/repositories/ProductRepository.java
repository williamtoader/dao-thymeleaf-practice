package com.example.daothymeleafpractice.repositories;

import com.example.daothymeleafpractice.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
