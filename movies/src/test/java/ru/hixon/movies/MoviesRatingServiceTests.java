package ru.hixon.movies;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesRatingServiceTests extends GrpcServerTestBase {

    @Test
    public void getMoviesRatingTest() {
        MoviesRatingGrpc.MoviesRatingBlockingStub moviesRatingBlockingStub
                = MoviesRatingGrpc.newBlockingStub(channel);

        Moviesrating.GetRatingResponse ratingResponse
                = moviesRatingBlockingStub.getRating(
                        Moviesrating.GetRatingRequest.newBuilder().build());

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

        Assert.assertEquals(bestMovies, ratingResponse.getMovieList());
    }

}
