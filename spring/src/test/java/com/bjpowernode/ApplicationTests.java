package com.bjpowernode;

import com.bjpowernode.service.GoodsService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.FileNotFoundException;

@SpringBootTest
class ApplicationTests {

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Resource
    private GoodsService goodsService;

    @Test
    void contextLoads() throws FileNotFoundException {
        goodsService.reduceStore(2);
    }
}