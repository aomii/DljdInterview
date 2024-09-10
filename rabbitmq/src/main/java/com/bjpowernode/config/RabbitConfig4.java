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
public class RabbitConfig4 {

    public static final String EXCHANGE_NAME = "exchange.length";

    public static final String QUEUE_NAME = "queue.length";

    public static final String ROUTING_KEY_NAME = "routing.key.length";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue directQueue() {
        //给整个队列设置一个过期时间
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-max-length", 5); //给整个队列设置长度为5，超过5个消息，队列就装不下了，那么先入队的消息会被发送到DLX
        return new Queue(QUEUE_NAME, true, false, false, arguments);
    }

    @Bean
    public Binding directBinding(DirectExchange directExchange, Queue directQueue) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(ROUTING_KEY_NAME);
    }
}
