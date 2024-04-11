package com.project.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "theatres")
public class Theatre extends BaseModel{

    private String name;

    // Theatre:Region == M:1
    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;

    // Theatre:Screen == 1:M
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Screen> screens;
}
