package com.jfjara.grpc.infraestructure.grpc.mapper;

import com.jfjara.grpc.domain.model.Seat;
import com.jfjara.grpc.infraestructure.proto.SeatResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeatMapper {

    default SeatResponse toDto(final Seat seat) {
        return SeatResponse.newBuilder().setNumber(seat.getNumber()).build();
    }

}
