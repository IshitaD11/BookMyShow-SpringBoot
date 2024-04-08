package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {

    // ShowSeatType:Show == 1:1
    @OneToOne
    private Show show;

    // ShowSeatType:SeatType == 1:1
    @OneToOne
    private SeatType seatType;
    private float price;
}
