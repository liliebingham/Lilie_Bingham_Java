package com.company.bookstore.repositories;

import static org.junit.Assert.*;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
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


@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepo;

    @Before
    public void setUp() {
        authorRepo.deleteAll();
    }

    @Test
    public void shouldGetAuthorByID() {
        Author author = new Author();

        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");

        author = authorRepo.save(author);

        Optional<Author> author1 = authorRepo.findById(author.getId());
        assertEquals(author1.get(), author);
    }

    @Test
    public void shouldAddAuthor() {
        Author author = new Author();

        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");

        author = authorRepo.save(author);

        Optional<Author> fromRepo = authorRepo.findById(author.getId());
        assertEquals(author, fromRepo.get());
    }

     @Test
    public void shouldUpdateAuthor() {
        Author author = new Author();

        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");


        author = authorRepo.save(author);

        // changing name and email
        author.setFirstName("Jack");
        author.setEmail("jack.smith@gmail.com");

        author = authorRepo.save(author);

        Optional<Author> fromRepo = authorRepo.findById(author.getId());
        assertEquals(author, fromRepo.get());
    }

    @Test
    public void shouldDeleteAuthor() {
        Author author = new Author();

        author.setFirstName("John");
        author.setLastName("Smith");
        author.setEmail("john.smith@gmail.com");
        author.setPhone("9198292929");
        author.setStreet("315 Towerview Road");
        author.setCity("Durham");
        author.setState("NC");
        author.setPostalCode("27708");


        author = authorRepo.save(author);

        authorRepo.deleteById(author.getId());

        Optional<Author> author1 = authorRepo.findById(author.getId());
        assertFalse(author1.isPresent());
    }

    @Test
    public void getAllAuthors() {


        Author author1 = new Author();

        author1.setFirstName("John");
        author1.setLastName("Smith");
        author1.setEmail("john.smith@gmail.com");
        author1.setPhone("9198292929");
        author1.setStreet("315 Towerview Road");
        author1.setCity("Durham");
        author1.setState("NC");
        author1.setPostalCode("27708");

        author1 = authorRepo.save(author1);

        Author author2 = new Author();

        author2.setFirstName("Bob");
        author2.setLastName("Smith");
        author2.setEmail("bob.smith@gmail.com");
        author2.setPhone("9198278892");
        author2.setStreet("300 Swift Ave");
        author2.setCity("Durham");
        author2.setState("NC");
        author2.setPostalCode("27708");


        author2 = authorRepo.save(author2);

        List<Author> authorList = authorRepo.findAll();
        System.out.println(authorList);

        //Assert...
        assertEquals(2, authorList.size());
    }

}