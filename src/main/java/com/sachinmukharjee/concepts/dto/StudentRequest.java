package com.sachinmukharjee.concepts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private String name;
    private String course;
    private StudentCardRequest cardDetail;
}
