package com.scaler.bookmyshow.models;

import java.util.List;

import jakarta.persistence.ManyToMany;
import lombok.Data;


@Data
public class Region extends BaseModel {
    private String name;
    private List<Theatre> theatres;
    private List<Movie> movies;
}
