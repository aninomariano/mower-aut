package com.seatcode.moweraut.services;

import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.Position;
import com.seatcode.moweraut.repository.MowerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MowerRequestExecutorTest {

    @Mock
    private MowerRepository mowerRepository;

    @InjectMocks
    private MowerCommandExecutorImpl mowerCommandExecutor;

    @Test
    void givenMowerCoordinatesWhenTryToMoveInNorthDirectionThenMustReturnCurrent() {
        final var mower = Mower.builder()
                .id(1L)
                .position(Position.builder()
                        .axisX(0)
                        .axisY(0)
                        .orientation("N")
                        .build())
                .build();
        final var command = "MMR";

        final var result = mowerCommandExecutor.move(mower, command);

        assertThat(result.getAxisX()).isEqualTo(0);
        assertThat(result.getAxisY()).isEqualTo(2);
        assertThat(result.getOrientation()).isEqualTo("E");
    }

    @Test
    void givenMowerCoordinatesWhenTryToMoveInEastDirectionThenMustReturnCurrent() {
        final var position = Mower.builder()
                .id(1L)
                .position(Position.builder()
                        .axisX(0)
                        .axisY(0)
                        .orientation("E")
                        .build())
                .build();
        final var command = "MML";

        final var result = mowerCommandExecutor.move(position, command);

        assertThat(result.getAxisX()).isEqualTo(2);
        assertThat(result.getAxisY()).isEqualTo(0);
        assertThat(result.getOrientation()).isEqualTo("N");
    }

    @Test
    void givenMowerCoordinatesWhenTryToMoveInWestDirectionThenMustReturnCurrent() {
        final var position = Mower.builder()
                .id(1L)
                .position(Position.builder()
                        .axisX(3)
                        .axisY(0)
                        .orientation("W")
                        .build())
                .build();
        final var command = "MMR";

        final var result = mowerCommandExecutor.move(position, command);

        assertThat(result.getAxisX()).isEqualTo(1);
        assertThat(result.getAxisY()).isEqualTo(0);
        assertThat(result.getOrientation()).isEqualTo("N");
    }

    @Test
    void givenMowerCoordinatesWhenTryToMoveInSouthDirectionThenMustReturnCurrent() {
        final var position = Mower.builder()
                .id(1L)
                .position(Position.builder()
                        .axisX(3)
                        .axisY(3)
                        .orientation("S")
                        .build())
                .build();
        final var command = "MMR";

        final var result = mowerCommandExecutor.move(position, command);

        assertThat(result.getAxisX()).isEqualTo(3);
        assertThat(result.getAxisY()).isEqualTo(1);
        assertThat(result.getOrientation()).isEqualTo("W");
    }

}
