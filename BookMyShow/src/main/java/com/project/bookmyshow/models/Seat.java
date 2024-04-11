package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "seats")
public class Seat extends BaseModel{

    private String seatNumber;
    private int rowVal;
    private int colVal;

    // seat:seatType == M:1
    @ManyToOne
    @JoinColumn(name = "seat_type_id", referencedColumnName = "id", nullable = false)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "screen_id", referencedColumnName = "id", nullable = false)
    private Screen screen;
}
