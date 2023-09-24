package com.example.tverPlaces.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Data
public class User {
    private String login;
    private String mail;
    private String password;
}
