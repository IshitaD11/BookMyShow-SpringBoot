package com.project.bookmyshow.models;

import com.project.bookmyshow.models.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "bookings")
public class Booking extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    // Booking:User == M:1
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    private float bookingAmount;
    private Date bookingTime;

    // Booking:ShowSeat == M:M --> as cancelled booking also have showseat
    @ManyToMany(cascade = CascadeType.ALL)
    private List<ShowSeat> showSeats;

    // for partial payments having multiple payment type
    // also sometimes payment fails, and refunded and again paid
    // Booking:Payment == 1:M
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Payment> payments;

    // Booking:Show == M:1
    @ManyToOne
    @JoinColumn(name = "show_id", referencedColumnName = "id")
    private Show show;


    public void bookSeat(){
        System.out.println("Booking Seat");
    }
}
