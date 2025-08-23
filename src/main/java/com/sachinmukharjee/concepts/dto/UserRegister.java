package com.sachinmukharjee.concepts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegister {

    private String userName;
    private String password;
    private String encodedPassword;
    private List<String> role;
}
