package com.bjpowernode;

import com.bjpowernode.bean.MyBean;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Map;
import java.util.concurrent.Executor;

@EnableAsync(proxyTargetClass = true)
@ImportResource(locations = "classpath:applicationContext.xml")
@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private MyBean myBean;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);

        Map<String, Executor> beansOfTypeMap = context.getBeansOfType(Executor.class);
        beansOfTypeMap.forEach((k, v) -> {
            System.out.println("k -->" + k + "   :    " + "v -->" + v);
        });
    }

    @Override
    public void run(String... args) throws Exception {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        redisTemplate.opsForValue().set("k12", "v12");

        System.out.println("myBean = " + myBean);
    }
}
