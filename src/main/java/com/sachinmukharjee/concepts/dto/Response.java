package com.sachinmukharjee.concepts.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response<T> {

    private String requestId;
    private boolean success;
    private T data;
    private Error error;
}
