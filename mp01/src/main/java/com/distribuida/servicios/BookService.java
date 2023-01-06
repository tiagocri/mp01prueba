package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;

public interface BookService {
    public Book findById(Integer id);
    public List<Book> findAll();
    public int insert(Book book);
    public int update(Integer integer,Book book);
    public int delete(Integer id);

}