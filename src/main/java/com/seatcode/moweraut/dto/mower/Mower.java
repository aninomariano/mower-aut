package com.seatcode.moweraut.dto.mower;

import com.seatcode.moweraut.dto.Position;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Getter
@EqualsAndHashCode
public class Mower implements Serializable {

    @Serial
    private static final long serialVersionUID = -6133567769393069903L;

    private final long id;
    private final Position position;
}
