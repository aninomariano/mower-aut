package com.seatcode.moweraut.services;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.Position;

public interface MowerCommandExecutor {

    /**
     * Returns mower position
     *
     * @param mower asdasd
     * @param command  asdasd
     * @return the position
     */
    Position move(Mower mower, String command);
}
