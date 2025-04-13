import Task4.Movie;
import Task4.MovieService;
import Task4.Rating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

public class Task4Tests {

    private static MovieService ms = new MovieService();;

    private static Stream<Arguments> validMovieRating(){
        return Stream.of(
                Arguments.of(new Movie("Green Book"), new Rating(10)),
                Arguments.of(new Movie("Wicked"), new Rating(7.5)),
                Arguments.of(new Movie("Green Book"), new Rating(9.5)),
                Arguments.of(new Movie("Wicked"), new Rating(1.00)),
                Arguments.of(new Movie("Green Book"), new Rating(9)),
                Arguments.of(new Movie("Wicked"), new Rating(6.8)),
                Arguments.of(new Movie("Green Book"), new Rating(9.9))
        );
    }

    private static Stream<Arguments> invalidMovieRating(){
        return Stream.of(
                Arguments.of(new Movie("Green Book"), new Rating(0)),
                Arguments.of(new Movie("Wicked"), new Rating(0.9)),
                Arguments.of(new Movie("Green Book"), new Rating(10.01)),
                Arguments.of(new Movie("Wicked"), new Rating(-5))
        );
    }

    private static Stream<Arguments> validMovie(){
        Movie m1 = new Movie("Green Book");
        Movie m2 = new Movie("Wicked");
        ms.addRate(m1, new Rating(10));
        ms.addRate(m2, new Rating(7.5));
        ms.addRate(m1, new Rating(9.5));
        ms.addRate(m2, new Rating(1.00));
        ms.addRate(m1, new Rating(9));
        ms.addRate(m2, new Rating(6.8));
        ms.addRate(m1, new Rating(9.9));
        return Stream.of(
                Arguments.of(m1),
                Arguments.of(m2)
        );
    }

    @ParameterizedTest
    @MethodSource("validMovieRating")
    public void addValidMovieRating(Movie movie, Rating rate) {
        ms.addRate(movie, rate);
        Assertions.assertTrue(ms.getMoviesData().containsKey(movie), "No such movie in the DB");
        Assertions.assertTrue(ms.getMoviesData().get(movie).contains(rate), "No such rate in the rating list of the movie: " + movie);
    }

    @ParameterizedTest
    @MethodSource("invalidMovieRating")
    public void addInvalidMovieRating(Movie movie, Rating rate) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ms.addRate(movie, rate), "Invalid rate was added, no exception thrown");
    }

    @ParameterizedTest
    @MethodSource("validMovie")
    public void testAverageCalculation(Movie movie){
        int ratesCount = ms.getMoviesData().get(movie).size();
        double expectedAverage =  ms.getMoviesData().get(movie).stream().mapToDouble(r -> r.getRate().doubleValue()).sum() / ratesCount;
        Assertions.assertEquals(expectedAverage, ms.averageRating(movie),  "Average rate of the movie is calculated wrong: " + movie);
    }

    @Test
    public void testSorting(){
        List<Movie> sortedMovies = ms.sortedByAverageRate();
        boolean result = false;
        for (int i = 1; i < sortedMovies.size(); i++){
            result = ms.averageRating(sortedMovies.get(i-1)) > ms.averageRating(sortedMovies.get(i));
        }
        Assertions.assertTrue(result, "Wrong movie sorting: " + sortedMovies);
    }
}
