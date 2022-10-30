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
public class MowerInput implements Serializable {

    @Serial
    private static final long serialVersionUID = -6711808126325228028L;

    private final long mowerId;
    private final Position mowerPosition;
    private final String mowerCommand;

}
