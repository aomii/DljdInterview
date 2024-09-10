package com.bjpowernode.service.impl;

import com.bjpowernode.entity.Address;
import com.bjpowernode.execute.AsyncResult;
import com.bjpowernode.service.AddressService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class AddressServiceImpl implements AddressService {

    public List<Address> getAddress(Long uid) {
        System.out.println("getAddress-->" + Thread.currentThread().getName());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(new Address());
    }

    @Async
    public Future<List<Address>> getAddress2(Long uid) {
        System.out.println("getAddress-->" + Thread.currentThread().getName());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult(Arrays.asList(new Address()));
    }
}
