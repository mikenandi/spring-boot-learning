package com.example.demo;
import java.util.List;
//import java.util.logging.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import welcome.message.WelcomeMessage;


@SpringBootApplication
@RestController
public class   DemoApplication {
    // public  static  final Logger log =  LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
    }
}