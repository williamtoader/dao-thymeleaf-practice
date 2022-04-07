package com.example.daothymeleafpractice.dao;

import com.example.daothymeleafpractice.dto.OrderDetailsDto;
import com.example.daothymeleafpractice.model.OrderDetailsModel;
import com.example.daothymeleafpractice.model.OrderModel;
import com.example.daothymeleafpractice.repositories.OrderDetailsRepository;
import com.example.daothymeleafpractice.repositories.OrderRepository;
import com.example.daothymeleafpractice.repositories.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class OrderDetailsDao {
    @Autowired
    OrderDetailsRepository repository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    public OrderDetailsModel save(OrderDetailsDto dto) {
        return repository.save(new OrderDetailsModel(
                dto.getId(),
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
