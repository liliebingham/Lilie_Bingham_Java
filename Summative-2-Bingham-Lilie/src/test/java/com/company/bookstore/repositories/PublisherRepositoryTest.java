package com.company.bookstore.repositories;

import com.company.bookstore.models.Publisher;
import com.company.bookstore.models.Book;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {

    @Autowired
    PublisherRepository publisherRepo;

    @Before
    public void setUp() {
        publisherRepo.deleteAll();
    }

@Test
    public void shouldGetPublisherByID() {
        Publisher publisher = new Publisher();

        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");

        publisher = publisherRepo.save(publisher);

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());
        assertEquals(publisher1.get(), publisher);
    }

    @Test
    public void shouldAddPublisher() {
        Publisher publisher = new Publisher();

        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");

        publisher = publisherRepo.save(publisher);

        Optional<Publisher> fromRepo = publisherRepo.findById(publisher.getId());

        assertEquals(publisher, fromRepo.get());
    }

     @Test
    public void shouldUpdatePublisher() {
        Publisher publisher = new Publisher();

        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");

        publisher = publisherRepo.save(publisher);


        // changing name and email
        publisher.setName("Jack Smith");
        publisher.setEmail("jack.smith@gmail.com");

        publisher = publisherRepo.save(publisher);

        Optional<Publisher> fromRepo = publisherRepo.findById(publisher.getId());
        assertEquals(publisher, fromRepo.get());
    }

    @Test
    public void shouldDeletePublisher() {
        Publisher publisher = new Publisher();

        publisher.setName("John Smith");
        publisher.setEmail("john.smith@gmail.com");
        publisher.setPhone("9198292929");
        publisher.setStreet("315 Towerview Road");
        publisher.setCity("Durham");
        publisher.setState("NC");
        publisher.setPostalCode("27708");

        publisher = publisherRepo.save(publisher);

        publisherRepo.deleteById(publisher.getId());

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());
        assertFalse(publisher1.isPresent());
    }

    @Test
    public void getAllPublishers() {


        Publisher publisher1 = new Publisher();

        publisher1.setName("John Smith");
        publisher1.setEmail("john.smith@gmail.com");
        publisher1.setPhone("9198292929");
        publisher1.setStreet("315 Towerview Road");
        publisher1.setCity("Durham");
        publisher1.setState("NC");
        publisher1.setPostalCode("27708");

        publisher1 = publisherRepo.save(publisher1);

        Publisher publisher2 = new Publisher();

        publisher2.setName("Bob Smith");
        publisher2.setEmail("bob.smith@gmail.com");
        publisher2.setPhone("9198294892");
        publisher2.setStreet("300 Swift Ave");
        publisher2.setCity("Durham");
        publisher2.setState("NC");
        publisher2.setPostalCode("27708");

        publisher2 = publisherRepo.save(publisher2);

        List<Publisher> publisherList = publisherRepo.findAll();

        //Assert...
        assertEquals(2, publisherList.size());
    }
}