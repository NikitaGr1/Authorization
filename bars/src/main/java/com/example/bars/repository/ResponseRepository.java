package com.example.bars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rot.tot.ru.rotrequestresponse._1_0.ROTResponseType;

@Repository
public interface ResponseRepository extends MongoRepository<ROTResponseType, String>
{

}
