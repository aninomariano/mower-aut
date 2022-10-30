package com.seatcode.moweraut.dto.orientation;

import com.seatcode.moweraut.dto.mower.Mower;
import lombok.Getter;

import java.io.Serializable;

@Getter
public enum CardinalDirection implements Serializable {

    N {
        @Override
        public void moveMower(final Mower mower) {
            final var position = mower.getPosition();
            position.setAxisY(position.getAxisY() + 1);
        }
    },
    S {
        @Override
        public void moveMower(final Mower mower) {
            final var position = mower.getPosition();
            position.setAxisY(position.getAxisY() - 1);
        }
    },
    E {
        @Override
        public void moveMower(final Mower mower) {
            final var position = mower.getPosition();
            position.setAxisX(position.getAxisX() + 1);
        }
    },
    W {
        @Override
        public void moveMower(final Mower mower) {
            final var position = mower.getPosition();
            position.setAxisX(position.getAxisX() - 1);
        }
    };

    public abstract void moveMower(final Mower mower);
}
