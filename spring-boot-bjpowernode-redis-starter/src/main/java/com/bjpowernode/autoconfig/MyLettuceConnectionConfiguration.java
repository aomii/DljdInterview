package com.bjpowernode.autoconfig;

import io.lettuce.core.RedisClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@ConditionalOnClass({RedisClient.class})
@Configuration
public class MyLettuceConnectionConfiguration {

    /**
     *     <!-- 配置redis连接工厂 -->
     *     <bean id="jedisConnectionFactory" class="org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory">
     *         <!--构造方法初始化-->
     *         <constructor-arg index="0" ref="redisStandaloneConfiguration"/>
     *     </bean>
     */
    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory(RedisStandaloneConfiguration redisStandaloneConfiguration) {
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    /*     <!-- jedis连接配置信息 -->
     *     <bean id="redisStandaloneConfiguration" class="org.springframework.data.redis.connection.RedisStandaloneConfiguration">
     *         <property name="hostName" value="${redis.hostName}"/>
     *         <property name="port" value="${redis.port}"/>
     *         <property name="database" value="${redis.database}"/>
     *         <!--配置redis密码-->
     *         <property name="password" ref="thePassword"/>
     *     </bean>
     */
    @Bean
    public RedisStandaloneConfiguration redisStandaloneConfiguration(MyRedisProperties myRedisProperties, RedisPassword redisPassword) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(myRedisProperties.getHost());
        redisStandaloneConfiguration.setPort(myRedisProperties.getPort());
        redisStandaloneConfiguration.setPassword(redisPassword);
        return redisStandaloneConfiguration;
    }

     /*     <!-- jedis连接密码信息 -->
     *     <bean id="thePassword" class="org.springframework.data.redis.connection.RedisPassword">
     *         <!--构造方法初始化-->
     *         <constructor-arg index="0" value="${redis.password}"/>
     *     </bean>
     */
     @Bean
     public RedisPassword redisPassword (MyRedisProperties myRedisProperties) {
        return RedisPassword.of(myRedisProperties.getPassword());
     }
}