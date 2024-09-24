package com.scaler.bookmyshow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeatType;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Integer> {
    @Override
    List<ShowSeatType> findAllById(Iterable<Integer> ids);

    List<ShowSeatType> findAllByShow(Show show);
}