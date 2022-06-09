package com.example.bars.service;

import com.example.bars.document.Customer;
import com.example.bars.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Component
//@Service
public class SecUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*Here add user data layer fetching from the MongoDB.
          I have used userRepository*/
        Customer customer = customerRepository.findByUsername(username);
        if(customer == null){
            throw new UsernameNotFoundException(username);
        }else{
            UserDetails details = new SecUserDetails(customer);
            return details;

        }
    }
}