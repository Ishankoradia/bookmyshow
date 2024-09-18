package com.scaler.bookmyshow.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Region extends BaseModel {
    private String name;
    @OneToMany
    private List<Theatre> theatres;
    // @ManyToMany
    // private List<Movie> movies; // why create a new table for just movies
}
