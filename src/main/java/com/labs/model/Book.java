package com.labs.model;

import java.time.Year;

public abstract class Book {
    private String author;
    private String name;
    private String publication;
    private Year yearOfPublication;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public int getYearOfPublication() {
        return yearOfPublication.getValue();
    }

    public void setYearOfPublication(Year yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
