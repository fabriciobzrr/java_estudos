package com.fabriciobezerra.first_spring_app;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello(String name) {
        if(name == "") {
            return "Olá, convidado!" ;
        } else {
            return "Olá, " + name + "!";
        }
    }

}

