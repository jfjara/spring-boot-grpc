package com.jfjara.grpc.infraestructure.springboot.controller;

import com.jfjara.grpc.application.usecase.ports.GetMoviesUseCase;
import com.jfjara.grpc.domain.model.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CinemaController {

    @Autowired
    private GetMoviesUseCase getMoviesUseCase;

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDto>> getMovies() {
        var movies = getMoviesUseCase.execute();
        return ResponseEntity.ok(movies);
    }

}
