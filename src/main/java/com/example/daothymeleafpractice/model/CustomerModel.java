package com.example.daothymeleafpractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor

public class CustomerModel {
    public CustomerModel(Long id, String name, String username, String country, String city) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.country = country;
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    private String username;
    private String country;
    private String city;

    @OneToMany
    List<OrderModel> orderModelList;

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city;
    }
}
