package com.seatcode.moweraut.repository;

import com.google.common.cache.Cache;
import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.services.RandomGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Optional;
import java.util.function.Supplier;

@Component
public class MowerRepositoryImpl implements MowerRepository {

    private static final Supplier<HttpServerErrorException> CACHE_ERROR =
            () -> new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);

    @Autowired
    private Cache<Long, Mower> mowerRepository;

    @Autowired
    private RandomGeneratorService randomGeneratorService;

    @Override
    public Mower saveMower(final Mower mower) {
        var id = randomGeneratorService.generateId();
        final var updatedMower = mower.toBuilder()
                .id(id)
                .build();
        try {
            mowerRepository.put(id, updatedMower);
        } catch (final Exception e) {
            throw CACHE_ERROR.get();
        }
        return updatedMower;
    }

    @Override
    public Mower updateMower(final Mower mower) {
        try {
            mowerRepository.put(mower.getId(), mower);
        } catch (final Exception e) {
            throw CACHE_ERROR.get();
        }
        return mower;
    }

    @Override
    public Optional<Mower> getMowerById(final Long id) {
        try {
            return Optional.ofNullable(mowerRepository.getIfPresent(id));
        } catch (final Exception e) {
            throw CACHE_ERROR.get();
        }
    }

}
