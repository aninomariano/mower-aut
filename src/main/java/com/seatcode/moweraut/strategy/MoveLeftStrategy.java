package com.seatcode.moweraut.strategy;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.orientation.CardinalDirection;

import java.util.Map;

import static com.seatcode.moweraut.dto.orientation.CardinalDirection.*;

public class MoveLeftStrategy implements MowerStrategy {

    private static final Map<CardinalDirection, CardinalDirection> LEFT_ORIENTATION =
            Map.of(N, W, W, S, S, E, E, N);

    @Override
    public void execute(final Mower mower) {
        mower.getPosition().setOrientation(LEFT_ORIENTATION.get(mower.getPosition().getOrientation()));
    }
}
