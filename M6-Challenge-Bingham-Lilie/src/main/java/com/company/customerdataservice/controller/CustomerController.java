package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repo;


    //A POST route that creates a new customer
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }


    //A PUT route that updates an existing customer
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        repo.save(customer);
    }


    //A DELETE route that deletes an existing customer
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
    }


    //A GET route that returns a specific customer by id
    @GetMapping("/customers/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Customer getCustomerById(@PathVariable int id) {

        Optional<Customer> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }


    //A GET route that returns all customers for a specific state
    @GetMapping("/customers/state/{state}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getCustomersByState(@PathVariable String state) {

        return repo.findByState(state);
    }


}

