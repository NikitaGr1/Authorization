package com.example.bars.repository;

import com.example.bars.document.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends MongoRepository<Session, String> {
    public Session findByToken(String token);
}
