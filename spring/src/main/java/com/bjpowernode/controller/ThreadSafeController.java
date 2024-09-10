package com.bjpowernode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadSafeController {

    private ThreadLocal<Integer> numberThreadLocal = ThreadLocal.withInitial(() -> {
        return 0;
    });

    @GetMapping(value = "/api/v3/number1")
    public int number() {
        numberThreadLocal.set(1);
        System.out.println(numberThreadLocal.get());
        return numberThreadLocal.get();
    }

    @GetMapping(value = "/api/v3/number2")
    public int number2() {
        System.out.println(numberThreadLocal.get());
        return numberThreadLocal.get();
    }
}
