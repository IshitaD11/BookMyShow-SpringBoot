package com.project.bookmyshow.models;

import com.project.bookmyshow.models.enums.MovieGenre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "movies")
public class Movie extends BaseModel{

    private String name;

    // Movie:Actor == M:M
    @ManyToMany
    private List<Actor> cast;

    private int durationInMinutes;
    private Date releaseDate;

    @Enumerated(EnumType.ORDINAL)
    private MovieGenre genre;

    // Movie:Language == M:M
    @ManyToMany
    private List<Language> languages;


}
