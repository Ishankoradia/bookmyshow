package com.scaler.bookmyshow.models;

import java.util.Date;
import java.util.List;

import com.scaler.bookmyshow.enums.Feature;
import com.scaler.bookmyshow.enums.ShowStatus;

import lombok.Data;

@Data
public class Show extends BaseModel {
    private Movie movie;
    private Screen screen;
    private Date startingTime;
    private Date endingTime;
    private List<Feature> features;
    private ShowStatus showStatus;
}
