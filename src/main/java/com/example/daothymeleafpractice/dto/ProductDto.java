package com.example.daothymeleafpractice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @JsonProperty(access = JsonProperty.Access.AUTO)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String name;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Float price;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Long quantity;
}
