package com.example.tverPlaces.Controllers;

import com.example.tverPlaces.Model.EmailRequest;
import com.example.tverPlaces.Model.User;
import com.example.tverPlaces.servise.UserServise;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Component
@Service
@AllArgsConstructor
public class EmailController {

    private static final Logger log = LoggerFactory.getLogger(EmailController.class);


    private final EmailService emailService;
    private final UserServise userServise;

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody EmailRequest request) {
        log.info("Получение запроса за отправку");
        String to = request.getTo();
        String subject = request.getSubject();
        String text = request.getText();
        emailService.sendEmail(to, subject, text);
    }

    @PostMapping("add-user")
    public String addUser (@RequestBody User user){
        log.info("получение заявки на регистрацию");
        return userServise.userRegistration(user);
    }
    //проверка кода@
    @GetMapping("check-code/{login}/code/{code}")
    public String checkCode (@PathVariable String login, @PathVariable int code){
        log.info("Контроллер - Code{} , Login{} " , code , login);
        return userServise.checkCode(login, code);
    }
    //Регистрация пользователя
    @PostMapping("/user-registration")
    public String userRegistration(@RequestBody User user){
        return userServise.userRegistration(user);
    }
    @GetMapping("/send-email")
    public String test (){
        return "все хорошо !";
    }

    //Тестовый контроллер
    @GetMapping("/hi")
    public String hiTest (){
        return "Привет, теперь какое то маленькое приложение сое в сети, ты же офигел скажи скажи))) ;";
    }
}