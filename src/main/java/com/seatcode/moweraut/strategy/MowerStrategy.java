package com.seatcode.moweraut.strategy;

import com.seatcode.moweraut.dto.mower.Mower;

public interface MowerStrategy {

    /**
     * Command executor.
     */
    void execute(Mower mower);
}
