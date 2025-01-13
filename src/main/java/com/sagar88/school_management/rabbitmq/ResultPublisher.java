package com.sagar88.school_management.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResultPublisher {
    private static final String EXCHANGE = "result-exchange";
    private static final String ROUTING_KEY = "result.created";

    private final RabbitTemplate rabbitTemplate;

    public ResultPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishResult(String message) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, message);
    }
}
