package com.example.bars.controller;

import com.example.bars.document.Customer;
import com.example.bars.document.Session;
import com.example.bars.repository.CustomerRepository;
import com.example.bars.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping(value = "/")
public class CustomerController
{
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;
    private final SessionRepository sessionRepository;

    public CustomerController(CustomerRepository customerRepository, SessionRepository sessionRepository) {
        this.customerRepository = customerRepository;
        this.sessionRepository = sessionRepository;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String addCustomer(Customer customer, Model model) {
        Customer customerFromDB = customerRepository.findByUsername(customer.getUsername());

        if (customerFromDB != null) {
            model.addAttribute("message", "Customer with such an email already exists!");
            return "register";
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
        return "redirect:/auth";
    }

    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }

    /*@GetMapping(value = "/auth", params = "logout")
    public String logout(@RequestParam(name = "logout") String logout) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Customer authCustomer = customerRepository.findByUsername(auth.getName());
        String customerToken = authCustomer.getSessionToken();
        Session authSession = sessionRepository.findByToken(customerToken);
        sessionRepository.delete(authSession);
        authCustomer.setSessionToken(null);
        return "auth";
    }*/

    @GetMapping("/home")
    public String home() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Customer authCustomer = customerRepository.findByUsername(auth.getName());
        String customerToken = authCustomer.getSessionToken();
        if (customerToken == null) {
            Session newSession = new Session(authCustomer);
            sessionRepository.save(newSession);
            authCustomer.setSessionToken(newSession.getToken());
            customerRepository.save(authCustomer);
        } else {
            Session authSession = sessionRepository.findByToken(customerToken);
            Date expired = authSession.getDateExpire();
            if (expired.compareTo(new Date()) < 0) {
                sessionRepository.delete(authSession);
                Session newSession = new Session(authCustomer);
                sessionRepository.save(newSession);
                authCustomer.setSessionToken(newSession.getToken());
                customerRepository.save(authCustomer);
            }
        }
        System.out.println(authCustomer.getUsername());
        return "home";
    }

    @PostMapping("/auth")
    public ResponseEntity<String> login(Customer customer) {
        return ResponseEntity.ok("success!");
    }

    /*@PostMapping("/auth")
    public String login(Customer customer, Model model) {
        Customer customerFromDB = customerRepository.findByUsername(customer.getUsername());

        if (customerFromDB != null) {
            if (!customerFromDB.getPassword().equals(customer.getPassword())) {
                model.addAttribute("message", "Incorrect password!");
                return "auth";
            }
            return "redirect:/main";
        }
        model.addAttribute("message", "User with the same email does not exist!");
        return "auth";
    }*/

    /*@GetMapping("/logout")
    public String logout() {
        return "redirect:/auth";
    }*/

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    /*@GetMapping("/session")
    public String session(Principal principal) {
        return principal.getName();
        return "redirect:/home";
    }*/

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
