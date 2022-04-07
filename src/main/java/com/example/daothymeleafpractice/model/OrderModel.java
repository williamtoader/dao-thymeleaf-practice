package com.example.daothymeleafpractice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderModel {
    public OrderModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    CustomerModel customerModel;

    @OneToMany
    Set<OrderDetailsModel> orderDetailsModels;
}
