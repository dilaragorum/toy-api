package com.example.toyapi.repository;

import com.example.toyapi.model.Toy;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends CouchbaseRepository<Toy, String> {

}
