package com.example.daothymeleafpractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {
    public OrderModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    CustomerModel customerModel;

    @ManyToMany
    Set<ProductModel> productModelList;
}
