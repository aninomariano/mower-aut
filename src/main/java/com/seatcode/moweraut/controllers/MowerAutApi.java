package com.seatcode.moweraut.controllers;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MowerAutApi {

    @GetMapping
    List<Mower> getMowers();

    @GetMapping(value = "/{id}")
    Mower getMowerById(@PathVariable long id);

    @PostMapping
    Mower createMower(@RequestBody Mower mower);

    @PutMapping
    Mower moveMower(@RequestParam MowerRequest mowerInput);
}
