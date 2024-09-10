package com.bjpowernode.sender;

import com.bjpowernode.config.RabbitConfig;
import com.bjpowernode.model.Orders;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
@Component
public class MessageSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    //声明一个把对象转成JSON的对象
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Resource
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        //把实现了RabbitTemplate.ConfirmCallback的类的对象 设置到 rabbitTemplate里面去
        rabbitTemplate.setConfirmCallback(this);
        //把实现了RabbitTemplate.ReturnsCallback的类的对象 设置到 rabbitTemplate里面去
        rabbitTemplate.setReturnsCallback(this);
    }

    public void sendMessage() throws Exception {
        Orders orders = Orders.builder().id(10739).name("手机").money(new BigDecimal(1999.98)).createTime(new Date()).build();
        //Orders转成json再发出去
        String json = objectMapper.writeValueAsString(orders);
        //消息体
        Message message = MessageBuilder.withBody(json.getBytes(StandardCharsets.UTF_8))
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT) //消息持久化
                .build();

        //消息关联数据
        CorrelationData correlationData = new CorrelationData("13700000000");

        //发送消息  direct.exchange
        rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE_NAME, "info", message, correlationData);

        System.out.println("消息发送完毕.");
    }

    /**
     * 实现RabbitTemplate.ConfirmCallback接口中的confirm方法
     *
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        // correlationData 是相关数据，你可以在发消息的时候，设置一个相关数据，那么此处就可以接到这个相关数据
        System.out.println("消息confirm关联数据：" + correlationData);
        if (ack) {
            //消息发送成功
            System.out.println("消息confirm：消息发送确认ack = " + ack);
        } else {
            //消息没有发成功，原因是什么，原因就是cause，然后你可以做一些补偿措施，或者是记录日志，或者是发送个通知，让负责人知道
            System.out.println("消息confirm：消息发送确认ack = " + ack + ", 原因：" + cause);
        }
    }

    /**
     * 消息从 交换机 --> 到 --> 队列，如果失败了，就会回调该方法
     * （失败了才触发该方法，成功是不会触发该方法的）
     *
     * 比如说磁盘满
     *
     * @param returned
     */
    @Override
    public void returnedMessage(ReturnedMessage returned) {
        System.out.println("[returnedMessage]：" + returned.getMessage());
        System.out.println("[returnedMessage]：" + returned.getExchange());
        System.out.println("[returnedMessage]：" + returned.getRoutingKey());
        System.out.println("[returnedMessage]：" + returned.getReplyText());
        System.out.println("[returnedMessage]：" + returned.getReplyCode());
    }

    public void sendMessage2(Message message) throws Exception {

    }
}
