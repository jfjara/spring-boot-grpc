package com.jfjara.grpc.infraestructure.grpc.mapper;

import com.jfjara.grpc.infraestructure.proto.MovieShowtimesResponse;
import com.jfjara.grpc.domain.model.MovieDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Named("toMovieDto")
    default MovieDto toDto(final MovieShowtimesResponse.Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .build();
    }

    @IterableMapping(qualifiedByName = "toMovieDto")
    List<MovieDto> toDtos(final List<MovieShowtimesResponse.Movie> movies);

}
