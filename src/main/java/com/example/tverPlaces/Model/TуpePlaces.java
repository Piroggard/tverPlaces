package com.example.tverPlaces.Model;

import lombok.Data;

@Data
public class TуpePlaces {
    Integer id;
    String name;

    public TуpePlaces(Integer id) {
        this.id = id;
    }
}
