package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.enums.ResponseStatus;

import lombok.Data;

@Data
public class BookTicketResponseDto {
    private ResponseStatus responseStatus;
    private Long bookingId;
    private int amount;
}