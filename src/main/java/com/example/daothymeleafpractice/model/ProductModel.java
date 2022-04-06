package com.example.daothymeleafpractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class ProductModel {
    public ProductModel(String productCode, String productName, Float productPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Id
    String productCode;

    String productName;
    Float productPrice;

    @OneToMany
    Set<OrderDetailsModel> orderDetailsModels;
}
