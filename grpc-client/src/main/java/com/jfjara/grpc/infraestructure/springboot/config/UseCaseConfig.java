package com.jfjara.grpc.infraestructure.springboot.config;

import com.jfjara.grpc.application.usecase.GetMoviesUseCaseImpl;
import com.jfjara.grpc.application.usecase.ports.GetMoviesUseCase;
import com.jfjara.grpc.infraestructure.grpc.client.GrpcSpringClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public GetMoviesUseCase getMoviesUseCase(final GrpcSpringClient client) {
        return new GetMoviesUseCaseImpl(client);
    }
}
