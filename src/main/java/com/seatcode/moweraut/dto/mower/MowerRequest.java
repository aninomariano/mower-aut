package com.seatcode.moweraut.dto.mower;

import com.seatcode.moweraut.dto.Plateau;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Builder
@EqualsAndHashCode
@Getter
public class MowerRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 3039893059429951918L;

    private final Plateau plateau;
    private final MowerInput firstMowerInput;
    private final MowerInput SecondMowerInput;

}
