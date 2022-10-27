package com.mango.services;

import com.mango.dtos.SloganDto;

import java.util.List;

public interface SloganService {
    List<SloganDto> finalAll();

    SloganDto findById(Long id);

    SloganDto create(SloganDto SloganDto);

    SloganDto update(SloganDto SloganDto);

    void deleteById(Long id);
}
