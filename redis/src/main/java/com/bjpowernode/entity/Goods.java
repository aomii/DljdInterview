package com.bjpowernode.entity;

import java.io.Serializable;

/**
 * (Goods)实体类
 *
 */
public class Goods implements Serializable {

    private static final long serialVersionUID = -22973695395672122L;

    /**
     * 商品ID
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品名称[拼音]
     */
    private String namePinyin;

    /**
     * 商品库存
     */
    private Integer store;

    /**
     * 商品简介
     */
    private String intro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}