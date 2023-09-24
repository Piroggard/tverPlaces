package com.example.tverPlaces.storage;

import com.example.tverPlaces.Controllers.EmailController;
import com.example.tverPlaces.Model.User;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Service
@AllArgsConstructor
public class DbStorage {
    private static final Logger log = LoggerFactory.getLogger(EmailController.class);
    private final JdbcTemplate jdbcTemplate;
    public String userRegistration(User user , Integer code){
        log.info("Получение запроса на сохранение пользователя {}" , user);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {PreparedStatement ps = con.prepareStatement("INSERT INTO USERS (MAIL, LOGIN , PASSWORD) VALUES (?, ?, ?);",
                new String[]{"id"});
        ps.setString(1, user.getMail());
        ps.setString(2, user.getLogin());
        ps.setString(3, user.getPassword());
        return ps;
        }, keyHolder);
        Integer keyUser = keyHolder.getKey().intValue();
        jdbcTemplate.update("INSERT INTO USER_CHECK_CODE (ID, CODE)VALUES (?, ?);", keyUser, code);
        return "Введите номер укаханый в " + user.getMail();
    }

    public String checkCode (String login, Integer code){
        log.info("Code{} , Login{} " , code , login);
        Integer userCodeFromDB = jdbcTemplate.queryForObject("SELECT ucc.CODE FROM USER_CHECK_CODE ucc \n" +
                "JOIN USERS u ON u.ID = ucc.ID \n" +
                "WHERE u.LOGIN = ?;", new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("CODE");
            }
        }, login);

        if (code == userCodeFromDB){
            return "Пользователь добавлен";
        } else {
            return "Введите код повторно";
        }

    }
}
