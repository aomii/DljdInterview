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
public class RabbitConfig2 {

    public static final String EXCHANGE_NAME = "exchange.order";
    public static final String QUEUE_NAME = "queue.order";
    public static final String ROUTING_KEY_NAME = "routingkey.order";

    //死信交换机的名字
    public static final String EXCHANGE_NAME_DLX = "exchange.order.dlx";
    //死信队列的名字
    public static final String QUEUE_NAME_DLX = "queue.order.dlx";
    //死信交换机和死信队列的路由键
    public static final String ROUTING_KEY_NAME_DLX = "routingkey.order.dlx";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue directQueue() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", EXCHANGE_NAME_DLX); //指定死信交换机
        arguments.put("x-dead-letter-routing-key", ROUTING_KEY_NAME_DLX); //指定死信路由键

        arguments.put("x-max-length", 5); //设置队列的最大长度
        return new Queue(QUEUE_NAME, true, false, false, arguments);
    }

    @Bean
    public Binding directBinding(DirectExchange directExchange, Queue directQueue) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(ROUTING_KEY_NAME);
    }

    //------------------------------------------------------------------------------------

    //声明一个死信交换机
    @Bean
    public DirectExchange directExchangeDLX() {
        return new DirectExchange(EXCHANGE_NAME_DLX);
    }

    //声明一个死信队列
    @Bean
    public Queue directQueueDLX() {
        return new Queue(QUEUE_NAME_DLX);
    }

    //把死信交换机和死信队列进行绑定，通过一个死信路由键
    @Bean
    public Binding directBindingDLX(DirectExchange directExchangeDLX, Queue directQueueDLX) {
        return BindingBuilder.bind(directQueueDLX).to(directExchangeDLX).with(ROUTING_KEY_NAME_DLX);
    }
}
