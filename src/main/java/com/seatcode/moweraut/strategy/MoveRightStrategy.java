package com.seatcode.moweraut.strategy;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.orientation.CardinalDirection;

import java.util.Map;

import static com.seatcode.moweraut.dto.orientation.CardinalDirection.*;

public class MoveRightStrategy implements MowerStrategy {

    private static final Map<CardinalDirection, CardinalDirection> RIGHT_ORIENTATION =
            Map.of(N, E, E, S, S, W, W, N);

    @Override
    public void execute(final Mower mower) {
        mower.getPosition().setOrientation(RIGHT_ORIENTATION.get(mower.getPosition().getOrientation()));
    }

}
