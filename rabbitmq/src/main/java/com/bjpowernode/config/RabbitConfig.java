package com.bjpowernode.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String DIRECT_EXCHANGE_NAME = "direct.exchange";

    public static final String DIRECT_QUEUE_NAME = "direct.queue";

    public static final String DIRECT_ROUTING_KEY = "info";

    /**
     * 声明创建一个FanoutExchange交换机
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return ExchangeBuilder.directExchange(DIRECT_EXCHANGE_NAME)
                .durable(true)
                .build();
    }

    /**
     * 声明创建一个队列
     *
     * @return
     */
    @Bean
    public Queue directQueue() {
        return QueueBuilder.durable(DIRECT_QUEUE_NAME).build();
    }

    /**
     * 把 队列 和 交换机 绑定
     * @param directQueue
     * @param directExchange
     * @return
     */
    @Bean
    public Binding directBinding(@Qualifier("directQueue") Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(DIRECT_ROUTING_KEY);
    }
}
