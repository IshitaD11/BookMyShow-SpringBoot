package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{

    private String name;

    // Theatre:Region == M:1
    @ManyToOne
    private Region region;

    // Theatre:Screen == 1:M
    @OneToMany
    private List<Screen> screens;
}
