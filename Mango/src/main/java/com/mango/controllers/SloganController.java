package com.mango.controllers;


import com.mango.dtos.SloganDto;
import com.mango.services.SloganService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SloganController {

    private final SloganService sloganService;

    @GetMapping("/slogans")
    List<SloganDto> findlAll(){
        return sloganService.finalAll();
    }

    @PostMapping("/campaings/slogan")
    SloganDto create(@Valid @RequestBody SloganDto sloganDto){
        return sloganService.create(sloganDto);
    }

    @PutMapping("/slogans")
    SloganDto update(@Valid @RequestBody SloganDto sloganDto){
        return sloganService.update(sloganDto);
    }

    @DeleteMapping("/slogans/{id}")
    void deleteById(@PathVariable Long id){
        sloganService.deleteById(id);
    }
}
