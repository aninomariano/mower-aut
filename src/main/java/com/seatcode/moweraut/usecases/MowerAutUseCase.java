package com.seatcode.moweraut.usecases;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerRequest;
import com.seatcode.moweraut.dto.mower.MowerResponse;
import com.seatcode.moweraut.services.MowerCommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MowerAutUseCase {

    @Autowired
    private MowerCommandExecutor mowerCommandExecutor;

    public List<Mower> getAllMowers() {
        return List.of(Mower.builder().build());
    }

    public Mower getMowerById(final long id) {
        return Mower.builder().build();
    }

    public Mower createMower(final Mower mower) {
        return mower;
    }

    public MowerResponse moveMower(final MowerRequest mowerRequest) {
        return MowerResponse.builder().build();
    }

}
