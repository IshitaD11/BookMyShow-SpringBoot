package com.project.bookmyshow.models;

import com.project.bookmyshow.models.enums.PaymentMode;
import com.project.bookmyshow.models.enums.PaymentProvider;
import com.project.bookmyshow.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{

    private String paymentRefNumber;
    private float paymentAmount;

    // Payment:User == M:1
    @ManyToOne
    private User user;

    private PaymentProvider paymentProvider;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
}
