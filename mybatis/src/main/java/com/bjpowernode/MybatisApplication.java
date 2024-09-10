package com.bjpowernode;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.bjpowernode.dao"})
@SpringBootApplication
public class MybatisApplication {

    private RowBounds rowBounds;

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
