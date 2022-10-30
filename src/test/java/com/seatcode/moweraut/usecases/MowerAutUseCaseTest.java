package com.seatcode.moweraut.usecases;

import com.seatcode.moweraut.dto.Plateau;
import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerRequest;
import com.seatcode.moweraut.dto.mower.MowerInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerAutUseCaseTest {

    private static final long FIRST_MOWER = 1L;

    public static final long SECOND_MOWER = 1L;

    private MowerAutUseCase mowerAutUseCase;

    @Test
    void givenControllerWhenTryToGetAllMowersThenMustGoAllOk() {
        final var response = mowerAutUseCase.getAllMowers();

        assertThat(response.size()).isEqualTo(2);
        assertThat(response.get(0).getId()).isEqualTo(FIRST_MOWER);
        assertThat(response.get(1).getId()).isEqualTo(SECOND_MOWER);
    }

    @Test
    void givenMowerIdWhenTryToGetMowerThenMustGoAllOk() {
        final var response = mowerAutUseCase.getMowerById(FIRST_MOWER);

        assertThat(response.getId()).isEqualTo(FIRST_MOWER);
        assertThat(response.getPosition().getAxisX()).isEqualTo(2);
        assertThat(response.getPosition().getAxisY()).isEqualTo(2);
        assertThat(response.getPosition().getOrientation()).isEqualTo("N");
    }

    @Test
    void givenBuiltMowerWhenTryToCreateNewMowerThenMustGoAllOk() {
        final var mower = Mower.builder()
                .id(FIRST_MOWER)
                .build();
        final var response = mowerAutUseCase.createMower(mower);

        assertThat(response.getId()).isEqualTo(FIRST_MOWER);
        assertThat(response.getPosition().getAxisX()).isEqualTo(0);
        assertThat(response.getPosition().getAxisY()).isEqualTo(0);
        assertThat(response.getPosition().getOrientation()).isEqualTo("N");
    }

    @Test
    void givenMowerCommandWhenTryToMoveMowerThenMustGoAllOk() {
        final var mowerCommand = MowerRequest.builder()
                .plateau(Plateau.builder()
                        .build())
                .firstMowerInput(MowerInput.builder()
                        .build())
                .SecondMowerInput(MowerInput.builder()
                        .build())
                .build();

        final var response = mowerAutUseCase.moveMower(mowerCommand);

        assertThat(response.getFirstMower().getAxisX()).isEqualTo(1);
        assertThat(response.getFirstMower().getAxisY()).isEqualTo(3);
        assertThat(response.getFirstMower().getOrientation()).isEqualTo("N");
        assertThat(response.getSecondMower().getAxisX()).isEqualTo(5);
        assertThat(response.getSecondMower().getAxisY()).isEqualTo(1);
        assertThat(response.getSecondMower().getOrientation()).isEqualTo("E");

    }
}
