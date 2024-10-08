package com.scaler.bookmyshow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.bookmyshow.models.ShowSeat;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
    @Override
    List<ShowSeat> findAllById(Iterable<Integer> ids);

    @Override
    ShowSeat save(ShowSeat entity);
}