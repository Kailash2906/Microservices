package com.example.demo.Service;

import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BooksService {

//    @Autowired
//    private BookRepository bookRepository;


    public Book findBookById(Long id) {
        Book book  = new Book();
        book.setId(123L);
        book.setAuthor("John Doe");
        book.setDescription("A book");
        book.setName("A book on John Doe");
        return book;
    }

//    public Book addBook(Book book) {
//        Book returnBook = bookRepository.save(book);
//        if(returnBook.getId() > 0)
//            return returnBook;
//        return new Book();
//    }
//
//    public Book modifyBook(Book book) {
//        Optional<Book> validBook = bookRepository.findById(book.getId());
//        Book bookToSave = new Book();
//        if(validBook.isPresent()){
//            bookToSave = validBook.get();
//            bookToSave.setAuthor(book.getAuthor());
//        }
//        return bookRepository.save(bookToSave);
//    }
}
