package com.example.tverPlaces.Controllers;

import com.example.tverPlaces.Model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class EmailController {

    private static final Logger log = LoggerFactory.getLogger(EmailController.class);

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody EmailRequest request) {
        log.info("Получение запроса за отправку");
        String to = request.getTo();
        String subject = request.getSubject();
        String text = request.getText();
        emailService.sendEmail(to, subject, text);
    }
    @GetMapping("/send-email")
    public String test (){
        return "все хорошо !";
    }

}