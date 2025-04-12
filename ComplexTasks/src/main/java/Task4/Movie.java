package Task4;

import java.util.ArrayList;
import java.util.Objects;

public class Movie {

    private String name;
    private ArrayList<Rating> ratings = new ArrayList<>();


    public Movie (String name){
        this.name = name;
    }

    public void setRate(Rating rate){
        this.ratings.add(rate);
    }

    public ArrayList<Rating> getRatings (){
        return this.ratings;
    }

    public String toString(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
