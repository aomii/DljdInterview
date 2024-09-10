package com.bjpowernode.service;

import com.bjpowernode.dao.GoodsDao;
import com.bjpowernode.entity.Goods;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Resource
    private OrdersService ordersService;

    @Transactional(rollbackFor = Exception.class)
    public int reduceStore(Integer id) {
        int update = 0;

        Goods goods = goodsDao.queryById(id);
        Integer store = goods.getStore();
        if (store > 0) {
            update = goodsDao.updateStore(id);
        }

        new Thread(() -> {
            int a = 10 / 0;
        }).start();

        return update;
    }

    public int reduceStore2(Integer id) {
        return this.reduceStore(id);
    }

    public int b(Integer id) {
        return ordersService.a(id);
    }
}
