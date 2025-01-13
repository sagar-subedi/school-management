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
        // Extract email and result details from the message (placeholder logic)
        String studentEmail = extractEmailFromMessage(message); // Implement this
        String resultDetails = extractResultDetailsFromMessage(message); // Implement this

        emailService.sendEmail(
                studentEmail,
                "Your Result is Published",
                "Dear student, your result: " + resultDetails
        );
    }

    private String extractEmailFromMessage(String message) {
        return "sagarxic@gmail.com";
    }

    private String extractResultDetailsFromMessage(String message) {
        return "Math: 95, Science: 89";
    }
}

