package com.seatcode.moweraut.dto.mower;

import com.seatcode.moweraut.dto.Position;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Builder
@EqualsAndHashCode
@Getter
public class MowerResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -4346048924839537007L;

    private final List<Position> positions;

}
