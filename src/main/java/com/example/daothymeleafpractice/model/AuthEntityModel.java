package com.example.daothymeleafpractice.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class AuthEntityModel {
    @Id
    String username;

    private String passwordHash;

    @Transient
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public Boolean validatePassword(String plainTextPassword) {
        return passwordEncoder.matches(plainTextPassword, this.passwordHash);
    }

    public void setPassword(String plainTextPassword) {
        this.passwordHash = passwordEncoder.encode(plainTextPassword);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}