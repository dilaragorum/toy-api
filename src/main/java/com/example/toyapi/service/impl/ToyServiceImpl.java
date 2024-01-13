package com.example.toyapi.service.impl;

import com.example.toyapi.model.Toy;
import com.example.toyapi.repository.ToyRepository;
import com.example.toyapi.service.ToyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToyServiceImpl implements ToyService {
    private final ToyRepository toyRepository;

    @Override
    public Toy createToy(Toy toy) {
        return toyRepository.save(toy);
    }
}
