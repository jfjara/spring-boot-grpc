package com.jfjara.grpc.application.usecase.ports;

import com.jfjara.grpc.domain.model.Movie;

import java.util.List;

public interface GetCurrentMoviesOnShowtimeUseCase {

    List<Movie> execute();

}
