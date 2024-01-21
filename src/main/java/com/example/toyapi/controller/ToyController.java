package com.example.toyapi.controller;


import com.example.toyapi.model.*;
import com.example.toyapi.model.db.ToyDao;
import com.example.toyapi.model.request.CreateToyRequest;
import com.example.toyapi.model.response.ToyApiResponse;
import com.example.toyapi.service.ToyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.toyapi.model.mapper.CreateToyRequestMapper.CREATE_TOY_REQUEST_MAPPER;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/toys")
public class ToyController {
    private final ToyService toyService;

    @PostMapping
    public ResponseEntity<ToyApiResponse<Void>> createToy(@RequestBody CreateToyRequest createToyRequest) {
        log.info("[START] toyCreate request received. CargoId: {}", createToyRequest);

        Toy toy = CREATE_TOY_REQUEST_MAPPER.requestToToy(createToyRequest);

        toyService.createToy(CREATE_TOY_REQUEST_MAPPER.toyToToyDao(toy));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.LOCATION, String.format("/api/v1/toys/%s", toy.getId()));

        log.info("[END] toyCreate request is completed successfully. ToyId: {}", createToyRequest.getId());

        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<ToyApiResponse<Toy>> getToy(@PathVariable String id) {
        log.info("[START] getToy request received. CargoId: {}", id);

        ToyDao toyDao = toyService.getToy(id);

        ToyApiResponse<Toy> response = ToyApiResponse.<Toy>builder()
                .data(CREATE_TOY_REQUEST_MAPPER.toyDaoToToy(toyDao))
                .build();

        log.info("[END] toyCreate request is completed successfully. ToyId: {}, Response: {}", id, response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
