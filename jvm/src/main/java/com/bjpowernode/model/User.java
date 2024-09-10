package com.bjpowernode.model;

import lombok.Data;

@Data
public class User {

    private int id;

    private String nick;

    private String phone;

    public void working() {
        System.out.println("working......");
    }
}
