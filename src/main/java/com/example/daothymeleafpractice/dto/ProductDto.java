package com.example.daothymeleafpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    String productCode;
    String productName;
    Float productPrice;
}
