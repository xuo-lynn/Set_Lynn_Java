package com.company.customerdataservice.controller;

import com.company.customerdataservice.models.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;

    @PostMapping(value = "/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(Customer customer) {
        return repo.save(customer);
    }

    @DeleteMapping(value = "/customers/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
    }

    @PutMapping(value = "/customers/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        repo.save(customer);
    }

    @GetMapping(value = "/customers/{id}")
    public Customer getById(@PathVariable int id) {
        if (repo.findById(id).isPresent()) {
            return repo.findById(id).get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/customers/state/{state}")
    public List<Customer> getByState(@PathVariable String state) {
        return repo.findByState(state);
    }
}
