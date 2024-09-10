package com.bjpowernode.listener;

import com.bjpowernode.config.RabbitConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class MyRabbitListener {

    @RabbitListener(queues = {RabbitConfig.DIRECT_QUEUE_NAME})
    public void onMessage(String msg, @Headers Map<String, Object> header, Message message, Channel channel) {
        try {
            System.out.println("[RabbitListener]接收到的消息: " + msg);

            //处理业务

            //业务处理成功，手动确认消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

            //业务处理失效，不确认消息，并且重新入队，这样又可以重新消费
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);

            //拒绝消息
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
