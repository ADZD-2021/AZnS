package com.example.projekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProjektApplication {

    @GetMapping("/test")
    public String test(){
        return "Testowe API";
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjektApplication.class, args);
    }

}
