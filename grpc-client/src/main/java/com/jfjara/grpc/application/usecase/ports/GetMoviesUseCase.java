package com.jfjara.grpc.application.usecase.ports;

import com.jfjara.grpc.domain.model.MovieDto;

import java.util.List;

public interface GetMoviesUseCase {

    List<MovieDto> execute();
}
