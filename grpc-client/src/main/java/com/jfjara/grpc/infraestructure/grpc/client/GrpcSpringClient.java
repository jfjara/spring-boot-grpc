package com.jfjara.grpc.infraestructure.grpc.client;

import com.jfjara.grpc.domain.model.MovieDto;
import com.jfjara.grpc.domain.ports.GetMoviesRepository;
import com.jfjara.grpc.infraestructure.grpc.mapper.MovieMapper;
import com.jfjara.grpc.infraestructure.proto.CinemaServiceGrpc;
import com.jfjara.grpc.infraestructure.proto.EmptyMessage;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrpcSpringClient implements GetMoviesRepository {

    @GrpcClient("local-grpc-server")
    private CinemaServiceGrpc.CinemaServiceBlockingStub service;

    @Autowired
    private MovieMapper mapper;

    @Override
    public List<MovieDto> getMovies() {
        var response = service.getMovies(EmptyMessage.newBuilder().build());
        return mapper.toDtos(response.getMoviesList());
    }
}

