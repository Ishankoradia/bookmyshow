package com.scaler.bookmyshow.models;

import java.util.List;

import com.scaler.bookmyshow.enums.Feature;

import lombok.Data;

@Data
public class Screen extends BaseModel {
    private String name;

    private List<Seat> seats;

    private List<Feature> features;
}
