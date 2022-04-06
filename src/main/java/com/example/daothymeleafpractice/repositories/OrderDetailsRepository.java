package com.example.daothymeleafpractice.repositories;

import com.example.daothymeleafpractice.model.OrderDetailsModel;
import com.example.daothymeleafpractice.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsModel, OrderModel> {
}
