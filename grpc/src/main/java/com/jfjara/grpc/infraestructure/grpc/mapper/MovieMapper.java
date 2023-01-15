package com.jfjara.grpc.infraestructure.grpc.mapper;

import com.jfjara.grpc.domain.model.Movie;
import com.jfjara.grpc.infraestructure.proto.MovieShowtimesResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Named("toMovieDto")
    default MovieShowtimesResponse.Movie toDto(final Movie movie) {
        return MovieShowtimesResponse.Movie.newBuilder()
                .setId(movie.getId())
                .setTitle(movie.getTitle()).build();
    }

    @IterableMapping(qualifiedByName = "toMovieDto")
    List<MovieShowtimesResponse.Movie> toDtos(final List<Movie> movies);

}
