package com.company.bookstore.Controllers;

import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.BookRepository;
import com.company.bookstore.repositories.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;
import java.util.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublisherRepository publisherRepo;


    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    private List<Publisher> publisherList;

    // Testing GET /publishers/{id}
    @Test
    public void shouldReturnPublisherByID() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(publisherList);

        Publisher publisher = new Publisher();

        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");
        publisher.setId(1);

        publisherRepo.save(publisher);
        // ACT
        mockMvc.perform(get("/publishers/1"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

     // Testing GET /publishers
    @Test
    public void shouldReturnAllPublishers() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(publisherList);

        Publisher publisher = new Publisher();

        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");
        publisher.setId(1);

        publisherRepo.save(publisher);
        // ACT
        mockMvc.perform(get("/publishers"))                  // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    // Testing PUT /publishers
    @Test
    public void shouldUpdatePublisherAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        Publisher publisher = new Publisher();

        publisher.setName("Joe Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");
        publisher.setId(1);

        publisherRepo.save(publisher);

        String inputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(put("/publishers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing POST /publishers
    @Test
    public void shouldReturnNewPublisherOnPostRequest() throws Exception {

        // ARRANGE
        Publisher publisher = new Publisher();

        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");

        publisherRepo.save(publisher);

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(publisher);

        // ACT
        mockMvc.perform(
                        post("/publishers")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    // Testing DELETE /publishers/{id}
    @Test
    public void shouldDeletePublisherAndReturn204StatusCode() throws Exception {

        Publisher publisher = new Publisher();

        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");
        publisher.setId(1);


        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/publishers/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}