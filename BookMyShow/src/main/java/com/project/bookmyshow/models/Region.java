package com.project.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "regions")
public class Region extends BaseModel{

    private String name;

    // Region:Theatre == 1:M
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Theatre> theatres;
}


//     Skip this, as we dont want another extra table for m:m mapping
//    // Region:Movie == M:M
//    @ManyToMany
//    private List<Movie> movies;
