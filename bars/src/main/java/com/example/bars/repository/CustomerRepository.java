package com.example.bars.repository;

import com.example.bars.document.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>
{
    public Customer findByUsername(String username);
    public Customer findByGuid(String guid);
    public Customer deleteByGuid(String guid);
}
