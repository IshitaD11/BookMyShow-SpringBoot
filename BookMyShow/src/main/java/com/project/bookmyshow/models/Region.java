package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel{

    private String name;

    // Region:Movie == M:M
    @ManyToMany
    private List<Movie> movies;

    // Region:Theatre == 1:M
    @OneToMany
    private List<Theatre> theatres;
}
