package com.example.daothymeleafpractice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@Data
public class OrderDetailsModel {
    public OrderDetailsModel(Long id, Float price, Long quantity, OrderModel orderModel, ProductModel productModel) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.orderModel = orderModel;
        this.productModel = productModel;
    }

    private Float price;
    private Long quantity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    OrderModel orderModel;

    @ManyToOne
    ProductModel productModel;
}
