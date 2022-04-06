package com.example.daothymeleafpractice.dao;

import com.example.daothymeleafpractice.dto.OrderDetailsDto;
import com.example.daothymeleafpractice.dto.ProductDto;
import com.example.daothymeleafpractice.model.OrderDetailsModel;
import com.example.daothymeleafpractice.model.OrderModel;
import com.example.daothymeleafpractice.model.ProductModel;
import com.example.daothymeleafpractice.repositories.OrderDetailsRepository;
import com.example.daothymeleafpractice.repositories.OrderRepository;
import com.example.daothymeleafpractice.repositories.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class OrderDetailsDao {
    OrderDetailsRepository repository;
    OrderRepository orderRepository;
    ProductRepository productRepository;
    public OrderDetailsModel save(OrderDetailsDto dto) {
        return repository.save(new OrderDetailsModel(
                dto.getId(),
                dto.getName(),
                dto.getPrice(),
                dto.getQuantity(),
                orderRepository.getById(dto.getOrderId()),
                productRepository.getById(dto.getProductCode())
        ));
    }

    public void delete(OrderModel orderModel) {
        repository.deleteById(orderModel);
    }

    public OrderDetailsModel get(OrderModel orderModel) {
        return repository.getById(orderModel);
    }
}