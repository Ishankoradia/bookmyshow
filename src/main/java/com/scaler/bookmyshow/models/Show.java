package com.scaler.bookmyshow.models;

import java.util.Date;
import java.util.List;

import com.scaler.bookmyshow.enums.Feature;
import com.scaler.bookmyshow.enums.ShowStatus;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "shows")
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    private Date startingTime;
    private Date endingTime;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
    @Enumerated(EnumType.ORDINAL)
    private ShowStatus showStatus;
}
