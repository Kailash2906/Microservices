package com.calling.demo.Controller;

import com.calling.demo.FeignClients.BooksClient;
import com.calling.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallingController {

    @Autowired
    BooksClient booksClient;

    @GetMapping(value = "/getById/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBookById(@PathVariable Long id){
        Book book =  booksClient.getBook(id);
        return book;
    }
}
