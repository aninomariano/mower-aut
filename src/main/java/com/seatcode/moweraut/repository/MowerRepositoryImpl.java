package com.seatcode.moweraut.repository;

import com.seatcode.moweraut.dto.mower.Mower;

public class MowerRepositoryImpl implements MowerRepository {

    @Override
    public Mower saveMower(Mower mower) {
        return Mower.builder().build();
    }
}
