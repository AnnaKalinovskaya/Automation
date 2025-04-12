package Task4;

import java.util.*;

public class MovieService {

    private Map<Movie, List<Rating>> moviesData = new LinkedHashMap<>();

    public synchronized void addRate(Movie movie, Rating rate){
        if (rate.getRate().doubleValue() < 1.00 || rate.getRate().doubleValue() > 10.00){
            throw new IllegalArgumentException("Valid rating value is 1-10.");
        }
        movie.setRate(rate);
        moviesData.put(movie, movie.getRatings());
    }

    public double averageRating (Movie movie){
        List<Rating> rates = movie.getRatings();
        int size = rates.size();
        double sum = rates.stream().mapToDouble(r -> r.getRate().doubleValue()).sum();
        return sum / size;
    }

    public List<Movie> sortedByAverageRate(){
        List<Map.Entry<Movie, Double>> moviesWithAverage = new ArrayList<>();
        List<Movie> allMovies = moviesData.keySet().stream().toList();
        for (Movie m : allMovies){
            Map.Entry<Movie, Double> entry =  new AbstractMap.SimpleEntry<>(m, averageRating(m));
            moviesWithAverage.add(entry);
        }
        moviesWithAverage.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        return moviesWithAverage.stream().map(Map.Entry::getKey).toList();
    }

}
