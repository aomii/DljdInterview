package com.bjpowernode.service.impl;

import com.bjpowernode.dao.GoodsDao;
import com.bjpowernode.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (Goods)表服务实现类
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Transactional //事务  aop，动态代理
    @Override
    public int updateStore(Integer id) {
        return goodsDao.updateStore(id);
    }
}