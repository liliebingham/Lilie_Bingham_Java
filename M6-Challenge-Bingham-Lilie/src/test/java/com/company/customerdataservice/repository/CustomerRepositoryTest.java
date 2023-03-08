package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }


    //A POST route that creates a new customer
    @Test
    public void shouldAddCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setEmail("joesmith@mail.com");
        customer.setCompany("BigCo");
        customer.setPhone("111-222-3456");
        customer.setAddress1("1566 Green St");
        customer.setAddress2("1555 Blue St");
        customer.setCity("Berkeley");
        customer.setState("CA");
        customer.setPostalCode("46865");
        customer.setCountry("USA");

        //Act...
        customer = customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }


    //A PUT route that updates an existing customer
    @Test
    public void shouldUpdateCustomerById() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setEmail("joesmith@mail.com");
        customer.setCompany("BigCo");
        customer.setPhone("111-222-3456");
        customer.setAddress1("1566 Green St");
        customer.setAddress2("1555 Blue St");
        customer.setCity("Berkeley");
        customer.setState("CA");
        customer.setPostalCode("46865");
        customer.setCountry("USA");

        customerRepo.save(customer);

        //Act...
        customer.setFirstName("UPDATED");

        customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }


    //A DELETE route that deletes an existing customer
    @Test
    public void shouldDeleteCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setEmail("joesmith@mail.com");
        customer.setCompany("BigCo");
        customer.setPhone("111-222-3456");
        customer.setAddress1("1566 Green St");
        customer.setAddress2("1555 Blue St");
        customer.setCity("Berkeley");
        customer.setState("CA");
        customer.setPostalCode("46865");
        customer.setCountry("USA");



        customerRepo.save(customer);

        //Act...
        customerRepo.deleteById(customer.getId());

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }


    //A GET route that returns a specific customer by id
    @Test
    public void shouldGetCustomerById() {

        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setEmail("joesmith@mail.com");
        customer.setCompany("BigCo");
        customer.setPhone("111-222-3456");
        customer.setAddress1("1566 Green St");
        customer.setAddress2("1555 Blue St");
        customer.setCity("Berkeley");
        customer.setState("CA");
        customer.setPostalCode("46865");
        customer.setCountry("USA");

        customerRepo.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Alice");
        customer2.setLastName("Smith");
        customer2.setEmail("alicesmith@mail.com");
        customer2.setCompany("SmallCo");
        customer2.setPhone("222-222-2222");
        customer2.setAddress1("1566 Yellow St");
        customer2.setAddress2("1555 Pink St");
        customer2.setCity("Albany");
        customer2.setState("NY");
        customer2.setPostalCode("35896");
        customer2.setCountry("USA");

        customerRepo.save(customer2);

        //Act...
        Optional<Customer> foundCustomer = customerRepo.findById(customer.getId());

        //Assert...
        assertEquals(foundCustomer.get(), customer);
    }



    //A GET route that returns all customers for a specific state
    @Test
    public void shouldGetCustomersByState() {

        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setEmail("joesmith@mail.com");
        customer.setCompany("BigCo");
        customer.setPhone("111-222-3456");
        customer.setAddress1("1566 Green St");
        customer.setAddress2("1555 Blue St");
        customer.setCity("Berkeley");
        customer.setState("CA");
        customer.setPostalCode("46865");
        customer.setCountry("USA");

        customerRepo.save(customer);


        Customer customer2 = new Customer();
        customer2.setFirstName("Alice");
        customer2.setLastName("Smith");
        customer2.setEmail("alicesmith@mail.com");
        customer2.setCompany("SmallCo");
        customer2.setPhone("222-222-2222");
        customer2.setAddress1("1566 Yellow St");
        customer2.setAddress2("1555 Pink St");
        customer2.setCity("Albany");
        customer2.setState("NY");
        customer2.setPostalCode("35896");
        customer2.setCountry("USA");

        customerRepo.save(customer2);


        Customer customer3 = new Customer();
        customer3.setFirstName("Wanda");
        customer3.setLastName("Jones");
        customer3.setEmail("wandajones@mail.com");
        customer3.setCompany("MedCo");
        customer3.setPhone("888-555-3333");
        customer3.setAddress1("1566 Green St");
        customer3.setAddress2("1555 Orange St");
        customer3.setCity("New York");
        customer3.setState("NY");
        customer3.setPostalCode("86456");
        customer3.setCountry("USA");

        customerRepo.save(customer3);

        //Act...
        List<Customer> foundCustomer = customerRepo.findByState(customer2.getState());

        //Assert...
        List<Customer> customerResult = new ArrayList<>();
        customerResult.add(customer2);
        customerResult.add(customer3);

        assertEquals(foundCustomer.size(), customerResult.size());
        assertEquals(foundCustomer, customerResult);
    }

}