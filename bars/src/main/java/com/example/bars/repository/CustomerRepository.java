package com.example.bars.repository;

import com.example.bars.document.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>
{
    public Customer findByUsername(String username);
}
