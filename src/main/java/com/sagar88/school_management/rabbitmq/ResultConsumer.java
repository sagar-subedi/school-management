package com.sagar88.school_management.rabbitmq;

import com.sagar88.school_management.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ResultConsumer {
    private final EmailService emailService;

    public ResultConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "result-queue")
    public void consumeMessage(String message) {
        String studentEmail = extractEmailFromMessage(message);
        String resultDetails = extractResultDetailsFromMessage(message);

        emailService.sendEmail(
                studentEmail,
                "Your Result is Published",
                "Dear student, your result: " + resultDetails
        );
    }

    private String extractEmailFromMessage(String message) {
        return message.split("\\|")[0];
    }

    private String extractResultDetailsFromMessage(String message) {
        return message.split("\\|")[1];
    }
}

