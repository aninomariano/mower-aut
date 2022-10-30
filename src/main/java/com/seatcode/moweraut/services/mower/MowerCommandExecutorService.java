package com.seatcode.moweraut.services.mower;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerMoveRequest;
import com.seatcode.moweraut.dto.mower.MowerResponse;

public interface MowerCommandExecutorService {

    /**
     * Moves and return mower position.
     *
     * @param mowerMoveRequest the mower move request
     * @return the position
     */
    MowerResponse move(MowerMoveRequest mowerMoveRequest);

    /**
     * Creates a mower.
     *
     * @param mower the mower
     * @return the position
     */
    Mower create(Mower mower);

}
