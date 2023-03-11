package com.company.bookstore.repositories;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    AuthorRepository authorRepo;

    @Autowired
    PublisherRepository publisherRepo;

    @Before
    public void setUp() throws Exception {
        bookRepo.deleteAll();
        publisherRepo.deleteAll();
        authorRepo.deleteAll();
    }


    //should create a new book
    @Test
    public void shouldAddBook() {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");
        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");
        publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("1234");
        book.setPublishDate(LocalDate.of(2022, 2, 2));
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setTitle("Title");
        book.setPrice(new BigDecimal("17.00"));

        book = bookRepo.save(book);

        Optional<Book> fromRepo = bookRepo.findById(book.getId());

        assertEquals(book, fromRepo.get());
    }


    //read book by id
    //A GET route that returns a specific customer by id
    @Test
    public void shouldGetBookById() {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");
        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");
        publisherRepo.save(publisher);

    
        Book book = new Book();
        book.setIsbn("1234");
        book.setPublishDate(LocalDate.of(2022, 2, 2));
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setTitle("Title");
        book.setPrice(new BigDecimal("17.00"));
        book = bookRepo.save(book);

        Author author2 = new Author();
        author2.setFirstName("John");
        author2.setLastName("Smith");
        author2.setEmail("john.smith@gmail.com");
        author2.setPhone("9198292929");
        author2.setStreet("315 Towerview Road");
        author2.setCity("Durham");
        author2.setState("NC");
        author2.setPostalCode("27708");
        authorRepo.save(author2);

        Publisher publisher2 = new Publisher();
        publisher2.setName("John Smith");
        publisher2.setEmail("john.smith@gmail.com");
        publisher2.setPhone("9198292929");
        publisher2.setStreet("315 Towerview Road");
        publisher2.setCity("Durham");
        publisher2.setState("NC");
        publisher2.setPostalCode("27708");
        publisherRepo.save(publisher2);

        Book book2 = new Book();
        book2.setIsbn("9876");
        book.setPublishDate(LocalDate.of(2022, 2, 2));
        book2.setTitle("Title");
        book2.setAuthorId(author2.getId());
        book2.setPublisherId(publisher2.getId());
        book2.setPrice(new BigDecimal("20.00"));

        book2 = bookRepo.save(book2);


        Optional<Book> foundBook = bookRepo.findById(book.getId());

        assertEquals(foundBook.get(), book);
    }

    @Test
    public void getAllBooks() {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");
        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");
        publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("1234");
        book.setPublishDate(LocalDate.of(2022, 2, 2));
        book.setTitle("Title");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("17.00"));
        book = bookRepo.save(book);

        Author author2 = new Author();
        author2.setFirstName("John");
        author2.setLastName("Smith");
        author2.setEmail("john.smith@gmail.com");
        author2.setPhone("9198292929");
        author2.setStreet("315 Towerview Road");
        author2.setCity("Durham");
        author2.setState("NC");
        author2.setPostalCode("27708");
        authorRepo.save(author2);

        Publisher publisher2 = new Publisher();
        publisher2.setName("John Smith");
        publisher2.setEmail("john.smith@gmail.com");
        publisher2.setPhone("9198292929");
        publisher2.setStreet("315 Towerview Road");
        publisher2.setCity("Durham");
        publisher2.setState("NC");
        publisher2.setPostalCode("27708");
        publisherRepo.save(publisher2);

        Book book2 = new Book();
        book2.setIsbn("9876");
        book.setPublishDate(LocalDate.of(2022, 2, 2));
        book2.setAuthorId(author2.getId());
        book2.setTitle("Title");
        book2.setPublisherId(publisher2.getId());
        book2.setPrice(new BigDecimal("17.00"));
        book2 = bookRepo.save(book2);

        List<Book> bookList = bookRepo.findAll();

        assertEquals(2, bookList.size());
    }

    @Test
    public void shouldUpdateBook() {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");
        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");
        publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("1234");
        book.setPublishDate(LocalDate.of(2022, 2, 2));
        book.setTitle("Title");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("17.00"));

        book = bookRepo.save(book);

        // changing isbn
        book.setIsbn("6754");
        book = bookRepo.save(book);


        Optional<Book> fromRepo = bookRepo.findById(book.getId());
        assertEquals(book, fromRepo.get());
    }


    @Test
    public void shouldDeleteBook() {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");
        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");
        publisherRepo.save(publisher);


        Book book = new Book();
        book.setIsbn("1234");
        book.setPublishDate(LocalDate.of(2022, 2, 2));
        book.setTitle("Title");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("17.00"));
        book = bookRepo.save(book);

        bookRepo.deleteById(book.getId());

        Optional<Book> book1 = bookRepo.findById(book.getId());
        assertFalse(book1.isPresent());
    }

    @Test
    public void shouldGetBookByAuthorId() {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");
        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");
        publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("1234");
        book.setTitle("Title");
        book.setPublishDate(LocalDate.of(2022, 2, 2));
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("17.00"));
        book = bookRepo.save(book);


        Publisher publisher2 = new Publisher();
        publisher2.setName("John Smith");
        publisher2.setEmail("john.smith@gmail.com");
        publisher2.setPhone("9198292929");
        publisher2.setStreet("315 Towerview Road");
        publisher2.setCity("Durham");
        publisher2.setState("NC");
        publisher2.setPostalCode("27708");
        publisherRepo.save(publisher2);

        Book book2 = new Book();
        book2.setTitle("Title");
        book2.setIsbn("9876");
        book.setPublishDate(LocalDate.of(2022, 2, 2));
        book2.setAuthorId(author.getId());
        book2.setPublisherId(publisher2.getId());
        book2.setPrice(new BigDecimal("17.00"));
        book2 = bookRepo.save(book2);



        Author author3 = new Author();
        author3.setFirstName("John");
        author3.setLastName("Smith");
        author3.setEmail("john.smith@gmail.com");
        author3.setPhone("9198292929");
        author3.setStreet("315 Towerview Road");
        author3.setCity("Durham");
        author3.setState("NC");
        author3.setPostalCode("27708");
        authorRepo.save(author3);

        Publisher publisher3 = new Publisher();
        publisher3.setName("John Smith");
        publisher3.setEmail("john.smith@gmail.com");
        publisher3.setPhone("9198292929");
        publisher3.setStreet("315 Towerview Road");
        publisher3.setCity("Durham");
        publisher3.setState("NC");
        publisher3.setPostalCode("27708");
        publisherRepo.save(publisher3);

        Book book3 = new Book();
        book3.setIsbn("9876");
        book3.setPublishDate(LocalDate.of(2022, 2, 2));
        book3.setAuthorId(author3.getId());
        book3.setPublisherId(publisher3.getId());
        book3.setTitle("Title");
        book3.setPrice(new BigDecimal("17.00"));

        book3 = bookRepo.save(book3);

        List<Book> bookList = bookRepo.findByAuthorId(author.getId());

        assertEquals(2, bookList.size());
    }

}