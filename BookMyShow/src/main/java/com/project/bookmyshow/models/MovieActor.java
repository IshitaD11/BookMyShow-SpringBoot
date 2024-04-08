package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MovieActor extends BaseModel {

    private Movie movie;
    private Actor actor;
}
