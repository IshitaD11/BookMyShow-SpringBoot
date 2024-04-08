package com.project.bookmyshow.models;

import com.project.bookmyshow.models.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{

    private BookingStatus bookingStatus;

    // Booking:User == M:1
    @ManyToOne
    private User user;

    private float bookingAmount;
    private Date bookingTime;

    // Booking:ShowSeat == M:M --> as cancelled booking also have showseat
    @ManyToMany
    private List<ShowSeat> showSeats;

    // for partial payments having multiple payment type
    // also sometimes payment fails, and refunded and again paid
    // Booking:Payment == 1:M
    @OneToMany
    private List<Payment> payments;
}
