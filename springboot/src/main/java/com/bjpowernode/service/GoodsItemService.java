package com.bjpowernode.service;

import com.bjpowernode.entity.GoodsItem;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;

public interface GoodsItemService {

    public List<GoodsItem> getGoodsItems(Long uid);

    @Async
    public Future<List<GoodsItem>> getGoodsItems2(Long uid);
}
