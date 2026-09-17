package MovieHub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        List<SeeAllMovies> movies=new ArrayList<>();

        movies.add(new SeeAllMovies(1,"The Shawshank Redemption",1994,9.3));
        movies.add(new SeeAllMovies(2, "The Godfather", 1972, 9.0));
        movies.add(new SeeAllMovies(3, "The Dark Knight", 2008, 8.5));
        movies.add(new SeeAllMovies(4, "12 Angry Men", 1957, 8.0));
        movies.add(new SeeAllMovies(5, "Schindler's List", 1993, 8.4));
        movies.add(new SeeAllMovies(6, "The Return of the King", 2003, 7.8));
        movies.add(new SeeAllMovies(7, "Pulp Fiction", 1994, 8.3));
        movies.add(new SeeAllMovies(8, "The Good, the Bad and the Ugly", 1966, 7.9));
        movies.add(new SeeAllMovies(9, "Fight Club", 1999, 8.8));
        movies.add(new SeeAllMovies(10, "Forrest Gump", 1994, 8.8));
        movies.add(new SeeAllMovies(11, "Inception", 2010, 8.2));
        movies.add(new SeeAllMovies(12, "The Matrix", 1999, 8.6));
        movies.add(new SeeAllMovies(13, "Goodfellas", 1990, 8.7));

        Scanner sc=new Scanner(System.in);

        List<SeeAllMovies> favoriteMovies = new ArrayList<>();

        while (true){
            System.out.println("\nWelcome to MovieHub!\n");
            System.out.println("1. See all the list of movies");
            System.out.println("2. See top 10 movies of all time");
            System.out.println("3. Add a movie");
            System.out.println("4. See your favorites list");
            System.out.println("5. Search a movie\n");

            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();

            switch(choice) {
                case 1:
                    for(SeeAllMovies movie: movies){
                        movie.moviesDetail();
                    }

                    System.out.print("\nSelect a movie ID: ");
                    int id=sc.nextInt();

                    SeeAllMovies selectedMovie = null;
                    for(SeeAllMovies movie: movies){
                        if(movie.getId()==id){
                            selectedMovie=movie;
                            break;
                        }
                    }
                    if(selectedMovie==null){
                        System.out.println("\nThis movie is not found!");
                        break;
                    }

                    selectedMovie.detailsById();

                    System.out.print("\nNow, What do you want? : ");
                    int option= sc.nextInt();

                    if (option == 1) {
                        selectedMovie.displayDetails();
                    }
                    else if (option==2) {
                        boolean alreadyFavorite= false;
                        for(SeeAllMovies movie: favoriteMovies){
                            if(movie.getId()==selectedMovie.getId()){
                                System.out.println("\nThis movie is already in your favorite list!");
                                alreadyFavorite=true;
                                break;
                            }
                        }
                        if(!alreadyFavorite){
                            favoriteMovies.add(selectedMovie);
                            System.out.println("\nMovie added to your favorite list!");
                        }
                    }
                    else if (option==3){
                        movies.remove(selectedMovie);
                        System.out.println("\nMovie removed from the list!");
                    }
                    else {
                        System.out.println("\nInvalid Option!");
                    }
                    break;

                case 2:
                    movies.sort((a,b)->Double.compare(b.getRating(), a.getRating()));

                    for(int i=0; i<Math.min(10, movies.size()); i++){
                        movies.get(i).moviesDetail();
                    }

                    System.out.print("\nSelect a movie ID: ");
                    int mId=sc.nextInt();

                    SeeAllMovies topSelectedMovie=null;
                    for(int i=0; i<Math.min(10, movies.size()); i++){
                        if(movies.get(i).getId()==mId){
                            topSelectedMovie=movies.get(i);
                            break;
                        }
                    }
                    if(topSelectedMovie==null){
                        System.out.println("\nThis movie is not in the Top 10!");
                        break;
                    }

                    topSelectedMovie.detailsById();

                    System.out.print("\nNow, What do you want? : ");
                    int topOption= sc.nextInt();

                    if (topOption == 1){
                        topSelectedMovie.displayDetails();
                    }
                    else if (topOption == 2) {
                        boolean alreadyFavorite = false;
                        for(SeeAllMovies movie: favoriteMovies){
                            if(movie.getId()==topSelectedMovie.getId()){
                                System.out.println("\nThis movie is already in your favorite list!");
                                alreadyFavorite=true;
                                break;
                            }
                        }
                        if(!alreadyFavorite){
                            favoriteMovies.add(topSelectedMovie);
                            System.out.println("\nMovie added to your favorite list!");
                        }
                    }
                    else if (topOption == 3) {
                        movies.remove(topSelectedMovie);
                        System.out.println("\nMovie removed from the list!");
                    }
                    else {
                        System.out.println("\nInvalid Option!");
                    }
                    break;

                case 3:
                    System.out.print("Movie ID: ");
                    int movieId= sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    System.out.print("Movie Name: ");
                    String movieName= sc.nextLine();

                    System.out.print("Released Year: ");
                    int releasedYear= sc.nextInt();

                    System.out.print("Rating: ");
                    double rating=sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Movie details/description: ");
                    String description= sc.nextLine();

                    SeeAllMovies newMovie=new SeeAllMovies(
                            movieId,
                            movieName,
                            releasedYear,
                            rating,
                            description
                    );

                    movies.add(newMovie);
                    System.out.println("\nMovie added successfully!");
                    break;

                case 4:
                    if(favoriteMovies.isEmpty()){
                        System.out.println("\nYour favorite movie list is empty!");
                        break;
                    }
                    else {
                        System.out.println("\nYour favorite movie list: ");
                        for(SeeAllMovies movie: favoriteMovies){
                            movie.displayDetails();
                        }
                    }

                    System.out.print("\nDo you want to remove movie from favorites?\n1. Yes\n2. No\n ");
                    System.out.print("\nEnter your choice: ");
                    int input=sc.nextInt();
                    if (input==2){
                        System.out.println("\nYou chose not to remove any movie from favorites.");
                        break;
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
                    break;

                case 5:
                    sc.nextLine(); // Consume the newline character
                    System.out.print("\nEnter the movie name to search: ");
                    String searchTitle=sc.nextLine().toLowerCase();

                    boolean found=false;
                    for (SeeAllMovies movie: movies){
                        if(movie.getMovieName().toLowerCase().contains(searchTitle)){
                            movie.displayMovieName();
                            found=true;
                        }
                    }
                    if(!found){
                        System.out.println("\nMovie not found!");
                        break;
                    }

                    System.out.print("\nSelect a movie ID to view details or add to favorites or remove from the list: ");
                    int m_id=sc.nextInt();

                    SeeAllMovies searchSelectedMovie=null;
                    for(SeeAllMovies movie: movies){
                        if(movie.getId()==m_id) {
                            searchSelectedMovie = movie;
                        }
                    }
                    if(searchSelectedMovie==null){
                        System.out.println("\nThis movie is not found!");
                        break;
                    }

                    searchSelectedMovie.detailsById();

                    System.out.print("\nNow, What do you want? : ");
                    int searchOption= sc.nextInt();

                    if (searchOption == 1){
                        searchSelectedMovie.displayDetails();
                    }
                    else if (searchOption == 2) {
                        boolean alreadyFavorite = false;
                        for(SeeAllMovies movie: favoriteMovies){
                            if(movie.getId()==searchSelectedMovie.getId()){
                                System.out.println("\nThis movie is already in your favorite list!");
                                alreadyFavorite=true;
                                break;
                            }
                        }
                        if(!alreadyFavorite){
                            favoriteMovies.add(searchSelectedMovie);
                            System.out.println("\nMovie added to your favorite list!");
                        }
                    }
                    else if (searchOption == 3) {
                        movies.remove(searchSelectedMovie);
                        System.out.println("\nMovie removed from the list!");
                    }
                    else {
                        System.out.println("\nInvalid Option!");
                    }
                    break;

                default:
                    System.out.println("\nInvalid choice! Please try again.");
                    break;

            }
        }
    }
}