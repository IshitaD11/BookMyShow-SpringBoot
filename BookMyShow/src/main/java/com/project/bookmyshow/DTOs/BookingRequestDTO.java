package com.project.bookmyshow.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequestDTO {

    private int userId;
    private int showId;
    private List<Integer> showSeatIds;
}
