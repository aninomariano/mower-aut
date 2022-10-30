package com.seatcode.moweraut.services;

import com.seatcode.moweraut.dto.Position;
import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerInput;
import com.seatcode.moweraut.dto.mower.MowerMoveRequest;
import com.seatcode.moweraut.dto.orientation.CardinalDirection;
import com.seatcode.moweraut.exceptions.MowerNotFoundException;
import com.seatcode.moweraut.repository.MowerRepository;
import com.seatcode.moweraut.services.mower.MowerCommandExecutorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MowerMoveRequestExecutorTest {

    public static final long MOWER_ID = 1L;
    @Mock
    private MowerRepository mowerRepository;

    @InjectMocks
    private MowerCommandExecutorServiceImpl mowerCommandExecutor;

    @Test
    void givenMowerCoordinatesWhenTryToMoveInNorthDirectionThenMustReturnCurrent() {
        final var unprocessedMowerPosition = Position.builder()
                .axisX(0)
                .axisY(0)
                .orientation(CardinalDirection.N)
                .build();
        final var processedMowerPosition = Position.builder()
                .axisX(0)
                .axisY(2)
                .orientation(CardinalDirection.E)
                .build();
        final var unprocessedMower = Mower.builder()
                .id(MOWER_ID)
                .position(unprocessedMowerPosition)
                .build();
        final var processedMower = Mower.builder()
                .id(MOWER_ID)
                .position(processedMowerPosition)
                .build();

        final var mowerMoveRequest = MowerMoveRequest.builder()
                .mowerInputs(List.of(MowerInput.builder()
                                .mowerId(MOWER_ID)
                        .mowerPosition(Position.builder()
                                .axisX(0)
                                .axisY(0)
                                .orientation(CardinalDirection.N)
                                .build())
                        .mowerCommand("MMR")
                        .build()))
                .build();

        when(mowerRepository.getMowerById(MOWER_ID))
                .thenReturn(Optional.of(unprocessedMower));
        when(mowerRepository.updateMower(unprocessedMower))
                .thenReturn(processedMower);

        final var result = mowerCommandExecutor.move(mowerMoveRequest)
                .getPositions().get(0);

        assertThat(result.getAxisX()).isEqualTo(0);
        assertThat(result.getAxisY()).isEqualTo(2);
        assertThat(result.getOrientation()).isEqualTo(CardinalDirection.E);
    }

    @Test
    void givenMowerCoordinatesWhenTryToMoveInEastDirectionThenMustReturnCurrent() {
        final var unprocessedMowerPosition = Position.builder()
                .axisX(0)
                .axisY(0)
                .orientation(CardinalDirection.E)
                .build();
        final var processedMowerPosition = Position.builder()
                .axisX(2)
                .axisY(0)
                .orientation(CardinalDirection.N)
                .build();
        final var unprocessedMower = Mower.builder()
                .id(MOWER_ID)
                .position(unprocessedMowerPosition)
                .build();
        final var processedMower = Mower.builder()
                .id(MOWER_ID)
                .position(processedMowerPosition)
                .build();

        final var mowerMoveRequest = MowerMoveRequest.builder()
                .mowerInputs(List.of(MowerInput.builder()
                                .mowerId(MOWER_ID)
                        .mowerPosition(Position.builder()
                                .axisX(0)
                                .axisY(0)
                                .orientation(CardinalDirection.E)
                                .build())
                        .mowerCommand("MML")
                        .build()))
                .build();

        when(mowerRepository.getMowerById(MOWER_ID)).thenReturn(Optional.of(unprocessedMower));
        when(mowerRepository.updateMower(unprocessedMower))
                .thenReturn(processedMower);

        final var result = mowerCommandExecutor.move(mowerMoveRequest)
                .getPositions().get(0);

        assertThat(result.getAxisX()).isEqualTo(2);
        assertThat(result.getAxisY()).isEqualTo(0);
        assertThat(result.getOrientation()).isEqualTo(CardinalDirection.N);
    }

    @Test
    void givenMowerCoordinatesWhenTryToMoveInWestDirectionThenMustReturnCurrent() {
        final var unprocessedMowerPosition = Position.builder()
                .axisX(3)
                .axisY(0)
                .orientation(CardinalDirection.W)
                .build();
        final var processedMowerPosition = Position.builder()
                .axisX(1)
                .axisY(0)
                .orientation(CardinalDirection.N)
                .build();
        final var unprocessedMower = Mower.builder()
                .id(MOWER_ID)
                .position(unprocessedMowerPosition)
                .build();
        final var processedMower = Mower.builder()
                .id(MOWER_ID)
                .position(processedMowerPosition)
                .build();

        when(mowerRepository.getMowerById(MOWER_ID)).thenReturn(Optional.of(unprocessedMower));
        when(mowerRepository.updateMower(unprocessedMower))
                .thenReturn(processedMower);

        final var mowerMoveRequest = MowerMoveRequest.builder()
                .mowerInputs(List.of(MowerInput.builder()
                                .mowerId(MOWER_ID)
                        .mowerPosition(Position.builder()
                                .axisX(3)
                                .axisY(0)
                                .orientation(CardinalDirection.W)
                                .build())
                        .mowerCommand("MMR")
                        .build()))
                .build();

        final var result = mowerCommandExecutor.move(mowerMoveRequest)
                .getPositions().get(0);

        assertThat(result.getAxisX()).isEqualTo(1);
        assertThat(result.getAxisY()).isEqualTo(0);
        assertThat(result.getOrientation()).isEqualTo(CardinalDirection.N);
    }

    @Test
    void givenMowerCoordinatesWhenTryToMoveInSouthDirectionThenMustReturnCurrent() {
        final var unprocessedMowerPosition = Position.builder()
                .axisX(3)
                .axisY(3)
                .orientation(CardinalDirection.S)
                .build();
        final var processedMowerPosition = Position.builder()
                .axisX(3)
                .axisY(1)
                .orientation(CardinalDirection.W)
                .build();
        final var unprocessedMower = Mower.builder()
                .id(MOWER_ID)
                .position(unprocessedMowerPosition)
                .build();
        final var processedMower = Mower.builder()
                .id(MOWER_ID)
                .position(processedMowerPosition)
                .build();

        when(mowerRepository.getMowerById(MOWER_ID)).thenReturn(Optional.of(unprocessedMower));
        when(mowerRepository.updateMower(unprocessedMower))
                .thenReturn(processedMower);

        final var mowerMoveRequest = MowerMoveRequest.builder()
                .mowerInputs(List.of(MowerInput.builder()
                                .mowerId(1L)
                        .mowerPosition(Position.builder()
                                .axisX(3)
                                .axisY(3)
                                .orientation(CardinalDirection.S)
                                .build())
                        .mowerCommand("MMR")
                        .build()))
                .build();

        final var result = mowerCommandExecutor.move(mowerMoveRequest)
                .getPositions().get(0);

        assertThat(result.getAxisX()).isEqualTo(3);
        assertThat(result.getAxisY()).isEqualTo(1);
        assertThat(result.getOrientation()).isEqualTo(CardinalDirection.W);
    }

    @Test
    void givenMowerCoordinatesWhenTryToGetMowerAndIsNotPresentThenMustThrowAnError() {
        when(mowerRepository.getMowerById(MOWER_ID)).thenReturn(Optional.empty());

        final var mowerMoveRequest = MowerMoveRequest.builder()
                .mowerInputs(List.of(MowerInput.builder()
                        .mowerId(1L)
                        .mowerPosition(Position.builder()
                                .axisX(3)
                                .axisY(3)
                                .orientation(CardinalDirection.S)
                                .build())
                        .mowerCommand("MMR")
                        .build()))
                .build();

        assertThatThrownBy(() -> mowerCommandExecutor.move(mowerMoveRequest))
                .isInstanceOf(MowerNotFoundException.class);
    }

}
