package com.scaler.bookmyshow.dtos;

import java.util.List;

import lombok.Data;

@Data
public class BookTicketRequestDto {
    private List<Integer> showSheatIds;
    private int showId;
    private int userId;
}