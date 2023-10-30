package com.practicemongodb.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<String, String> {

}
