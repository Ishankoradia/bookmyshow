package com.scaler.bookmyshow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.bookmyshow.dtos.BookTicketRequestDto;
import com.scaler.bookmyshow.dtos.BookTicketResponseDto;
import com.scaler.bookmyshow.enums.ResponseStatus;
import com.scaler.bookmyshow.models.Booking;
import com.scaler.bookmyshow.services.BookingService;

@Controller
public class BookingController {
    private BookingService bookingService;

    @Autowired
    BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) {
        BookTicketResponseDto response = new BookTicketResponseDto();
        try {
            Booking booking = bookingService.bookTicket(request.getShowSheatIds(), request.getShowId(),
                    request.getUserId());
            response.setBookingId(booking.getId());
            response.setAmount(booking.getAmount());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FAILED);
        }
        return response;
    }
}