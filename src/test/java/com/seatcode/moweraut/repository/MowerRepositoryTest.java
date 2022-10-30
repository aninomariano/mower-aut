package com.seatcode.moweraut.repository;

import com.google.common.cache.Cache;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.seatcode.moweraut.dto.mower.Mower;
import com.seatcode.moweraut.services.RandomGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.HttpServerErrorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MowerRepositoryTest {

    public static final long RANDOM_ID = 1L;
    @Mock
    private Cache<Long, Mower> mowerCache;

    @Mock
    private RandomGeneratorService randomGeneratorService;

    @InjectMocks
    private MowerRepositoryImpl mowerRepository;

    @Test
    void givenMowerWhenTryToSaveItThenMustGoAllOk() {
        final var mower = Mower.builder().build();
        when(randomGeneratorService.generateId()).thenReturn(RANDOM_ID);

        final var response = mowerRepository.saveMower(mower);

        assertThat(response.getId()).isEqualTo(RANDOM_ID);
    }

    @Test
    void givenMowerWhenTryToUpdateMowerPositionThenMustGoAllOk() {
        final var mower = Mower.builder()
                .id(RANDOM_ID)
                .build();

        final var response = mowerRepository.updateMower(mower);

        assertThat(response.getId()).isEqualTo(RANDOM_ID);
    }

    @Test
    void givenMowerWhenTryToGetMowerThenMustGoAllOk() {
        final var mower = Mower.builder()
                .id(RANDOM_ID)
                .build();
        when(mowerCache.getIfPresent(RANDOM_ID)).thenReturn(mower);

        final var response = mowerRepository.getMowerById(RANDOM_ID);

        assertThat(response.get().getId()).isEqualTo(RANDOM_ID);
    }

    @Test
    void givenMowerWhenTryToSaveAndStorageIsBrokenThenMustReturnAnError() {
        final var mower = Mower.builder().build();
        doThrow(UncheckedExecutionException.class)
                .when(mowerCache)
                .put(anyLong(), any(Mower.class));

        assertThatThrownBy(() -> mowerRepository.saveMower(mower))
                .isInstanceOf(HttpServerErrorException.class);
    }

    @Test
    void givenMowerWhenTryToUpdateMowerPositionAndStorageIsBrokenThenMustReturnAnError() {
        final var mower = Mower.builder().build();
        doThrow(UncheckedExecutionException.class)
                .when(mowerCache)
                .put(anyLong(), any(Mower.class));

        assertThatThrownBy(() -> mowerRepository.updateMower(mower))
                .isInstanceOf(HttpServerErrorException.class);
    }

    @Test
    void givenMowerIdWhenTryToGetMowerAndStorageIsBrokenThenMustReturnAnError() {
        doThrow(UncheckedExecutionException.class)
                .when(mowerCache)
                .getIfPresent(anyLong());

        assertThatThrownBy(() -> mowerRepository.getMowerById(RANDOM_ID))
                .isInstanceOf(HttpServerErrorException.class);
    }
}
