package com.pingvip.service.impl;

import com.pingvip.service.MessageReceiveService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "test")
public class MessageReceiveServiceImpl implements MessageReceiveService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RabbitHandler
    public void receiveMessage(){
        Message message = rabbitTemplate.receive("test");
        byte[] bytes = message.getBody();
        String messageContent = new String(bytes);
        System.out.print(messageContent);
    }

}
