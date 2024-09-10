package com.bjpowernode.model;

import java.math.BigDecimal;

public class Order {

    private int id;

    private String name;

    private BigDecimal money;

    private byte[] bytes = new byte[1024 * 1024]; //1024kb = 1m

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}