package MovieHub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    Scanner sc=new Scanner(System.in);

    List<Movie> favoriteMovies = new ArrayList<>();

    void showMainMenu(){
        System.out.println("\nWelcome to MovieHub!\n");
        System.out.println("1. See all the list of movies");
        System.out.println("2. See top movies of all time");
        System.out.println("3. Add a movie");
        System.out.println("4. See your favorites list");
        System.out.println("5. Search a movie\n");
    }

    void displayMovies(List<Movie> movies){
        for(Movie movie: movies){
            movie.printMovieDetails();
        }

        handleMovieSelection(movies, movies);
    }

    void displayTopMovies(List<Movie> movies, int n){
        movies.sort((a,b)->Double.compare(b.getRating(), a.getRating()));

        for(int i=0; i<Math.min(n, movies.size()); i++){
            movies.get(i).printMovieDetails();
        }

        System.out.print("\nSelect a movie ID: ");
        int mId=sc.nextInt();

        Movie topSelectedMovie=null;
        for(int i=0; i<Math.min(n, movies.size()); i++){
            if(movies.get(i).getId()==mId){
                topSelectedMovie=movies.get(i);
                break;
            }
        }
        if(topSelectedMovie==null){
            System.out.println("\nThis movie is not in the Top "+n+"!");
            return;
        }

        topSelectedMovie.detailsById();

        handleMovieOption(topSelectedMovie, movies);
    }

    void addMovie(List<Movie> movies){
        System.out.print("Movie ID: ");
        int movieId= sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                System.out.println("\nThis Movie ID already exists!");
                return;
            }
        }

        System.out.print("Movie Name: ");
        String movieName= sc.nextLine();

        System.out.print("Released Year: ");
        int releasedYear= sc.nextInt();

        System.out.print("Rating: ");
        double rating=sc.nextDouble();
        sc.nextLine();

        System.out.print("Movie details/description: ");
        String description= sc.nextLine();

        Movie newMovie=new Movie(
                movieId,
                movieName,
                releasedYear,
                rating,
                description
        );

        movies.add(newMovie);
        System.out.println("\nMovie added successfully!");
    }

    void displayFavoriteList(){
        if(favoriteMovies.isEmpty()){
            System.out.println("\nYour favorite movie list is empty!");
            return;
        }
        else {
            System.out.println("\nYour favorite movie list: ");
            for(Movie movie: favoriteMovies){
                movie.displayDetailsWithDescription();
            }
        }

        System.out.print("\nDo you want to remove movie from favorites?\n1. Yes\n2. No\n ");
        System.out.print("\nEnter your choice: ");
        int input=sc.nextInt();
        if (input==2){
            System.out.println("\nYou chose not to remove any movie from favorites.");
        }
        else if (input==1){
            System.out.print("\nEnter the movie ID to remove from favorites: ");
            int favId=sc.nextInt();
            for(int i=0; i<favoriteMovies.size(); i++){
                if(favoriteMovies.get(i).getId()==favId){
                    favoriteMovies.remove(i);
                    System.out.println("\nMovie removed from your favorite list!");
                    break;
                }
                else {
                    System.out.println("\nThis movie is not in your favorite list!");
                }
            }
        }
        else {
            System.out.println("\nInvalid input!");
        }
    }


    void searchMovie(List<Movie> movies) {
        sc.nextLine(); // Consume the newline character
        System.out.print("\nEnter the movie name to search: ");
        String searchTitle = sc.nextLine().toLowerCase();

        List<Movie> searchResults = new ArrayList<>();

        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getName().toLowerCase().contains(searchTitle)) {
                movie.displayIdAndName();
                searchResults.add(movie);
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nMovie not found!");
            return;
        }

        handleMovieSelection(searchResults, movies);
    }


    private void handleMovieSelection(List<Movie> searchResults, List<Movie> movies) {
        System.out.print("\nSelect a movie ID :");
        int id=sc.nextInt();

        Movie selectedMovie = null;
        for(Movie movie: searchResults){
            if(movie.getId()==id){
                selectedMovie=movie;
                break;
            }
        }
        if(selectedMovie==null){
            System.out.println("\nThis movie is not found!");
            return;
        }

        selectedMovie.detailsById();

        handleMovieOption(selectedMovie, movies);
    }

    private void handleMovieOption(Movie selectedMovie, List<Movie> movies) {
        System.out.print("\nNow, What do you want? : ");
        int option= sc.nextInt();

        if (option == 1) {
            selectedMovie.displayDetailsWithDescription();
        }
        else if (option==2) {
            boolean alreadyFavorite= false;
            for(Movie movie: favoriteMovies){
                if(movie.getId()==selectedMovie.getId()){
                    System.out.println("\nThis movie is already in your favorite list!");
                    alreadyFavorite=true;
                    break;
                }
            }
            if(!alreadyFavorite){
                favoriteMovies.add(selectedMovie);
                System.out.println("\nMovie added to your favorite list!");
            }        }
        else if (option==3){
            movies.remove(selectedMovie);
            System.out.println("\nMovie removed from the list!");
        }
        else {
            System.out.println("\nInvalid Option!");
        }
    }
}
