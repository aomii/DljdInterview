package com.bjpowernode.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitConfig3 {

    public static final String EXCHANGE_NAME = "exchange.ttl.02";

    public static final String QUEUE_NAME = "queue.ttl.02";

    public static final String ROUTING_KEY_NAME = "routing.key.ttl.02";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue directQueue() {
        //给整个队列设置一个过期时间
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-message-ttl", 10000); //给整个队列设置10秒过期
        return new Queue(QUEUE_NAME, true, false, false, arguments);
    }

    @Bean
    public Binding directBinding(DirectExchange directExchange, Queue directQueue) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(ROUTING_KEY_NAME);
    }
}
