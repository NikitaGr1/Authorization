package com.example.bars.controller;

import com.example.bars.document.Customer;
import com.example.bars.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping(value = "/")
public class CustomerController
{
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String addCustomer(Customer customer, Model model) {
        Customer customerFromDB = customerRepository.findByEmail(customer.getEmail());

        if (customerFromDB != null) {
            model.addAttribute("message", "Customer with such an email already exists!");
            return "register";
        }
        customerRepository.save(customer);
        return "redirect:/auth";
    }

    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }

    @PostMapping("/auth")
    public String login(Customer customer, Model model) {
        Customer customerFromDB = customerRepository.findByEmail(customer.getEmail());

        if (customerFromDB != null) {
            if (!customerFromDB.getPassword().equals(customer.getPassword())) {
                model.addAttribute("message", "Incorrect password!");
                return "auth";
            }
            return "redirect:/main";
        }
        model.addAttribute("message", "User with the same email does not exist!");
        return "auth";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/auth";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    /*@GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/one")
    public Customer getCustomer(@RequestParam(name = "email") String email) {
        return customerRepository.findByEmail(email);
    }

    @PostMapping("/create")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }*/
}
