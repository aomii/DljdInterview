package com.bjpowernode;

import com.bjpowernode.service.impl.GoodsServiceImpl;
import jakarta.annotation.Resource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.bjpowernode.dao"})
@SpringBootApplication
public class SpringbootProxyApplication implements CommandLineRunner {

    @Resource
    private GoodsServiceImpl goodsService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProxyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        goodsService.updateStore(1);
    }
}
