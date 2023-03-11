package com.company.bookstore.Controllers;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import java.util.*;

import com.company.bookstore.repositories.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @MockBean
    private AuthorRepository authorRepo;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Author> authorList;

    @Before
    public void setUp() {
        authorRepo.deleteAll();
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
    }

    // Testing GET /authors/{id}
    @Test
    public void shouldReturnAuthorByID() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(authorList);

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");
        Set<Book> books = new HashSet<Book>();
        author.setBooks(books);
        author.setId(1);

        authorRepo.save(author);
        // ACT
        mockMvc.perform(get("/authors/1"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    // Testing GET /authors
    @Test
    public void shouldReturnAllAuthors() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(authorList);

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");
        Set<Book> books = new HashSet<Book>();
        author.setBooks(books);

        authorRepo.save(author);
        // ACT
        mockMvc.perform(get("/authors"))                  // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    // Testing PUT /authors
    @Test
    public void shouldUpdateAuthorAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");
        Set<Book> books = new HashSet<Book>();
        author.setBooks(books);

        authorRepo.save(author);

        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(put("/authors")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    // Testing POST /authors
    @Test
    public void shouldAddAuthorAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");
        Set<Book> books = new HashSet<Book>();
        author.setBooks(books);

        authorRepo.save(author);

        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(post("/authors")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // Testing DELETE /authors/{id}
    @Test
    public void shouldDeleteAuthorAndReturn204StatusCode() throws Exception {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");
        Set<Book> books = new HashSet<Book>();
        author.setBooks(books);
        author.setId(1);


        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/authors/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}