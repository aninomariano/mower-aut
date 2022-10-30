package com.seatcode.moweraut.exceptions;

import java.io.Serial;

public class InvalidMowerCoordinateException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5762673991576250685L;

    public InvalidMowerCoordinateException(final Character message) {
        super(message.toString());
    }
}
