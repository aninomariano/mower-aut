package com.seatcode.moweraut.exceptions;

import java.io.Serial;

public class MowerNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5762673991576250685L;

    public MowerNotFoundException(final String message) {
        super(message);
    }
}
