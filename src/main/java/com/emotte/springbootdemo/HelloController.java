package com.emotte.springbootdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Value(("${my.name}"))
    private String name;
    @Value(("${my.age}"))
    private int age;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot! 2018-11-08. name:" + name + ", age:" + age;
    }

    @RequestMapping(value = "/index")
    public String index(ModelMap map) {
        map.addAttribute("name","wang");
        return "index";
    }

}
