package com.jfjara.grpc.application.usecase;

import com.jfjara.grpc.application.usecase.ports.BookASeatForMovieIdUseCase;
import com.jfjara.grpc.domain.model.Seat;

import java.util.Random;

public class BookASeatForMovieIdUseCaseImpl implements BookASeatForMovieIdUseCase {
    @Override
    public Seat execute(final String idMovie) {
        return Seat.builder().number(new Random(60).nextInt() + 1).build();
    }
}
