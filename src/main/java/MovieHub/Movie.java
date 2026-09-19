package MovieHub;

public class Movie {
    int id;
    String name;
    int releasedYear;
    double rating;
    String description;

    Movie(int id, String name, int releasedYear, double rating){
        this.id = id;
        this.name = name;
        this.releasedYear = releasedYear;
        this.rating = rating;
    }

    void printMovieDetails(){
        System.out.println("\nMovie ID: " + id);
        System.out.println("Movie Name: " + name);
        System.out.println("Released Year: " + releasedYear);
        System.out.println("Rating: " + rating);
        System.out.println("\n");
    }

    public int getId(){
        return id;
    }

    void detailsById(){
        System.out.println("\n1. View details");
        System.out.println("2. Add to favorite");
        System.out.println("3. Remove from list");
    }

    public double getRating() {
        return rating;
    }

    Movie(int id, String name, int releasedYear, double rating, String description){
        this.id=id;
        this.name=name;
        this.releasedYear=releasedYear;
        this.rating=rating;
        this.description=description;
    }

    void displayDetailsWithDescription(){
        System.out.println("\nMovie ID: " + id);
        System.out.println("Movie Name: " + name);
        System.out.println("Released Year: " + releasedYear);
        System.out.println("Rating: " + rating);
        System.out.println("Description: " + description);
    }

    public String getName() {
        return name;
    }

    void displayIdAndName(){
        System.out.println(" " +id+ ". "+ name);
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public String getDescription() {
        return description;
    }
}