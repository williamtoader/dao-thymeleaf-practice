package com.example.daothymeleafpractice.repositories;

import com.example.daothymeleafpractice.model.AuthEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthEntityRepository extends JpaRepository<AuthEntityModel, String> {
}
