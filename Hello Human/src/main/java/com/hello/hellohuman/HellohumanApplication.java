package com.hello.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HellohumanApplication {
    public static void main(String[] args) {
        SpringApplication.run(HellohumanApplication.class, args);
    }
    @RequestMapping("/")
    public String index(@RequestParam(value = "name",required=false) String firstname,@RequestParam(value = "last",required=false) String lastname) {
    if (firstname == null){
        return "<h1>Hello Human!</h1>" + "\n" + "<h3>Welcome to Spring Boot!</h3>";
    }
    else
        return "<h1>Hello " + firstname + " " +lastname + "</h1>" + "\n" + "<h3>Welcome to Spring Boot!</h3>";
    }
}


