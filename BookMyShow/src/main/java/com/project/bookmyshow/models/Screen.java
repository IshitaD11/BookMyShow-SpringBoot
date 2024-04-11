package com.project.bookmyshow.models;

import com.project.bookmyshow.models.enums.FeatureTypes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "screens")
public class Screen extends BaseModel{

    private String name;

    // Screen:Seat == 1:M
    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<Seat> seats;

    // Screen:Theatre == M:1
    @ManyToOne
    @JoinColumn(name = "theatre_id", referencedColumnName = "id", nullable = false)
    private Theatre theatre;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<FeatureTypes> screenFeatureTypes;
}
