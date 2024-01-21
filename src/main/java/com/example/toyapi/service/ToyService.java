package com.example.toyapi.service;

import com.example.toyapi.model.Toy;
import com.example.toyapi.model.db.ToyDao;
import org.springframework.stereotype.Component;

@Component
public interface ToyService {
    void createToy(ToyDao toy);
    ToyDao getToy(String id);
}
