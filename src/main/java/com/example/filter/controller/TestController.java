package com.example.filter.controller;

import com.example.filter.payload.ExampleRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {
    @PostMapping("/log")
    public Mono<Void> logRequest(@RequestBody Mono<ExampleRequest> exampleRequestMono) {
        return Mono.empty();
    }
}
