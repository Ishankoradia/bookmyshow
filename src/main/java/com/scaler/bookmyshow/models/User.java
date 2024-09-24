package com.scaler.bookmyshow.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "users")
public class User extends BaseModel {
    private String email;
    private String name;
    private String password;
    @OneToMany
    private List<Booking> bookings;
}
