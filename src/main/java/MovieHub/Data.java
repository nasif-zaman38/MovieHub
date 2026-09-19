package MovieHub;

import java.util.ArrayList;
import java.util.List;

public class Data {
    static List<Movie> loadMovies(){
        List<Movie> movies=new ArrayList<>();

        movies.add(new Movie(1,"The Shawshank Redemption",1994,9.3));
        movies.add(new Movie(2, "The Godfather", 1972, 9.0));
        movies.add(new Movie(3, "The Dark Knight", 2008, 8.5));
        movies.add(new Movie(4, "12 Angry Men", 1957, 8.0));
        movies.add(new Movie(5, "Schindler's List", 1993, 8.4));
        movies.add(new Movie(6, "The Return of the King", 2003, 7.8));
        movies.add(new Movie(7, "Pulp Fiction", 1994, 8.3));
        movies.add(new Movie(8, "The Good, the Bad and the Ugly", 1966, 7.9));
        movies.add(new Movie(9, "Fight Club", 1999, 8.8));
        movies.add(new Movie(10, "Forrest Gump", 1994, 8.8));
        movies.add(new Movie(11, "Inception", 2010, 8.2));
        movies.add(new Movie(12, "The Matrix", 1999, 8.6));
        movies.add(new Movie(13, "Goodfellas", 1990, 8.7));

        return movies;
    }
}
