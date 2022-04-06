package com.example.daothymeleafpractice.repositories;

import com.example.daothymeleafpractice.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    public List<OrderModel> getAllByCustomerModel_Id(Long customerId);
}
