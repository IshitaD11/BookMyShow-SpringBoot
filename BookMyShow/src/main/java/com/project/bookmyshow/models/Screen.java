package com.project.bookmyshow.models;

import com.project.bookmyshow.models.enums.ScreenFeatureTypes;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{

    private String name;

    // Screen:Seat == 1:M
    @OneToMany
    private List<Seat> seats;

    // Screen:Theatre == M:1
    @ManyToOne
    private Theatre theatre;

    @Enumerated   // check further
    private ScreenFeatureTypes screenFeatureTypes;
}
