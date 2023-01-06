package com.distribuida.servicios;

import com.distribuida.config.DbConfig;
import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookServiceImpl implements BookService{

    public static final String POSTGRESS_SELECT = "SELECT * FROM books;";
    public static final String POSTGRESS_FIND_BY_ID = "SELECT * FROM books WHERE id = ?;";
    public static final String POSTGRESS_INSERT = "INSERT INTO books(author, isbn, price, title) VALUES (:author, :isbn, :price, :title);";
    public static final String POSTGRESS_UPDATE = "UPDATE books SET author = :author, isbn = :isbn, price = :price, title = :title WHERE id = :id;";
    public static final String POSTGRESS_DELETE = "DELETE FROM books WHERE id = :id;";

    @Inject
    private DataSource dataSource;
    public List<Book> findAll(){
        Jdbi jdbi = Jdbi.create(dataSource);
        Handle handle = jdbi.open();

        List<Book> books = handle.createQuery(POSTGRESS_SELECT)
                .mapToBean(Book.class)
                .list();

        return books;
    }
    public Book findById (Integer id){
        Jdbi jdbi = Jdbi.create(dataSource);
        Handle handle = jdbi.open();

        Book book = handle.select(POSTGRESS_FIND_BY_ID, id)
                .mapToBean(Book.class)
                .one();

        return book;
    }

    @Override
    public int insert(Book book) {
        Jdbi jdbi = Jdbi.create(dataSource);
        Handle handle = jdbi.open();

        int rowa = handle.createUpdate(POSTGRESS_INSERT)
                .bind("isbn",book.getIsbn())
                .bind("author", book.getAuthor())
                .bind("price",book.getPrice())
                .bind("title",book.getTitle())
                .execute();
        return rowa;
    }

    @Override
    public int update(Integer integer,Book book) {
        Jdbi jdbi = Jdbi.create(dataSource);
        Handle handle = jdbi.open();

        int rowa = handle.createUpdate(POSTGRESS_UPDATE)
                .bind("isbn",book.getIsbn())
                .bind("author", book.getAuthor())
                .bind("price",book.getPrice())
                .bind("title",book.getTitle())
                .bind("id",integer)
                .execute();
        return rowa;
    }

    @Override
    public int delete(Integer id) {
        Jdbi jdbi = Jdbi.create(dataSource);
        Handle handle = jdbi.open();

        int rowa = handle.createUpdate(POSTGRESS_DELETE)
                .bind("id",id)
                .execute();
        return rowa;
    }
}
