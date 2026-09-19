package MovieHub;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<Movie> movies = Data.loadMovies();

        MovieService movieService=new MovieService();

        Scanner sc=new Scanner(System.in);

        while (true){
            movieService.showMainMenu();

            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();

            switch (choice) {
                case 1:
                    movieService.displayMovies(movies);
                    break;

                case 2:
                    System.out.print("How many top movies do you want to see? :");
                    int n = sc.nextInt();
                    movieService.displayTopMovies(movies, n);
                    break;

                case 3:
                    movieService.addMovie(movies);
                    break;

                case 4:
                    movieService.displayFavoriteList();
                    break;

                case 5:
                    movieService.searchMovie(movies);
                    break;

                default:
                    System.out.println("\nInvalid choice! Please try again.");
                    break;
            }
        }
    }
}