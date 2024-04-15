package com.project.bookmyshow.services;

import com.project.bookmyshow.models.SeatType;
import com.project.bookmyshow.models.Show;
import com.project.bookmyshow.models.ShowSeat;
import com.project.bookmyshow.models.ShowSeatType;
import com.project.bookmyshow.repositoris.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private float totalAmount = 0;

    @Autowired
    ShowSeatTypeRepository showSeatTypeRepository;


    public float calculatePrice(List<ShowSeat> showSeatList){

        for(ShowSeat showSeat:showSeatList){
            SeatType seatType = showSeat.getSeat().getSeatType();
            Show show = showSeat.getShow();
            ShowSeatType showSeatType = showSeatTypeRepository.findByShowAndSeatType(show,seatType);
            totalAmount += showSeatType.getPrice();
        }

        return totalAmount;
    }
}
