package com.scaler.bookmyshow.models;

import java.util.List;

import lombok.Data;

@Data
public class Movie extends BaseModel {
    private String name;
    private List<String> actors;
}
