package com.project.bookmyshow.controllers;

import com.project.bookmyshow.DTOs.BookingRequestDTO;
import com.project.bookmyshow.DTOs.ResponseStatus;
import com.project.bookmyshow.DTOs.BookingResponseDTO;
import com.project.bookmyshow.models.Booking;
import com.project.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;

    public BookingResponseDTO bookTickets(BookingRequestDTO request){
        BookingResponseDTO response = new BookingResponseDTO();

        try{
            Booking booking = bookingService.bookTicket(
                    request.getShowSeatIds(),
                    request.getShowId(),
                    request.getUserId()
            );
            response.setBookingId(booking.getId());
            response.setAmount(booking.getBookingAmount());
            response.setResponseStatus(ResponseStatus.SUCCESS);

        }catch (Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }

        return response;
    }
}
