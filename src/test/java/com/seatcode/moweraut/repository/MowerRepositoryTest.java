package com.seatcode.moweraut.repository;

import com.seatcode.moweraut.dto.mower.Mower;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerRepositoryTest {

    private MowerRepositoryImpl mowerRepository;

    @Test
    void givenMowerWhenTryToSaveItThenMustGoAllOk() {
        final var mower = Mower.builder().build();

        final var response = mowerRepository.saveMower(mower);

        assertThat(response.getId()).isEqualTo(1L);
    }

    @Test
    void givenMowerWhenTryToSaveItAndAlreadyExistsThenMustGoAllOk() {
        final var mower = Mower.builder().build();

        final var response = mowerRepository.saveMower(mower);

        assertThat(response.getId()).isEqualTo(1L);
    }
}
