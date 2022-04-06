package com.example.daothymeleafpractice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto {
    @JsonProperty(access = JsonProperty.Access.AUTO)
    private Long id;
    private Long orderId;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Float price;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Long quantity;

    private String productCode;
}
