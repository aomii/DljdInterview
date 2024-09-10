package com.bjpowernode.dao;

import com.bjpowernode.entity.Goods;

/**
 * (Goods)表数据库访问层
 *
 */
public interface GoodsDao {

    Goods queryById(Integer id);

    int updateStore(Integer id);

}