package com.example.daothymeleafpractice.dao;

import com.example.daothymeleafpractice.dto.ProductDto;
import com.example.daothymeleafpractice.model.ProductModel;
import com.example.daothymeleafpractice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDao {
    @Autowired
    ProductRepository repository;
    public ProductModel save(ProductDto dto) {
        return repository.save(new ProductModel(dto.getProductCode(), dto.getProductName(), dto.getProductPrice()));
    }

    public void delete(String productCode) {
        repository.deleteById(productCode);
    }

    public ProductModel get(String productCode) {
        return repository.getById(productCode);
    }
}
