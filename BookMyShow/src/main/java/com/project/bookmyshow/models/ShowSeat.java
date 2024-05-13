package com.project.bookmyshow.models;

import com.project.bookmyshow.models.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity(name = "show_seats")
public class ShowSeat extends BaseModel{

    // ShowSeat:Show == M:1
    @ManyToOne
    @JoinColumn(name = "show_id", referencedColumnName = "id")
    private Show show;

    // ShowSeat:Seat == M:1  // 1 seat can be used in multiple show's seat
    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;

    @Enumerated
    private SeatStatus seatStatus;

    private Date bookedAt;

}
