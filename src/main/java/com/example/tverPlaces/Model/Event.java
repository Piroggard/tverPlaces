package com.example.tverPlaces.Model;

import lombok.Data;

@Data
public class Event {
    Integer id;
    String name;

    public Event(Integer id) {
        this.id = id;
    }
}
