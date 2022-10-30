package com.seatcode.moweraut.controllers;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerMoveRequest;
import com.seatcode.moweraut.dto.mower.MowerResponse;
import com.seatcode.moweraut.usecases.MowerAutUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/moweraut")
public class MowerAutController implements MowerAutApi {

    @Autowired
    private MowerAutUseCase mowerAutUseCase;

    @Override
    public Mower createMower(final Mower mower) {
        return mowerAutUseCase.createMower(mower);
    }

    @Override
    public MowerResponse moveMower(final MowerMoveRequest mowerMoveRequest) {
        return mowerAutUseCase.moveMower(mowerMoveRequest);
    }
}
