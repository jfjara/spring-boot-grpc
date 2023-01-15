package com.jfjara.grpc.infraestructure.grpc.boot;

import com.jfjara.grpc.infraestructure.grpc.service.CinemaServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        var server = ServerBuilder
                .forPort(8080)
                .addService(new CinemaServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
