package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "show_seat_types")
public class ShowSeatType extends BaseModel {

    // ShowSeatType:Show == M:1  considering each ShowSeatType is for a single show
    @ManyToOne
    @JoinColumn(name = "show_id", referencedColumnName = "id", nullable = false)
    private Show show;

    // ShowSeatType:SeatType == M:1
    @ManyToOne
    @JoinColumn(name = "seat_type_id", referencedColumnName = "id", nullable = false)
    private SeatType seatType;
    private float price;
}
