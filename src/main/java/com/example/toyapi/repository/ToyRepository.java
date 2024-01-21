package com.example.toyapi.repository;

import com.example.toyapi.model.Toy;
import com.example.toyapi.model.db.ToyDao;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends CouchbaseRepository<ToyDao, String> {

}
