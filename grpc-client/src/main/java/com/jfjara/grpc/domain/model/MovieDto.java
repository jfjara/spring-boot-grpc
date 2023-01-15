package com.jfjara.grpc.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class MovieDto {

    private String id;
    private String title;
}
