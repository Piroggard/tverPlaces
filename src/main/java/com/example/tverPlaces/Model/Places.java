package com.example.tverPlaces.Model;

import lombok.Data;

import java.util.List;

@Data
public class Places {
    List<Address> addresses;
    String description;
    String name;
    String opening;
    String closing;
    List<TуpePlaces> tуpePlaces; //Тип заведения (Ресторан бар кофе)
    List<Event> events; //Список мероприятий типа день рождение иди свадба
}
