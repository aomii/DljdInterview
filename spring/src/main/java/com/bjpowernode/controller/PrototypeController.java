package com.bjpowernode.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Scope(value = "prototype")
@RestController
public class PrototypeController {

    private int number = 0;

    @GetMapping(value = "/api/v2/number1")
    public int number1() {
        number ++;
        System.out.println(this.number);
        return this.number;
    }

    @GetMapping(value = "/api/v2/number2")
    public int number2() {
        number ++;
        System.out.println(this.number);
        return this.number;
    }
}
