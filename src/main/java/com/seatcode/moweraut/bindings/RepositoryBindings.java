package com.seatcode.moweraut.bindings;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.seatcode.moweraut.dto.mower.Mower;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RepositoryBindings {

    public static final int DURATION = 24;

    @Bean
    public Cache<Long, Mower> provideMowerRepository() {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(DURATION, TimeUnit.HOURS)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build();
    }
}
