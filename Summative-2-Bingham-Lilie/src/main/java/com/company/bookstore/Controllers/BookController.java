package com.company.bookstore.Controllers;


import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository repo;


    //A POST route that creates a new book
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return repo.save(book);
    }


    //A GET route that returns a specific book by id
    @GetMapping("/books/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Book getBookById(@PathVariable int id) {

        Optional<Book> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }


    // GET route that gets all books
    @GetMapping("/books")
    public List<Book> getBooks() {
        return repo.findAll();
    }



    //A PUT route that updates an existing book
    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book customer) {
        repo.save(customer);
    }



    //A DELETE route that deletes an existing book
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        repo.deleteById(id);
    }


    //A GET route that returns all books for a certain author id
    @GetMapping("/books/author/{authorId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getBooksByAuthor(@PathVariable int authorId) {

        return repo.findByAuthorId(authorId);
    }

}
