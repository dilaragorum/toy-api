package com.example.toyapi.model.mapper;

import com.example.toyapi.model.Toy;
import com.example.toyapi.model.db.ToyDao;
import com.example.toyapi.model.request.CreateToyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateToyRequestMapper {
    CreateToyRequestMapper CREATE_TOY_REQUEST_MAPPER = Mappers.getMapper(CreateToyRequestMapper.class);

    Toy requestToToy(CreateToyRequest cyr);

    ToyDao toyToToyDao(Toy toy);

    Toy toyDaoToToy(ToyDao toyDao);
}
