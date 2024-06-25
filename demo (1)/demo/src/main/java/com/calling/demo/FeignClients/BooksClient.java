package com.calling.demo.FeignClients;

import com.calling.demo.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${books.service.url}", name = "BooksFeignClient")
public interface BooksClient {

    @GetMapping(value = "/findBook/{id}",consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook(@PathVariable Long id);


}
