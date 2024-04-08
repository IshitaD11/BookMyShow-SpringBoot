package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{

    private int row;
    private int col;

    // seat:screen == M:1
    @ManyToOne
    private Screen screen;

    // seat:seatType == M:1
    @ManyToOne
    private SeatType seatType;
}
