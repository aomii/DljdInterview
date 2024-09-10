package com.bjpowernode;

import com.bjpowernode.sender.MessageSender;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqApplicationTests {

    @Resource
    private MessageSender messageSender;

    @Test
    void contextLoads() throws Exception {
        messageSender.sendMessage();
    }

    @Test
    void testTTL() throws Exception {
        //消息属性设置
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setExpiration("10000"); //设置过期时间

        //消息内容
        String msg = "Hello, RabbitMQ";
        //创建一个消息
        Message message = new Message(msg.getBytes(), messageProperties);

        //发送消息
        messageSender.sendMessage2(message);
        System.out.println("消息发送完毕");
    }
}
