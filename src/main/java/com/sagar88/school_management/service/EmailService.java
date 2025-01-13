package com.sagar88.school_management.service;

import com.sagar88.school_management.entity.Student;
import com.sagar88.school_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private StudentRepository studentRepository;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    @Scheduled(cron = "0 0 9 * * ?") // Runs every day at 9 AM
    public void sendScheduledEmail() {
        try {
            List<Student> students = studentRepository.findAll();
            for(Student student: students){
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(student.getUser().getEmail());
                message.setSubject("Assignment submission reminder");
                message.setText("Please complete your assignment.");
                mailSender.send(message);
            }
            System.out.println("Scheduled email sent successfully.");
        } catch (Exception e) {
            System.err.println("Error while sending email: " + e.getMessage());
        }
    }
}
