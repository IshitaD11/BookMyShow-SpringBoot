package com.project.bookmyshow.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDTO {

    private int bookingId;
    private ResponseStatus responseStatus;
    private float amount;

}
