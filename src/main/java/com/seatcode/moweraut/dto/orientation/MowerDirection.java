package com.seatcode.moweraut.dto.orientation;

import com.seatcode.moweraut.strategy.MoveForwardStrategy;
import com.seatcode.moweraut.strategy.MoveLeftStrategy;
import com.seatcode.moweraut.strategy.MoveRightStrategy;
import com.seatcode.moweraut.strategy.MowerStrategy;
import com.seatcode.moweraut.exceptions.InvalidMowerCoordinateException;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum MowerDirection {
    L('L', new MoveLeftStrategy()),
    R('R', new MoveRightStrategy()),
    M('M', new MoveForwardStrategy());

    private final char value;

    private final MowerStrategy mowerStrategy;

    MowerDirection(char value, MowerStrategy mowerStrategy) {
        this.value = value;
        this.mowerStrategy = mowerStrategy;
    }

    public static MowerDirection getByCommand(final char character) {
        return Stream.of(MowerDirection.values()).filter(mowerDirection -> mowerDirection.value == character)
                .findAny().orElseThrow(() -> new InvalidMowerCoordinateException(character));
    }
}
