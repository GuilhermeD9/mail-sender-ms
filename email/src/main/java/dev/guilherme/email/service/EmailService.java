package dev.guilherme.email.service;

import dev.guilherme.email.entity.EmailEntity;
import dev.guilherme.email.enums.EmailStatus;
import dev.guilherme.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailRepository emailRepository;

    @Value("${EMAIL_USERNAME}")
    private String emailFrom;

    public void sendEmail(EmailEntity emailEntity) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailFrom);
            message.setTo(emailEntity.getEmailTo());
            message.setSubject(emailEntity.getEmailSubject());
            message.setText(emailEntity.getBody());
            mailSender.send(message);
        } catch (Exception e) {
            emailEntity.setEmailStatus(EmailStatus.FAILED);
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
        emailRepository.save(emailEntity);
    }

}
