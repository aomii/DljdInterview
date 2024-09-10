package com.bjpowernode.service;

import com.bjpowernode.entity.Address;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;

public interface AddressService {

    public List<Address> getAddress(Long uid);

    @Async
    public Future<List<Address>> getAddress2(Long uid);
}
