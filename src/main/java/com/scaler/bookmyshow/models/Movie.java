package com.scaler.bookmyshow.models;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Movie extends BaseModel {
    private String name;
    private List<String> actors;
}
