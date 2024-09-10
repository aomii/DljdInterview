package com.bjpowernode.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({@Signature(
        type= Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class PageInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //插件不可用，那么直接调用原始的方法即可
        return invocation.proceed();
    }

    /**
     * 产生一个动态代理对象
     *
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 初始化mybatis-config.xml文件的时候会执行该方法，加载属性配置文件信息
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }
}