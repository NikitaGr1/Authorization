package com.example.bars.controller;

import com.example.bars.document.Customer;
import com.example.bars.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/crud")
public class CRUDController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    //Create
    @PostMapping("/users")
    public List<ResponseEntity<Customer>> createCustomer(@RequestBody List<Customer> customers) {
        List<ResponseEntity<Customer>> responseEntityList = new ArrayList<>();
        for (Customer customer : customers) {
            try {
                Customer _customer = new Customer();
                _customer.setUsername(customer.getUsername());
                _customer.setPassword(passwordEncoder.encode(customer.getPassword()));
                _customer.setCreationDate(new Date());
                customerRepository.save(_customer);
                responseEntityList.add(new ResponseEntity<>(_customer, HttpStatus.CREATED));
            } catch (Exception e) {
                responseEntityList.add(new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
            }
        }
        return responseEntityList;
    }

    //Read
    @GetMapping("/users")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = new ArrayList<>();
            customerRepository.findAll().forEach(customers::add);
            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") String id) {
        Optional<Customer> customerData = Optional.ofNullable(customerRepository.findByGuid(id));
        if (customerData.isPresent()) {
            return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Update
    @PutMapping("/users/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
        Optional<Customer> customerData = Optional.ofNullable(customerRepository.findByGuid(id));
        if (customerData.isPresent()) {
            Customer _customer = customerData.get();
            _customer.setUsername(customer.getUsername());
            _customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            _customer.setAuid(customer.getAuid());
            return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Delete
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") String id) {
        try {
            customerRepository.deleteByGuid(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllCustomers() {
        try {
            customerRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
