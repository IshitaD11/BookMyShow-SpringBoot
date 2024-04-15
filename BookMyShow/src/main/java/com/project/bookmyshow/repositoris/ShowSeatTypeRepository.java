package com.project.bookmyshow.repositoris;

import com.project.bookmyshow.models.SeatType;
import com.project.bookmyshow.models.Show;
import com.project.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Integer> {

    ShowSeatType findByShowAndSeatType(Show show, SeatType seatType);
}
