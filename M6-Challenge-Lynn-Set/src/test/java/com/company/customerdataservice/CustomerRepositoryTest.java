package com.company.customerdataservice;

import com.company.customerdataservice.models.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringBootConfiguration
public class CustomerRepositoryTest {
    //@MockBean
    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    @Test
    public void findCustomerByState() {
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Doe");
        customer.setPhone("111-222-345");
        customer.setCompany("NFLX");
        customer.setAddress1("Address1");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostalCode("12345");
        customer.setCountry("USA");

        customerRepo.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Joe");
        customer2.setLastName("Doe");
        customer2.setPhone("111-222-345");
        customer2.setCompany("NFLX");
        customer2.setAddress1("Address1");
        customer2.setCity("Los Angeles");
        customer2.setState("California");
        customer2.setPostalCode("12345");
        customer2.setCountry("USA");

        customerRepo.save(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Joe");
        customer3.setLastName("Doe");
        customer3.setPhone("111-222-345");
        customer3.setCompany("NFLX");
        customer3.setAddress1("Address1");
        customer3.setCity("Los Angeles");
        customer3.setState("California");
        customer3.setPostalCode("12345");
        customer3.setCountry("USA");

        customerRepo.save(customer3);

        List<Customer> customerList = customerRepo.findByState("California");

        assertEquals(2, customerList.size());
    }
}
