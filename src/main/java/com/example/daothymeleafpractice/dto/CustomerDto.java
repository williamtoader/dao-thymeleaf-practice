package com.example.daothymeleafpractice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    @JsonProperty()
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String name;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String username;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String country;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String city;

}
