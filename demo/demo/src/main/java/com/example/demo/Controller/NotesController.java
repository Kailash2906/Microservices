package com.example.demo.Controller;

import com.example.demo.Service.BooksService;
import com.example.demo.model.AuthenticationResponse;
import com.example.demo.model.Book;
import com.example.demo.model.AuthenticationRequest;
import com.example.demo.util.JWSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotesController {

    @Autowired
    private BooksService booksService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JWSUtil jwtUtil;


    @GetMapping(value = "/findBook/{id}",consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook(@PathVariable Long id){

        Book book =  booksService.findBookById(id);
        return book;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> doAuthentication(@RequestBody AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getPassword());

        String jwt =  jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

//    @PostMapping(value = "/addBook")
//    public Book addBook(@RequestBody @Valid Book book){
//        return booksService.addBook(book);
//    }
//
//    @PutMapping(value = "/modifyBook")
//    public Book modifyBook(@RequestBody @Valid Book book){
//        return booksService.modifyBook(book);
//    }
}
