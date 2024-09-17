package com.scaler.bookmyshow.models;

import java.util.List;

import lombok.Data;

@Data
public class User extends BaseModel {
    private String name;
    private String email;
    private Long phoneNumber;
    private List<Booking> bookings;
}
