package com.example.demo.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.Data;

import lombok.Data;

//@Entity
@Data
public class Book {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//
//    @Size(min = 5)
    private String name;

    //    @NotNull
    private String author;

//    @NotNull
    private String description;
}
