package com.seatcode.moweraut.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Getter
@EqualsAndHashCode
public class Plateau implements Serializable {

    @Serial
    private static final long serialVersionUID = 7832623908778666167L;

    private final int axisY;
    private final int axisX;

}
