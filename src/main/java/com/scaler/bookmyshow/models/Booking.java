package com.scaler.bookmyshow.models;

import java.util.Date;
import java.util.List;

import com.scaler.bookmyshow.enums.BookingStatus;

import lombok.Data;

@Data
public class Booking extends BaseModel {
    private Show show;
    private int amount;
    private List<ShowSeat> showSeats;
    private BookingStatus status;
    private User user;
    private List<Payment> payments;
    private Date bookedAt;
}
