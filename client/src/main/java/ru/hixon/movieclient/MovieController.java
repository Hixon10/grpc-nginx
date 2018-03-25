package ru.hixon.movieclient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.util.concurrent.ListenableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.hixon.movies.MoviesRatingGrpc;
import ru.hixon.movies.Moviesrating;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class MovieController {

    private final static Logger log = LoggerFactory.getLogger(MovieController.class);

    private final MoviesRatingGrpc.MoviesRatingFutureStub moviesRatingStub;

    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    public MovieController(MoviesRatingGrpc.MoviesRatingFutureStub moviesRatingStub) {
        this.moviesRatingStub = moviesRatingStub;
    }

    @GetMapping("/top")
    Mono<List<Movie>> top() {
        log.info("top()");

        ListenableFuture<Moviesrating.GetRatingResponse> ratingFuture
                = moviesRatingStub.getRating(
                        Moviesrating.GetRatingRequest.newBuilder().build());

        CompletableFuture<List<Movie>> completable = new CompletableFuture<List<Movie>>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                boolean result = ratingFuture.cancel(mayInterruptIfRunning);
                super.cancel(mayInterruptIfRunning);
                return result;
            }
        };

        ratingFuture.addListener(() -> {
            try {
                completable.complete(ratingFuture.get().getMovieList().stream()
                        .map(Movie::new)
                        .collect(Collectors.toList()));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }, executor);

        return Mono.fromFuture(completable);
    }

    public static class Movie {
        private final String title;

        @JsonCreator
        public Movie(@JsonProperty("title") String title) {
            this.title = Objects.requireNonNull(title, "title");
        }

        @JsonProperty("title")
        @Nonnull
        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}
