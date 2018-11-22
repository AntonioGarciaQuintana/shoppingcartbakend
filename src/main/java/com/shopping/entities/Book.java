package com.shopping.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "tbl_book")
@DiscriminatorValue("book")
public class Book extends Product {

    @NotNull
    @Size( min = 1, max = 50)
    @Column(name = "isbn", length = 50)
    private String isbn;

    @NotNull
    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "author")
    private String author;


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
