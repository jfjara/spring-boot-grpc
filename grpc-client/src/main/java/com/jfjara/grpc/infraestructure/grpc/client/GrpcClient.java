package com.jfjara.grpc.infraestructure.grpc.client;

import com.jfjara.grpc.infraestructure.proto.CinemaServiceGrpc;
import com.jfjara.grpc.infraestructure.proto.EmptyMessage;
import com.jfjara.grpc.infraestructure.proto.MovieRequest;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        var channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        var stub = CinemaServiceGrpc.newBlockingStub(channel);

        var movies = stub.getMovies(EmptyMessage.newBuilder()
                .build());

        var movieToBook = movies.getMovies(0);
        var seatBooked = stub.bookSeat(MovieRequest.newBuilder().setId(movieToBook.getId()).build());
        System.out.println(String
                .format("I have reserved seat number %s for movie %s",
                        seatBooked.getNumber(), movieToBook.getTitle()));
        channel.shutdown();
    }
}

