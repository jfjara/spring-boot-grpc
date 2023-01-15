package com.jfjara.grpc.application.usecase.ports;

import com.jfjara.grpc.domain.model.Seat;

public interface BookASeatForMovieIdUseCase {

    Seat execute(final String idMovie);

}
