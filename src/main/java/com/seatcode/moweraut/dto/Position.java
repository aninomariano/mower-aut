package com.seatcode.moweraut.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Getter
@EqualsAndHashCode
public class Position implements Serializable {

    @Serial
    private static final long serialVersionUID = 1024878108130252300L;

    private final int axisX;
    private final int axisY;
    private final String orientation;
}
