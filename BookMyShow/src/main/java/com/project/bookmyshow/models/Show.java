package com.project.bookmyshow.models;

import com.project.bookmyshow.models.enums.FeatureTypes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{

    // Show:Screen == M:1
    @ManyToOne
    @JoinColumn(name = "screen_id", referencedColumnName = "id", nullable = false)
    private Screen screen;

    private Date showStartTime;

    private int duration;

    // Show:Movie == M:1
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @Enumerated
    @ElementCollection
    private List<FeatureTypes> showFeatures;

}
