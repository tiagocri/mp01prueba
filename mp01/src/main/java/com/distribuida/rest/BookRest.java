package com.distribuida.rest;


import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Path("/books")
public class BookRest {
    @Inject private BookService bookService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book findById(@PathParam("id") Integer  id){
        return bookService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> findAll(){
        List<Book> books = bookService.findAll();
        return books;
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String insert(Book book){
        int resues = bookService.insert(book);
        if (resues == 1){
            return "Se inserto correctamente el nuevo libro";
        }
        return "Algo Salio mal";
    }
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(@PathParam("id") Integer id,Book book){
        int resues = bookService.update(id,book);
        if (resues == 1){
            return "Se actualizo correctamente el nuevo libro";
        }
        return "Algo Salio mal";
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") Integer id){
        int resues = bookService.delete(id);
        if (resues == 1){
            return "Se elimino correctamente el nuevo libro";
        }
        return "Algo Salio mal";
    }

}
