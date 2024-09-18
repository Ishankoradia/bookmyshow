package com.scaler.bookmyshow.models;

import java.util.Date;
import java.util.List;

import com.scaler.bookmyshow.enums.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Booking extends BaseModel {
    // M:1
    @ManyToOne
    private Show show;
    private int amount;
    // M:M
    @ManyToMany
    private List<ShowSeat> showSeats;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;
    // M:1
    @ManyToOne
    private User user;
    // 1:M
    @OneToMany(mappedBy = "booking")
    private List<Payment> payments;
    private Date bookedAt;
}
