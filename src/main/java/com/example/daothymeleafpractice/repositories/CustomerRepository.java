package com.example.daothymeleafpractice.repositories;

import com.example.daothymeleafpractice.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
}
