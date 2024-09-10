package com.bjpowernode.order;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {

    private long id;

    private String name;

    private BigDecimal price;

    private Date createTime;

    private byte[] bytes = new byte[1024*20*10]; //1KB * 20 * 10 = 200KB

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
