package com.example.toyapi.model;

import com.example.toyapi.util.converter.JsonConverter;
import lombok.Data;

@Data
public class CreateToyRequest {
    Toy toy;

    @Override
    public String toString() {
        return JsonConverter.objectToJson(this);
    }
}
