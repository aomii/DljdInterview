package com.bjpowernode.service.impl;

import com.bjpowernode.dao.GoodsDao;
import com.bjpowernode.entity.Goods;
import com.bjpowernode.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Goods)表服务实现类
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    //@Transactional
    @Override
    public List<Goods> queryByPage(Integer startRow, Integer pageSize) {
        List<Goods> list1 = goodsDao.queryByPage(startRow, pageSize);
        System.out.println("查詢1：" + list1 + "\n");

        //goodsDao.updateStore(1);

        List<Goods> list2 = goodsDao.queryByPage(startRow, pageSize);
        System.out.println("查詢2：" + list2 + "\n");
        return list2;
    }

    @Override
    public int updateStore(Integer id) {
        return goodsDao.updateStore(id);
    }
}