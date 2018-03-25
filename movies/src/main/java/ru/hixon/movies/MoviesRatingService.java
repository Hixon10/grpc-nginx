package ru.hixon.movies;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

@GRpcService
public class MoviesRatingService extends MoviesRatingGrpc.MoviesRatingImplBase {

    private final static Logger log = LoggerFactory.getLogger(MoviesRatingService.class);

    @Override
    public void getRating(Moviesrating.GetRatingRequest request,
                          StreamObserver<Moviesrating.GetRatingResponse> responseObserver) {
        log.info("getRating(): request={}", request);

        List<String> bestMovies = Arrays.asList(
                "The Shawshank Redemption",
                "The Godfather",
                "The Dark Knight",
                "The Godfather: Part II",
                "Pulp Fiction",
                "Schindler's List",
                "The Lord of the Rings: The Return of the King",
                "Angry Men",
                "The Good, the Bad and the Ugly",
                "Inception",
                "The Lord of the Rings: The Fellowship of the Ring",
                "Forrest Gump",
                "Fight Club",
                "Star Wars: Episode V - The Empire Strikes Back",
                "Goodfellas",
                "The Matrix",
                "The Lord of the Rings: The Two Towers",
                "One Flew Over the Cuckoo's Nest",
                "Seven Samurai",
                "Interstellar"
        );

        responseObserver.onNext(Moviesrating.GetRatingResponse.newBuilder()
                .addAllMovie(bestMovies)
                .build());
        responseObserver.onCompleted();
    }
}
