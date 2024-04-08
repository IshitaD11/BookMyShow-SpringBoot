package com.project.bookmyshow.models;

import com.project.bookmyshow.models.enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{

    // ShowSeat:Show == M:1
    @ManyToOne
    private Show show;

    // ShowSeat:Seat == 1:1
    @OneToOne
    private Seat seat;

    @Enumerated
    private SeatStatus seatStatus;

}
