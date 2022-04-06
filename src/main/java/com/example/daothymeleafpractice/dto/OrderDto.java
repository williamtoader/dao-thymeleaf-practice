package com.example.daothymeleafpractice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @JsonProperty(access = JsonProperty.Access.AUTO)
    private Long customerId;
}
