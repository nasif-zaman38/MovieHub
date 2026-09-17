package MovieHub;

public class SeeAllMovies {
    int movieId;
    String movieName;
    int releasedYear;
    double rating;
    String description;

    SeeAllMovies(int movieId, String movieName, int releasedYear, double rating){
        this.movieId = movieId;
        this.movieName = movieName;
        this.releasedYear = releasedYear;
        this.rating = rating;
    }

    void moviesDetail(){
        System.out.println("\nMovie ID: " + movieId);
        System.out.println("Movie Name: " + movieName);
        System.out.println("Released Year: " + releasedYear);
        System.out.println("Rating: " + rating);
        System.out.println("\n");
    }

    public int getId(){
        return movieId;
    }

    void detailsById(){
        System.out.println("\n1. View details");
        System.out.println("2. Add to favorite");
        System.out.println("3. Remove from list");
    }

    public double getRating() {
        return rating;
    }

    SeeAllMovies(int movieId, String movieName, int releasedYear, double rating, String description){
        this.movieId=movieId;
        this.movieName=movieName;
        this.releasedYear=releasedYear;
        this.rating=rating;
        this.description=description;
    }

    void displayDetails(){
        System.out.println("\nMovie ID: " + movieId);
        System.out.println("Movie Name: " + movieName);
        System.out.println("Released Year: " + releasedYear);
        System.out.println("Rating: " + rating);
        System.out.println("Description: " + description);
    }

    public String getMovieName() {
        return movieName;
    }

    void displayMovieName(){
        System.out.println(" " +movieId+ ". "+ movieName);
    }
}