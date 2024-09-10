package com.bjpowernode.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Scope(value = "singleton")
@RestController
public class SingletonController {

    private int number = 0;

    @GetMapping(value = "/api/number1")
    public int number1() {
        number ++;
        System.out.println(this.number);
        return this.number;
    }

    @GetMapping(value = "/api/number2")
    public int number2() {
        number ++;
        System.out.println(this.number);
        return this.number;
    }
}
