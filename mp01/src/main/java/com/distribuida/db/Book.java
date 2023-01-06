package com.distribuida.db;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
public class Book implements Serializable {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String isbn;
    @Getter @Setter
    private String title;
    @Getter @Setter
    private String author;
    @Getter @Setter
    private Double price;

    public Book() {

    }
    public Book(Integer id) {
        this.id = id;
    }

    public Book(String isbn, String title, String author, Double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(Integer id, String isbn, String title, String author, Double price) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
