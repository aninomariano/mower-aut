package com.seatcode.moweraut.repository;

import com.seatcode.moweraut.dto.mower.Mower;

import java.util.Optional;

public interface MowerRepository {

    /**
     * Saves new mower.
     *
     * @param mower the mower.
     * @return the saved mower
     */
    Mower saveMower(Mower mower);

    /**
     * Gets mower by id
     *
     * @param id the mower id
     * @return the optional
     */
    Optional<Mower> getMowerById(Long id);

    /**
     * Updates mower
     *
     * @param mower the mower
     * @return the mower
     */
    Mower updateMower(final Mower mower);

}
