package com.project.bookmyshow.models;

import com.project.bookmyshow.models.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "show_seats")
public class ShowSeat extends BaseModel{

    // ShowSeat:Show == M:M // it will be in multiple show's seat
    @ManyToOne
    @JoinColumn(name = "show_id", referencedColumnName = "id", nullable = false)
    private Show show;

    // ShowSeat:Seat == M:1  // 1 seat can be used in multiple show's seat
    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id", nullable = false)
    private Seat seat;

    @Enumerated
    private SeatStatus seatStatus;

}
