package com.example.toyapi.model.request;

import com.example.toyapi.util.converter.JsonConverter;
import lombok.Data;

@Data
public class CreateToyRequest {
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

    @Override
    public String toString() {
        return JsonConverter.objectToJson(this);
    }
}
