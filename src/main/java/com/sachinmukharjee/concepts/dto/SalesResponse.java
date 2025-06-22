package com.sachinmukharjee.concepts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesResponse {

    private String country;
    private String city;
    private String state;
    private String region;
    private Double sales;
}
