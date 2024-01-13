package com.example.toyapi.service;

import com.example.toyapi.model.Toy;
import org.springframework.stereotype.Component;

@Component
public interface ToyService {
    Toy createToy(Toy toy);
}
