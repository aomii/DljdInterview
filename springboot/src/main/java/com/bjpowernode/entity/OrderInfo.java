package com.bjpowernode.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderInfo {

    private List<Address> addressList;

    private List<GoodsItem> goodsItemList;
}
