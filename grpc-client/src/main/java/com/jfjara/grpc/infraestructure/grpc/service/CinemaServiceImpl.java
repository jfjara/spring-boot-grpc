package com.jfjara.grpc.infraestructure.grpc.service;

import com.jfjara.grpc.application.usecase.ports.BookASeatForMovieIdUseCase;
import com.jfjara.grpc.application.usecase.ports.GetCurrentMoviesOnShowtimeUseCase;
import com.jfjara.grpc.infraestructure.grpc.mapper.MovieMapper;
import com.jfjara.grpc.infraestructure.grpc.mapper.SeatMapper;
import com.jfjara.grpc.infraestructure.proto.*;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;


public class CinemaServiceImpl extends CinemaServiceGrpc.CinemaServiceImplBase {

    @Autowired
    private GetCurrentMoviesOnShowtimeUseCase getCurrentMoviesOnShowtimeUseCase;

    @Autowired
    private BookASeatForMovieIdUseCase bookASeatForMovieIdUseCase;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private SeatMapper seatMapper;

    @Override
    public void getMovies(EmptyMessage request, StreamObserver<MovieShowtimesResponse> responseObserver) {
        var movies = getCurrentMoviesOnShowtimeUseCase.execute();
        var moviesDto = movieMapper.toDtos(movies);
        var response = MovieShowtimesResponse.newBuilder().addAllMovies(moviesDto).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void bookSeat(MovieRequest request, StreamObserver<SeatResponse> responseObserver) {
        var seatAssigned = bookASeatForMovieIdUseCase.execute(request.getId());
        var seatAssignedDto = seatMapper.toDto(seatAssigned);
        responseObserver.onNext(seatAssignedDto);
        responseObserver.onCompleted();
    }

}
