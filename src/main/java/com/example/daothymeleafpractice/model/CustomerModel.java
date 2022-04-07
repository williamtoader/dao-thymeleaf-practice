package com.example.daothymeleafpractice.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString

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
    private Long id;
    private String name;

    private String username;
    private String country;
    private String city;

    @OneToMany
    List<OrderModel> orderModelList;
}
