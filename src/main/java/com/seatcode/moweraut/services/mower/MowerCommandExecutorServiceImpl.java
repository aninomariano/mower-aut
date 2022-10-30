package com.seatcode.moweraut.services.mower;

import com.google.common.primitives.Chars;
import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.dto.mower.MowerInput;
import com.seatcode.moweraut.dto.mower.MowerMoveRequest;
import com.seatcode.moweraut.dto.mower.MowerResponse;
import com.seatcode.moweraut.dto.orientation.MowerDirection;
import com.seatcode.moweraut.exceptions.MowerNotFoundException;
import com.seatcode.moweraut.repository.MowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class MowerCommandExecutorServiceImpl implements MowerCommandExecutorService {

    @Autowired
    private MowerRepository mowerRepository;

    @Override
    public MowerResponse move(final MowerMoveRequest mowerMoveRequest) {
        final var mowerPositionList = mowerMoveRequest.getMowerInputs().stream()
                .map(mowerInput -> process(mowerInput).getPosition())
                .toList();
        return MowerResponse.builder()
                .positions(mowerPositionList)
                .build();
    }

    @Override
    public Mower create(final Mower mower) {
        return mowerRepository.saveMower(mower);
    }

    private Mower process(final MowerInput mowerInput) {
        final var mower = mowerRepository.getMowerById(mowerInput.getMowerId());
        final var command = mowerInput.getMowerCommand();
        final var formattedCommand = new LinkedList<>(Chars.asList(command.toCharArray()));
        if (mower.isPresent()) {
            formattedCommand.forEach(commandChar -> {
                final var mowerStrategy = MowerDirection.getByCommand(commandChar)
                        .getMowerStrategy();
                mowerStrategy.execute(mower.get());
            });
            return mowerRepository.updateMower(mower.get());
        }
        throw new MowerNotFoundException("Mower nor found");
    }
}
