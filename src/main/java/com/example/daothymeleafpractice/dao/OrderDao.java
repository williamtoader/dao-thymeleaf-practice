package com.example.daothymeleafpractice.dao;

import com.example.daothymeleafpractice.model.OrderModel;
import com.example.daothymeleafpractice.repositories.CustomerRepository;
import com.example.daothymeleafpractice.repositories.OrderRepository;
import com.example.daothymeleafpractice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDao {
    OrderRepository repository;
    CustomerRepository customerRepository;
    ProductRepository productRepository;

    public OrderModel save(Long customerId) {
        return repository.save(new OrderModel(customerRepository.getById(customerId)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public OrderModel get(Long id) {
        return repository.getById(id);
    }

    public List<OrderModel> getAllByCustomerId(Long id) {
        return repository.getAllByCustomerModel_Id(id);
    }
}
