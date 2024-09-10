package com.bjpowernode.service;

import com.bjpowernode.dao.GoodsDao;
import com.bjpowernode.entity.Goods;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


@Service
public class OrdersService {

    @Resource
    private GoodsDao goodsDao;

    @Transactional(rollbackFor = Exception.class)
    public int a(Integer id) {
        int update = 0;

        Goods goods = goodsDao.queryById(id);
        Integer store = goods.getStore();
        if (store > 0) {
            update = goodsDao.updateStore(id);
        }

        int a = 10 / 0;
        return update;
    }

    @Transactional
    public int x(Integer id) throws FileNotFoundException {
        int update = 0;

        Goods goods = goodsDao.queryById(id);
        Integer store = goods.getStore();
        if (store > 0) {
            update = goodsDao.updateStore(id);
        }

        FileInputStream fis = new FileInputStream("");
        return update;
    }

    @Transactional
    public int y(Integer id) {
        int update = 0;

        Goods goods = goodsDao.queryById(id);
        Integer store = goods.getStore();
        if (store > 0) {
            update = goodsDao.updateStore(id);
        }

        try {
            int a = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return update;
    }

    @Transactional
    public int z(Integer id) throws IOException {
        int update = 0;

        Goods goods = goodsDao.queryById(id);
        Integer store = goods.getStore();
        if (store > 0) {
            update = goodsDao.updateStore(id);
        }

        try {
            int a = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return update;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int m(Integer id) {
        int update = 0;

        Goods goods = goodsDao.queryById(id);
        Integer store = goods.getStore();
        if (store > 0) {
            update = goodsDao.updateStore(id);
        }

        int a = 10 / 0;
        return update;
    }
}
