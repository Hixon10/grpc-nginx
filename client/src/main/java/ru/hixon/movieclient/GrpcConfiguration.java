package ru.hixon.movieclient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hixon.movies.MoviesRatingGrpc;

@Configuration
public class GrpcConfiguration {

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 80)
                .usePlaintext(true)
                .build();
    }

    @Bean
    public MoviesRatingGrpc.MoviesRatingFutureStub moviesRatingStub(
            ManagedChannel managedChannel) {
        return MoviesRatingGrpc.newFutureStub(managedChannel);
    }
}
