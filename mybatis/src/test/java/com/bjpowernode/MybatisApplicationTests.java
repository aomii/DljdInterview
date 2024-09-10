package com.bjpowernode;

import com.bjpowernode.dao.GoodsDao;
import com.bjpowernode.entity.Goods;
import com.bjpowernode.service.GoodsService;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    private GoodsService goodsService;

    @Test
    public void showDefaultCacheConfiguration() {
        System.out.println("一级缓存范围: " + sqlSessionFactory.getConfiguration().getLocalCacheScope());
        System.out.println("二级缓存是否被启用: " + sqlSessionFactory.getConfiguration().isCacheEnabled());
    }

    @Test
    void testFirstCache() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        GoodsDao goodsDao1 = sqlSession1.getMapper(GoodsDao.class);
        List<Goods> list1 = goodsDao1.queryByPage(0, 2);
        System.out.println("查詢1：" + list1 + "\n");

        //调用clearCache()方法清理一级缓存
        //sqlSession1.clearCache();

        //sqlSession提交会清理一级缓存
        sqlSession1.commit();

        //sqlSession关闭会清理一级缓存
        //sqlSession1.close();

        //做一个增、删、改操作，会清理一级缓存
        //goodsDao1.updateStore(1);

        /*GoodsDao goodsDao2 = sqlSession1.getMapper(GoodsDao.class);
        List<Goods> list2 = goodsDao2.queryByPage(0, 2);
        System.out.println("查詢2：" + list2 + "\n");*/

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        GoodsDao goodsDao3 = sqlSession2.getMapper(GoodsDao.class);
        List<Goods> list3 = goodsDao3.queryByPage(0, 2);
        System.out.println("查詢3：" + list3 + "\n");
    }

    @Test
    void testCache() {
        goodsService.queryByPage(0, 2);
        //System.out.println("-------------------------------------");
        //goodsService.queryByPage(0, 2);
    }
}
