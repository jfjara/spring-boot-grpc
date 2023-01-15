package com.jfjara.grpc.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class Seat {

    private Integer number;

}
