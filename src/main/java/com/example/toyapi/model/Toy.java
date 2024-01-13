package com.example.toyapi.model;

import lombok.Data;
import org.springframework.data.couchbase.core.mapping.Document;

@Data
@Document
public class Toy {
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
}
