package com.bjpowernode.controller;

import com.bjpowernode.entity.Address;
import com.bjpowernode.entity.GoodsItem;
import com.bjpowernode.entity.OrderInfo;
import com.bjpowernode.service.impl.AddressServiceImpl;
import com.bjpowernode.service.impl.GoodsItemServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 线程池
 *
 */
@RestController
public class OrderController {

    @Resource
    private AddressServiceImpl addressService;

    @Resource
    private GoodsItemServiceImpl goodsItemService;

    @Resource
    private ThreadPoolTaskExecutor applicationTaskExecutor;

    @RequestMapping("/")
    public Object index() {
        return "";
    }

    @RequestMapping("/order1")
    public Object order1() {
        //执行开始时间
        long start = System.currentTimeMillis();

        //创建订单信息对象
        OrderInfo orderInfo = new OrderInfo();

        //查询收获地址
        List<Address> address = addressService.getAddress(1028L);
        //查询商品
        List<GoodsItem> goodsItems = goodsItemService.getGoodsItems(1028L);

        //把用户地址信息设置到订单对象中
        orderInfo.setAddressList(address);
        //把商品信息设置到订单对象中
        orderInfo.setGoodsItemList(goodsItems);

        //执行结束时间
        long end = System.currentTimeMillis();

        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("time", (end-start));
        map.put("data", orderInfo);
        return map;
    }

    @RequestMapping("/order2")
    public Object order2() throws ExecutionException, InterruptedException {
        //执行开始时间
        long start = System.currentTimeMillis();

        OrderInfo orderInfo = new OrderInfo();

        //查询收获地址
        Future<List<Address>> address = addressService.getAddress2(1028L);
        //查询商品
        Future<List<GoodsItem>> goodsItems = goodsItemService.getGoodsItems2(1028L);

        //把用户地址信息设置到订单对象中
        orderInfo.setAddressList(address.get());
        //把商品信息设置到订单对象中
        orderInfo.setGoodsItemList(goodsItems.get());

        //执行结束时间
        long end = System.currentTimeMillis();

        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("time", (end-start));
        map.put("data", orderInfo);
        return map;
    }

    @RequestMapping("/order3")
    public Object order3() throws ExecutionException, InterruptedException {
        //执行开始时间
        long start = System.currentTimeMillis();

        //创建订单信息对象
        OrderInfo orderInfo = new OrderInfo();

        //异步执行
        CompletableFuture<Void> addressFuture = CompletableFuture.runAsync(() -> {
            //查询收货地址
            List<Address> address = addressService.getAddress(1028L);
            orderInfo.setAddressList(address);
        }, applicationTaskExecutor);

        //异步执行
        CompletableFuture<Void> goodsFuture = CompletableFuture.runAsync(() -> {
            //查询商品
            List<GoodsItem> goodsItems = goodsItemService.getGoodsItems(1028L);
            orderInfo.setGoodsItemList(goodsItems);
        }, applicationTaskExecutor);

        //等待完成
        CompletableFuture.allOf(addressFuture, goodsFuture).get();

        //执行结束时间
        long end = System.currentTimeMillis();

        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("time", (end-start));
        map.put("data", orderInfo);
        return map;
    }
}