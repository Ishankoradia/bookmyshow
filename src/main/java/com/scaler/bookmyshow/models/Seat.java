package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel {
    private String seatNumber;
    private int rowVal;
    private int colVal; // sql reserved words ; row & col
    @ManyToOne
    private SeatType seatType;
}
