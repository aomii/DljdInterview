package com.bjpowernode.service;

import com.bjpowernode.entity.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> queryByPage(Integer startRow, Integer pageSize);

    int updateStore(Integer id);

}
