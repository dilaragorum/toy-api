package com.example.toyapi.model.db;

import lombok.Data;
import org.springframework.data.couchbase.core.mapping.Document;

import java.time.Instant;


@Data
@Document
public class ToyDao {
    String id;
    String country;
    String address;
    String childName;
    String category;
    float weight;
    String sizeType;
    String message;
    int durationDay;
    String warehouse;
    long indexedAt;

    public ToyDao() {
        indexedAt = Instant.now().getEpochSecond();
    }
}
