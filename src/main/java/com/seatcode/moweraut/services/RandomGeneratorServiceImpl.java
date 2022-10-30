package com.seatcode.moweraut.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomGeneratorServiceImpl implements RandomGeneratorService {

    @Override
    public Long generateId() {
        final Random rd = new Random();
        return rd.nextLong(0L, 500L);
    }
}
