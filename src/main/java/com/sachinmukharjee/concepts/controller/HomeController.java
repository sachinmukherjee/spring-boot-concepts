package com.sachinmukharjee.concepts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    @RequestMapping(method = RequestMethod.GET,value = "/home")
    @ResponseBody
    public String home(){
        return "Home...";
    }
}
