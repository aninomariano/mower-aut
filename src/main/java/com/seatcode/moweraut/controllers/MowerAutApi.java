package com.seatcode.moweraut.controllers;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerMoveRequest;
import com.seatcode.moweraut.dto.mower.MowerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface MowerAutApi {

    /**
     * Creates mower with desired values.
     *
     * @param mower the body with the mower
     * @return the mower.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Mower createMower(@RequestBody Mower mower);

    /**
     * Moves the mower in plateau.
     *
     * @param mowerMoveRequest the mower move request
     * @return response with position info.
     */
    @PutMapping
    MowerResponse moveMower(@RequestBody MowerMoveRequest mowerMoveRequest);
}
