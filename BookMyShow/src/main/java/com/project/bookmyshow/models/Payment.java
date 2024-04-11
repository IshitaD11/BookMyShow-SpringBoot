package com.project.bookmyshow.models;

import com.project.bookmyshow.models.enums.PaymentMode;
import com.project.bookmyshow.models.enums.PaymentProvider;
import com.project.bookmyshow.models.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.print.Book;
import java.util.List;

@Getter
@Setter
@Entity(name = "payments")
public class Payment extends BaseModel{

    private int paymentRefNumber;
    private float paymentAmount;

    // Payment:User == M:1
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    @Enumerated
    private PaymentProvider paymentProvider;

    @Enumerated
    private PaymentStatus paymentStatus;

    @Enumerated
    private PaymentMode paymentMode;
}
