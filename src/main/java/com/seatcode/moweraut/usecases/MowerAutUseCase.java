package com.seatcode.moweraut.usecases;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerMoveRequest;
import com.seatcode.moweraut.dto.mower.MowerResponse;
import com.seatcode.moweraut.services.mower.MowerCommandExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MowerAutUseCase {

    @Autowired
    private MowerCommandExecutorService mowerCommandExecutorService;

    public Mower createMower(final Mower mower) {
        return mowerCommandExecutorService.create(mower);
    }

    public MowerResponse moveMower(final MowerMoveRequest mowerMoveRequest) {
        return mowerCommandExecutorService.move(mowerMoveRequest);
    }

}
