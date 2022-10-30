package com.seatcode.moweraut.strategy;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.orientation.CardinalDirection;

public interface MowerStrategy {

    /**
     * Command executor.
     *
     * @return
     */
    void execute(Mower mower);
}
