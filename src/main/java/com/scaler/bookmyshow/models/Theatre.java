package com.scaler.bookmyshow.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Theatre extends BaseModel {
    private String name;
    @ManyToOne
    private Region region;
    // @OneToMany
    // private List<Screen> screens;
    @OneToMany
    private List<Show> shows;
}
