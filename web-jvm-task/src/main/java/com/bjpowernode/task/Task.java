package com.bjpowernode.task;

import com.bjpowernode.model.Order;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableScheduling
public class Task {

    private static final List<Order> ORDER_LIST = new ArrayList<>();

    @Scheduled(cron = "0/5 * * * * ?")
    public void task() {
        for (int i=0; i<25; i++) {
            ORDER_LIST.add(new Order());
        }
        System.out.println(ORDER_LIST.size());
    }
}
