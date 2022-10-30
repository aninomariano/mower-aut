package com.seatcode.moweraut.dto;

import com.seatcode.moweraut.dto.orientation.CardinalDirection;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Setter
@Getter
@EqualsAndHashCode
public class Position implements Serializable {

    @Serial
    private static final long serialVersionUID = 1024878108130252300L;

    private int axisX;
    private int axisY;
    private CardinalDirection orientation;
}
