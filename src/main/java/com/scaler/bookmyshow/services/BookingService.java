package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.enums.BookingStatus;
import com.scaler.bookmyshow.enums.ShowSeatStatus;
import com.scaler.bookmyshow.models.Booking;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositories.BookingRepository;
import com.scaler.bookmyshow.repositories.ShowRepository;
import com.scaler.bookmyshow.repositories.ShowSeatRepository;
import com.scaler.bookmyshow.repositories.UserRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;

    private BookingRepository bookingRepository;

    @Autowired
    BookingService(UserRepository userRepository, ShowRepository showRepository,
            ShowSeatRepository showSeatRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(List<Integer> showSeatIds, int showId, int userId) {
        // Get the user
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("user not found");
        }
        User user = userOptional.get();

        // Get the Show from showId
        Optional<Show> showOptional = showRepository.findById(showId);
        if (showOptional.isEmpty()) {
            throw new RuntimeException("show not found");
        }
        Show show = showOptional.get();

        // ------- Transaction start --------
        // Get the ShowSeat from Ids
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        // Check if all seats are available
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getSeatStatus().equals(ShowSeatStatus.VACANT)) {
                throw new RuntimeException("show seat not empty");
            }
        }

        // If no, throw error
        // If yes, mark the seats as blocked
        List<ShowSeat> showSeatList = new ArrayList<>();
        for (ShowSeat showSeat : showSeats) {
            // Save the ShowSeats in db with updated data
            showSeat.setSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
            showSeatList.add(showSeatRepository.save(showSeat));
        }

        // ------- Transaction end --------
        // Create corresponsing booking object
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setShowSeats(showSeats);
        booking.setStatus(BookingStatus.PENDING);
        booking.setBookedAt(new Date());
        booking.setAmount(100);
        booking.setPayments(new ArrayList<>());
        bookingRepository.save(booking);

        // return booking object
        return booking;
    }
}