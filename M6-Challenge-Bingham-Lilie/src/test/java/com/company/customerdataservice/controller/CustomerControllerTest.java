package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepo;



    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {
        //customerRepo.deleteAll();
    }

    // Testing POST /customers
    @Test
    public void shouldReturnNewCustomerOnPostRequest() throws Exception {

        // ARRANGE
        Customer inputCustomer = new Customer();
        inputCustomer.setFirstName("Joe");
        inputCustomer.setLastName("Smith");
        inputCustomer.setEmail("joesmith@mail.com");
        inputCustomer.setCompany("BigCo");
        inputCustomer.setPhone("111-222-3456");
        inputCustomer.setAddress1("1566 Green St");
        inputCustomer.setAddress2("1555 Blue St");
        inputCustomer.setCity("Berkeley");
        inputCustomer.setState("CA");
        inputCustomer.setPostalCode("46865");
        inputCustomer.setCountry("USA");
        //inputCustomer.setId(2);

        customerRepo.save(inputCustomer);


        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputCustomer);


        // ACT
        mockMvc.perform(
                        post("/customers")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }


    // Testing GET customers/{id}
    @Test
    public void shouldReturnCustomerById() throws Exception {

        Customer customer = new Customer();
        customer.setFirstName("Alice");
        customer.setLastName("Smith");
        customer.setEmail("alicesmith@mail.com");
        customer.setCompany("SmallCo");
        customer.setPhone("222-222-2222");
        customer.setAddress1("1566 Yellow St");
        customer.setAddress2("1555 Pink St");
        customer.setCity("Albany");
        customer.setState("NY");
        customer.setPostalCode("35896");
        customer.setCountry("USA");
        customer.setId(7);

        customerRepo.save(customer);


        mockMvc.perform(get("/customers/7"))
                .andDo(print())
                .andExpect(status().isOk());
    }



    // Testing PUT /customers
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        Customer inputCustomer = new Customer();
        inputCustomer.setFirstName("Joel");
        inputCustomer.setLastName("Smith");
        inputCustomer.setEmail("joelsmith@mail.com");
        inputCustomer.setCompany("BigCo");
        inputCustomer.setPhone("111-222-3456");
        inputCustomer.setAddress1("1566 Green St");
        inputCustomer.setAddress2("1555 Blue St");
        inputCustomer.setCity("Berkeley");
        inputCustomer.setState("CA");
        inputCustomer.setPostalCode("46865");
        inputCustomer.setCountry("USA");
        inputCustomer.setId(2);

        customerRepo.save(inputCustomer);


        String inputJson = mapper.writeValueAsString(inputCustomer);

        mockMvc.perform(
                        put("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }



    // Testing DELETE /customers/{id}
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        Customer inputCustomer = new Customer();
        inputCustomer.setFirstName("Joel");
        inputCustomer.setLastName("Smith");
        inputCustomer.setEmail("joelsmith@mail.com");
        inputCustomer.setCompany("BigCo");
        inputCustomer.setPhone("111-222-3456");
        inputCustomer.setAddress1("1566 Green St");
        inputCustomer.setAddress2("1555 Blue St");
        inputCustomer.setCity("Berkeley");
        inputCustomer.setState("CA");
        inputCustomer.setPostalCode("46865");
        inputCustomer.setCountry("USA");
        inputCustomer.setId(2);

        customerRepo.save(inputCustomer);

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/customers/2"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }



    // Testing GET customers/state/{state}
    @Test
    public void shouldReturnCustomerByState() throws Exception {

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

        List<Customer> customerResult = new ArrayList<>();
        customerResult.add(customer2);
        customerResult.add(customer3);


        mockMvc.perform(get("/customers/state/NY"))
                .andDo(print())
                .andExpect(status().isOk());

    }





}