package com.seatcode.moweraut.controllers;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/moweraut")
public class MowerAutController implements MowerAutApi {

    @Override
    public List<Mower> getMowers() {
        return null;
    }

    @Override
    public Mower getMowerById(final long id) {
        return null;
    }

    @Override
    public Mower createMower(final Mower mower) {
        return null;
    }

    @Override
    public Mower moveMower(final MowerRequest mowerRequest) {
        return null;
    }
}
