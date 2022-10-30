package com.seatcode.moweraut.controllers;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerMoveRequest;
import com.seatcode.moweraut.dto.mower.MowerResponse;
import org.springframework.web.bind.annotation.*;

public interface MowerAutApi {

    @PostMapping
    Mower createMower(@RequestBody Mower mower);

    @PutMapping
    MowerResponse moveMower(@RequestBody MowerMoveRequest mowerInput);
}
