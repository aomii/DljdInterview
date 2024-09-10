package com.bjpowernode.controller;

import com.bjpowernode.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OOMController {

    //List
    List<Order> orderList = new ArrayList<Order>();

    @GetMapping("/hello")
    public Object hello() {
        //List
        List<Order> orderList = new ArrayList<Order>();
        for (int i = 0; i < 100; i++) {
            //Order
            Order order = new Order();
            order.setId(1);
            order.setMoney(new BigDecimal(990));
            order.setName("支付订单");

            //放入List
            orderList.add(order);
        }
        return "hello...";
    }

    /**
     * 堆溢出
     *
     * @return
     */
    @RequestMapping("/heap")
    public Object heap() {

        //死循环
        for (;;) {
            //Order
            Order order = new Order();
            order.setId(1);
            order.setMoney(new BigDecimal(990));
            order.setName("支付订单");

            //放入List
            orderList.add(order);

            System.out.println("orderList: " + orderList.size());
        }
    }
}
