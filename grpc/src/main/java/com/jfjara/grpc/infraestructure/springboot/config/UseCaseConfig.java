package com.jfjara.grpc.infraestructure.springboot.config;

import com.jfjara.grpc.application.usecase.ports.BookASeatForMovieIdUseCase;
import com.jfjara.grpc.application.usecase.BookASeatForMovieIdUseCaseImpl;
import com.jfjara.grpc.application.usecase.ports.GetCurrentMoviesOnShowtimeUseCase;
import com.jfjara.grpc.application.usecase.GetCurrentMoviesOnShowtimeUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class UseCaseConfig {

    @Bean
    @Primary
    public GetCurrentMoviesOnShowtimeUseCase getCurrentMoviesOnShowtimeUseCase() {
        return new GetCurrentMoviesOnShowtimeUseCaseImpl();
    }

    @Bean
    @Primary
    public BookASeatForMovieIdUseCase bookASeatForMovieIdUseCase() {
        return new BookASeatForMovieIdUseCaseImpl();
    }
}
