package com.scaler.bookmyshow.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.bookmyshow.models.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    @Override
    Optional<Show> findById(Integer id);
}