package com.seatcode.moweraut.usecases;

import com.seatcode.moweraut.dto.Plateau;
import com.seatcode.moweraut.dto.Position;
import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerMoveRequest;
import com.seatcode.moweraut.dto.mower.MowerInput;
import com.seatcode.moweraut.dto.mower.MowerResponse;
import com.seatcode.moweraut.dto.orientation.CardinalDirection;
import com.seatcode.moweraut.services.mower.MowerCommandExecutorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MowerAutUseCaseTest {

    private static final long RANDOM_ID = 1L;

    @Mock
    private MowerCommandExecutorService mowerCommandExecutorService;

    @InjectMocks
    private MowerAutUseCase mowerAutUseCase;

    @Test
    void givenBuiltMowerWhenTryToCreateNewMowerThenMustGoAllOk() {
        final var mower = Mower.builder()
                .build();
        final var createdMower = Mower.builder()
                .id(RANDOM_ID)
                .build();
        when(mowerCommandExecutorService.create(mower)).thenReturn(createdMower);

        final var response = mowerAutUseCase.createMower(mower);

        assertThat(response.getId()).isEqualTo(RANDOM_ID);
    }

    @Test
    void givenMowerCommandWhenTryToMoveMowerThenMustGoAllOk() {
        final var mowerMoveRequest = MowerMoveRequest.builder()
                .plateau(Plateau.builder()
                        .build())
                .mowerInputs(List.of(MowerInput.builder()
                        .build()))
                .build();
        final var mowerResponse = MowerResponse.builder()
                .positions(List.of(Position.builder()
                                .axisX(0)
                                .axisY(0)
                                .orientation(CardinalDirection.N)
                                .build()))
                .build();
        when(mowerCommandExecutorService.move(mowerMoveRequest)).thenReturn(mowerResponse);

        final var response = mowerAutUseCase.moveMower(mowerMoveRequest);

        assertThat(response.getPositions().get(0).getAxisX()).isEqualTo(0);
        assertThat(response.getPositions().get(0).getAxisY()).isEqualTo(0);
        assertThat(response.getPositions().get(0).getOrientation().name()).isEqualTo("N");
    }
}
