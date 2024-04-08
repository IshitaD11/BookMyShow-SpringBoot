package com.project.bookmyshow.models;

import com.project.bookmyshow.models.enums.MovieGenre;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{

    private String name;

    // Movie:Actor == M:M
    @ManyToMany
    private List<Actor> cast;

    private int durationInMinutes;
    private Date releaseDate;
    private MovieGenre genre;

    // Movie:Language == 1:M ????
    @OneToMany
    private List<Language> languages;


}
