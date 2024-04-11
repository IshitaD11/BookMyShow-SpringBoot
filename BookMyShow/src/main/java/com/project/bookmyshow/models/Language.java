package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "languages")
public class Language extends BaseModel{
    private String language;
}
