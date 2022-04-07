package com.example.daothymeleafpractice.repositories;

import com.example.daothymeleafpractice.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
    List<CustomerModel> findAllByUsername(String username);
    List<CustomerModel> findAllByCountry(String country);
    List<CustomerModel> findAllByCity(String country);
}
