package com.shopping.entities;

import com.shopping.enums.ClassificationEnum;
import com.shopping.enums.GenreEnum;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "tbl_movie")
@DiscriminatorValue("movie")
public class Movie extends Product {

    @NotNull
    @Column(name = "classification")
    private ClassificationEnum classification;

    @NotNull
    @Column(name = "genre")
    private GenreEnum genre;

    public ClassificationEnum getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEnum classification) {
        this.classification = classification;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }
}
