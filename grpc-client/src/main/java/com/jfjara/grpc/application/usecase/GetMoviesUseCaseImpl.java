package com.jfjara.grpc.application.usecase;

import com.jfjara.grpc.application.usecase.ports.GetMoviesUseCase;
import com.jfjara.grpc.domain.ports.GetMoviesRepository;
import com.jfjara.grpc.domain.model.MovieDto;

import java.util.List;

public class GetMoviesUseCaseImpl implements GetMoviesUseCase {

    private final GetMoviesRepository getMoviesRepository;

    public GetMoviesUseCaseImpl(final GetMoviesRepository getMoviesRepository) {
        this.getMoviesRepository = getMoviesRepository;
    }

    @Override
    public List<MovieDto> execute() {
        return getMoviesRepository.getMovies();
    }
}
