package com.seatcode.moweraut.controllers;

import com.seatcode.moweraut.dto.Plateau;
import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerRequest;
import com.seatcode.moweraut.dto.mower.MowerInput;
import com.seatcode.moweraut.services.MowerCommandExecutor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MowerAutControllerTest {

    private static final long FIRST_MOWER = 1L;

    public static final long SECOND_MOWER = 1L;

    @Mock
    private MowerCommandExecutor mowerCommandExecutor;

    @InjectMocks
    private MowerAutController mowerAutController;

    @Test
    void givenApiSpecWhenTryToGetAllMowersThenMustGoAllOk() {
        final var response = mowerAutController.getMowers();

        assertThat(response.size()).isEqualTo(2);
        assertThat(response.get(0).getId()).isEqualTo(FIRST_MOWER);
        assertThat(response.get(1).getId()).isEqualTo(SECOND_MOWER);
    }

    @Test
    void givenApiSpecWhenTryToGetMowerByIdThenMustGoAllOk() {
        final var response = mowerAutController.getMowerById(FIRST_MOWER);

        assertThat(response.getId()).isEqualTo(FIRST_MOWER);
        assertThat(response.getPosition().getAxisX()).isEqualTo(2);
        assertThat(response.getPosition().getAxisY()).isEqualTo(2);
        assertThat(response.getPosition().getOrientation()).isEqualTo("N");
    }

    @Test
    void givenApiSpecWhenTryToCreateNewMowerThenMustGoAllOk() {
        final var mower = Mower.builder()
                .id(FIRST_MOWER)
                .build();
        final var response = mowerAutController.createMower(mower);

        assertThat(response.getId()).isEqualTo(FIRST_MOWER);
        assertThat(response.getPosition().getAxisX()).isEqualTo(0);
        assertThat(response.getPosition().getAxisY()).isEqualTo(0);
        assertThat(response.getPosition().getOrientation()).isEqualTo("N");
    }

    @Test
    void givenApiSpecWhenTryToMoveMowerThenMustGoAllOk() {
        final var mowerCommand = MowerRequest.builder()
                .plateau(Plateau.builder()
                        .build())
                .firstMowerInput(MowerInput.builder()
                        .build())
                .SecondMowerInput(MowerInput.builder()
                        .build())
                .build();

        final var response = mowerAutController.moveMower(mowerCommand);

        assertThat(response.getId()).isEqualTo(FIRST_MOWER);
        assertThat(response.getPosition().getAxisX()).isEqualTo(0);
        assertThat(response.getPosition().getAxisY()).isEqualTo(3);
        assertThat(response.getPosition().getOrientation()).isEqualTo("N");
    }
}
