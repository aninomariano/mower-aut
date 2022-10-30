package com.seatcode.moweraut.repository;

import com.seatcode.moweraut.dto.mower.Mower;

import java.util.Optional;

public interface MowerRepository {

    /**
     * Saves new mower.
     *
     * @param mower the mower.
     * @return
     */
    Mower saveMower(Mower mower);

    Optional<Mower> getMowerById(Long id);

    Mower updateMower(final Mower mower);

}
