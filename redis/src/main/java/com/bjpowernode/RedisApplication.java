package com.bjpowernode;

import org.mybatis.spring.annotation.MapperScan;
import org.redisson.api.RLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;
import java.util.concurrent.Executor;

@MapperScan(basePackages = "com.bjpowernode.dao")
@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RedisApplication.class, args);

		Map<String, Executor> beansOfType = context.getBeansOfType(Executor.class);
		System.out.println(beansOfType);
	}

	public void writeData (RLock lock, int count) {
		try {
			lock.lock();//加锁
			if (count > 0) {
				this.writeData(lock, count--);
			} else {
				return;
			}
		} finally {
			lock.unlock();//释放锁
		}
	}
}
