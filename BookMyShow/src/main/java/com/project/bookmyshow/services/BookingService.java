package com.project.bookmyshow.services;


import com.project.bookmyshow.models.Booking;
import com.project.bookmyshow.models.Show;
import com.project.bookmyshow.models.ShowSeat;
import com.project.bookmyshow.models.User;
import com.project.bookmyshow.models.enums.BookingStatus;
import com.project.bookmyshow.models.enums.SeatStatus;
import com.project.bookmyshow.repositoris.BookingRepository;
import com.project.bookmyshow.repositoris.ShowRepository;
import com.project.bookmyshow.repositoris.ShowSeatRepository;
import com.project.bookmyshow.repositoris.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;
    @Autowired
    PriceCalculatorService priceCalculatorService;
    @Autowired
    BookingRepository bookingRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(
            List<Integer> showSeatIds,
            int showId,
            int userId  ){

        // Get user by userId
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty())
            throw new RuntimeException("User not found");

        User user = userOptional.get();

        // Get Show by showid
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty())
            throw new RuntimeException("Show not found");
        Show show = showOptional.get();

        // Get ShowSeats by showSeatIds
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        // check all showSeats are available. If not throw error
        for(ShowSeat showSeat:showSeats){
            if(!showSeat.getSeatStatus().equals(SeatStatus.EMPTY))
                throw new RuntimeException("Show Seat not empty");
        }

        // If showSeats available, make the seats blocked and save it in db
        List<ShowSeat> savedShowSeat = new ArrayList<>();
        for(ShowSeat showSeat:showSeats){
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            showSeat.setBookedAt(new Date());
            savedShowSeat.add(showSeatRepository.save(showSeat));
        }

        // create corresponding booking object
        Booking booking = new Booking();
        booking.setShowSeats(savedShowSeat);
        booking.setUser(user);
        booking.setShow(show);
        booking.setBookingAmount(priceCalculatorService.calculatePrice(savedShowSeat));
        booking.setBookingTime(new Date());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setPayments(new ArrayList<>());

        return bookingRepository.save(booking);

    }
}
