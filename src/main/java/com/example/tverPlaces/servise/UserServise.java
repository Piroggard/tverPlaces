package com.example.tverPlaces.servise;

import com.example.tverPlaces.Controllers.EmailController;
import com.example.tverPlaces.Controllers.EmailService;
import com.example.tverPlaces.Model.User;
import com.example.tverPlaces.storage.DbStorage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Component
@AllArgsConstructor
public class UserServise {

    private static final Logger log = LoggerFactory.getLogger(EmailController.class);
    EmailService emailService;
    DbStorage dbStorage;
    public String userRegistration (User user){
        int userRegistrationCode = generationRandom();
        log.info("Получение запроса на обработку пользователя {}" , user);
        emailService.sendEmail(user.getMail(), "Код для подтверждения регистрации",
                "Введите код - " + userRegistrationCode);
        return dbStorage.userRegistration(user, userRegistrationCode);
    }

    public String checkCode (String login, int code){
        return dbStorage.checkCode(login, code);
    }

    public int generationRandom (){
        Random random = new Random();
        int min = 1;
        int max = 100;
        return random.nextInt(max - min + 1) + min;
    }

}
