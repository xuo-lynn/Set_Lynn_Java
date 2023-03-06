package com.company.customerdataservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.customerdataservice.controller.CustomerController;
import com.company.customerdataservice.models.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;
    private List<Customer> customerList;
    private final ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup(){

    }


    @Test
    public void testAddCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@example.com");
        customer.setAddress1("123 Main St");
        customer.setCity("Anytown");
        customer.setState("CA");
        customer.setPostalCode("12345");
        customer.setCountry("USA");

        ObjectMapper mapper = new ObjectMapper();
        String customerJson = mapper.writeValueAsString(customer);

    }

    @Test
    public void testDeleteCustomer() throws Exception {
        mockMvc.perform(delete("/customers/delete/1"))
                .andExpect(status().isOk());

        verify(customerRepository, times(1)).deleteById(1);
    }

    private <T> CrudRepository verify(CustomerRepository customerRepository, VerificationMode times) {
        return null;
    }

    @Test
    public void testUpdateCustomer() throws Exception {
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

        ObjectMapper objectMapper = new ObjectMapper();
        String customerJson = objectMapper.writeValueAsString(customer);
        byte[] customerJsonBytes = customerJson.getBytes();

    }

    private Object asJsonString(Customer customer) {
        return null;
    }

    @Test
    public void testGetById() throws Exception {
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

        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        ObjectMapper objectMapper = new ObjectMapper();
        String customerJson = objectMapper.writeValueAsString(customer);
        byte[] customerJsonBytes = customerJson.getBytes();

        // Create the MockMvc object
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new CustomerController()).build();

        // Perform the request
        mockMvc.perform(MockMvcRequestBuilders.put("/customers/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJsonBytes))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetByState() throws Exception {
        Customer customer1 = new Customer();
        customer1.setFirstName("Joe");
        customer1.setLastName("Doe");
        customer1.setPhone("111-222-345");
        customer1.setCompany("NFLX");
        customer1.setAddress1("Address1");
        customer1.setCity("Los Angeles");
        customer1.setState("California");
        customer1.setPostalCode("12345");
        customer1.setCountry("USA");

    }}