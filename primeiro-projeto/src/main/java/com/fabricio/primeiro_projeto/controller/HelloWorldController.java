package com.fabricio.primeiro_projeto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello")
public class HelloWorldController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String get() {
        return "Hello World!";
    }

//    @GetMapping
//    public String helloWorld(){
//        return "Hello World";
//    }

//    @GetMapping
//    public ResponseEntity<String> helloWorld(String name) {
//        return ResponseEntity.ok("Olá " + name + ", meu amigo!");
//    }

//    @GetMapping
//    public ResponseEntity<String> olaMundo() {
//        return new ResponseEntity<>("Hello World", HttpStatus.OK);
//    }

}
