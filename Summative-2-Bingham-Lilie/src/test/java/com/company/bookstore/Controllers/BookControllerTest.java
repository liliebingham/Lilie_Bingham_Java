package com.company.bookstore.Controllers;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.AuthorRepository;
import com.company.bookstore.repositories.BookRepository;
import com.company.bookstore.repositories.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {


    @Before
    public void setUp() {
        authorRepo.deleteAll();
        publisherRepo.deleteAll();
        bookRepo.deleteAll();
    }


    @MockBean
    private BookRepository bookRepo;

    @MockBean
    private AuthorRepository authorRepo;

    @MockBean
    private PublisherRepository publisherRepo;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();



    // Testing POST /books
    @Test
    public void shouldAddBookAndReturn204StatusCode() throws Exception {

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

        mapper.findAndRegisterModules();
        String inputJson = mapper.writeValueAsString(book);

        mockMvc.perform(post("/books")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // Testing GET /books/{id}
    @Test
    public void shouldReturnBookByID() throws Exception {


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

        bookRepo.save(book);
        // ACT
        mockMvc.perform(get("/books/" + book.getId()))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }



    // Testing GET /books
    @Test
    public void shouldReturnAllPublishers() throws Exception {


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

        bookRepo.save(book);


        mockMvc.perform(get("/books"))                  // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }


    // Testing PUT /books
    @Test
    public void shouldUpdatePublisherAndReturn204StatusCode() throws Exception {


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
        book.setTitle("Title2");
        book.setPrice(new BigDecimal("17.00"));

        bookRepo.save(book);

        mapper.findAndRegisterModules();
        String inputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(put("/books")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }



    // Testing DELETE /books/{id}
    @Test
    public void shouldDeletePublisherAndReturn204StatusCode() throws Exception {

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
        book.setTitle("Title2");
        book.setPrice(new BigDecimal("17.00"));

        bookRepo.save(book);


        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/books/" + book.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing GET books/state/{state}
    @Test
    public void shouldReturnBooksByAuthor() throws Exception {

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
        book.setTitle("Title2");
        book.setPrice(new BigDecimal("17.00"));

        bookRepo.save(book);

        mockMvc.perform(get("/books/author/" + author.getId()))
                .andDo(print())
                .andExpect(status().isOk());

    }
























}