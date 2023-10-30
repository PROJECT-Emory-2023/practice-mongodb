package com.practicemongodb.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.practicemongodb.demo.models.Member;

/**
 * Automatically detected and included by Spring Boot
 */
public interface MemberRepository extends MongoRepository<Member, Integer> {

    // CRUD is not done here, only thing that goes here is queries
    // CRUD is done by @Autowire with repository in some Java file (Application,
    // Controller, Service, etc)

    /**
     * run {name:'?0'} query on database
     */
    @Query("{name:'?0'}")
    Member findMemberByName(String name);

    /**
     * run {team:'?0'} query on database, projecting (returning) only the id and
     * name field
     */
    @Query(value = "{team:'?0'}", fields = "{'id':1, 'name':1}")
    List<Member> findAll(String team);

    /**
     * return count of documents
     */
    public long count();

}
