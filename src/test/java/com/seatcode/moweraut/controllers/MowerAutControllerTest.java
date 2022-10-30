package com.seatcode.moweraut.controllers;

import com.seatcode.moweraut.dto.Plateau;
import com.seatcode.moweraut.dto.Position;
import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerInput;
import com.seatcode.moweraut.dto.mower.MowerMoveRequest;
import com.seatcode.moweraut.dto.mower.MowerResponse;
import com.seatcode.moweraut.dto.orientation.CardinalDirection;
import com.seatcode.moweraut.usecases.MowerAutUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MowerAutControllerTest {

    private static final long FIRST_MOWER = 1L;

    @Mock
    private MowerAutUseCase mowerAutUseCase;

    @InjectMocks
    private MowerAutController mowerAutController;

    @Test
    void givenApiSpecWhenTryToCreateNewMowerThenMustGoAllOk() {
        final var inputMower = Mower.builder()
                .build();
        final var outputMower = Mower.builder()
                .id(FIRST_MOWER)
                .position(Position.builder()
                        .axisY(0)
                        .axisX(0)
                        .orientation(CardinalDirection.N)
                        .build())
                .build();

        when(mowerAutUseCase.createMower(inputMower)).thenReturn(outputMower);

        final var response = mowerAutController.createMower(inputMower);

        assertThat(response.getId()).isEqualTo(FIRST_MOWER);
        assertThat(response.getPosition().getAxisX()).isEqualTo(0);
        assertThat(response.getPosition().getAxisY()).isEqualTo(0);
        assertThat(response.getPosition().getOrientation().name()).isEqualTo("N");
    }

    @Test
    void givenApiSpecWhenTryToMoveMowerThenMustGoAllOk() {
        final var mowerMoveRequest = MowerMoveRequest.builder()
                .plateau(Plateau.builder()
                        .build())
                .mowerInputs(List.of(MowerInput.builder()
                        .build()))
                .build();
        final var mowerResponse = MowerResponse.builder()
                .positions(List.of(Position.builder()
                        .axisY(0)
                        .axisX(0)
                        .orientation(CardinalDirection.N)
                        .build()))
                .build();
        when(mowerAutUseCase.moveMower(mowerMoveRequest)).thenReturn(mowerResponse);

        final var response = mowerAutController.moveMower(mowerMoveRequest);

        assertThat(response.getPositions().get(0).getAxisX()).isEqualTo(0);
        assertThat(response.getPositions().get(0).getAxisY()).isEqualTo(0);
        assertThat(response.getPositions().get(0).getOrientation().name()).isEqualTo("N");
    }
}
