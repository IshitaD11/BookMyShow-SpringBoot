package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Show extends BaseModel{

    // Show:Screen == M:1
    @ManyToOne
    private Screen screen;

    private Date showTime;

    // Show:Movie == M:1
    @ManyToOne
    private Movie movie;

}
