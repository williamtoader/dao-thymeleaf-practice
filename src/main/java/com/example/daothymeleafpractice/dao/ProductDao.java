package com.example.daothymeleafpractice.dao;

import com.example.daothymeleafpractice.dto.ProductDto;
import com.example.daothymeleafpractice.model.OrderModel;
import com.example.daothymeleafpractice.model.ProductModel;
import com.example.daothymeleafpractice.repositories.CustomerRepository;
import com.example.daothymeleafpractice.repositories.OrderRepository;
import com.example.daothymeleafpractice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public class ProductDao {
    @Service
    @RequiredArgsConstructor
    public class OrderDao {
        ProductRepository repository;
        OrderRepository orderRepository;

        public ProductModel create(ProductDto dto) {
            return repository.save(new ProductModel(
                    dto.getId(),
                    dto.getName(),
                    dto.getPrice(),
                    dto.getQuantity()
            ));
        }

        public void delete(Long id) {
            repository.deleteById(id);
        }

        public ProductModel get(Long id) {
            return repository.getById(id);
        }

        public List<ProductModel> getAllByOrderId(Long id) {
            return repository.fi
        }
    }
}
