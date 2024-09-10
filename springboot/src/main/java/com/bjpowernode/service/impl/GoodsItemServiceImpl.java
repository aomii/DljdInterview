package com.bjpowernode.service.impl;

import com.bjpowernode.entity.GoodsItem;
import com.bjpowernode.execute.AsyncResult;
import com.bjpowernode.service.GoodsItemService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class GoodsItemServiceImpl implements GoodsItemService {

    public List<GoodsItem> getGoodsItems(Long uid) {
        System.out.println("getGoodsItems-->" + Thread.currentThread().getName());
        try {
            Thread.sleep(280);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(new GoodsItem());
    }

    @Async
    public Future<List<GoodsItem>> getGoodsItems2(Long uid) {
        System.out.println("getGoodsItems-->" + Thread.currentThread().getName());
        try {
            Thread.sleep(280);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult(Arrays.asList(new GoodsItem()));
    }
}
