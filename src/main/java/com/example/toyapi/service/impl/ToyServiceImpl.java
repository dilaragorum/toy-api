package com.example.toyapi.service.impl;

import com.example.toyapi.exception.ToyNotFoundException;
import com.example.toyapi.model.Toy;
import com.example.toyapi.model.db.ToyDao;
import com.example.toyapi.repository.ToyRepository;
import com.example.toyapi.service.ToyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class ToyServiceImpl implements ToyService {
    private final ToyRepository toyRepository;

    @Override
    public void createToy(ToyDao toy) {
        toyRepository.save(toy);
    }

    @Override
    public ToyDao getToy(String id) {
        log.info("Getting toy from the repository.");
        Optional<ToyDao> toy = toyRepository.findById(id);
        if (toy.isEmpty()) {
            log.info("Toy cannot be found: {} ", id);
            throw new ToyNotFoundException("toy cannot be found.");
        }

        log.info("Get toy returned successfully. (Optional) Result: {} ", id);
        return toy.get();
    }
}
