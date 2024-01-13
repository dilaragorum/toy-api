package com.example.toyapi.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructConverter {
    MapStructConverter MAPPER = Mappers.getMapper(MapStructConverter.class);

   Toy requestToToy(CreateToyRequest request);
}
