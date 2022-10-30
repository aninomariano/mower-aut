package com.seatcode.moweraut.strategy;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.orientation.CardinalDirection;

public class MoveForwardStrategy implements MowerStrategy {

    @Override
    public void execute(final Mower mower) {
        final var direction = mower.getPosition().getOrientation();
        direction.moveMower(mower);
    }
}
