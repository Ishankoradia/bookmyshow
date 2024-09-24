package com.scaler.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scaler.bookmyshow.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}