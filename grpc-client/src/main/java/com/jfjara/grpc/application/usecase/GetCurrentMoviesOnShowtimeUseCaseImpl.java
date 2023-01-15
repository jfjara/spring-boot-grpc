package com.jfjara.grpc.application.usecase;

import com.google.common.collect.Lists;
import com.jfjara.grpc.application.usecase.ports.GetCurrentMoviesOnShowtimeUseCase;
import com.jfjara.grpc.domain.model.Movie;

import java.util.List;
import java.util.UUID;

public class GetCurrentMoviesOnShowtimeUseCaseImpl implements GetCurrentMoviesOnShowtimeUseCase {
    @Override
    public List<Movie> execute() {
        return Lists.newArrayList(Movie.builder()
                        .id(UUID.randomUUID().toString())
                        .title("Ghostbusters")
                        .build(),
                Movie.builder()
                        .id(UUID.randomUUID().toString())
                        .title("Back to the future")
                        .build(),
                Movie.builder()
                        .id(UUID.randomUUID().toString())
                        .title("The big Lebowsky")
                        .build(),
                Movie.builder()
                        .id(UUID.randomUUID().toString())
                        .title("GoodFellas")
                        .build()
                );
    }
}
