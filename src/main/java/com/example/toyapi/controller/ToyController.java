package com.example.toyapi.controller;


import com.example.toyapi.model.CreateToyRequest;
import com.example.toyapi.model.Toy;
import com.example.toyapi.model.ToyApiResponse;
import com.example.toyapi.service.ToyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.toyapi.model.MapStructConverter.MAPPER;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/toys")
public class ToyController {
    private final ToyService toyService;
    @PostMapping
    public ToyApiResponse<Toy> createToy(@RequestBody CreateToyRequest createToyRequest) {
        log.info("[START] toyCreate request received. CargoId: {}", createToyRequest);


        ToyApiResponse<Toy> response = ToyApiResponse.<Toy>builder()
                .data(toyService.createToy(MAPPER.requestToToy(createToyRequest)))
                .build();

        log.info("[END] toyCreate request is completed successfully. ToyId: {}, Response: {}", createToyRequest.getToy().getId(), response);
        return response;
    }
}
