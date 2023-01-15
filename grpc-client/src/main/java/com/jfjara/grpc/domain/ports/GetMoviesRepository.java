package com.jfjara.grpc.domain.ports;

import com.jfjara.grpc.domain.model.MovieDto;

import java.util.List;

public interface GetMoviesRepository {

    List<MovieDto> getMovies();
}
