package ru.gocinema.rest.controllers;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public HelloWorld helloWorld() {
        return HelloWorld.builder()
                .now(LocalDateTime.now())
                .build();
    }

    @Value
    @Builder
    public static class HelloWorld {
        LocalDateTime now;
    }
}
