import com.moviemanager.comparator.GenreComparator;
import com.moviemanager.comparator.TitleComparator;
import com.moviemanager.comparator.YearComparator;
import com.moviemanager.model.Movie;
import com.moviemanager.service.MovieManager;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieManager movieManager = new MovieManager();
        Scanner scanner = new Scanner(System.in);
        int opr;

        while(true){
            System.out.println("Options: ");
            System.out.println("1. Load movie from file");
            System.out.println("2. Add Movie to the list");
            System.out.println("3. Delete movie from the list");
            System.out.println("4. Search");
            System.out.println("5. Sort");
            System.out.println("6. Display All");
            System.out.println("7. Save changes");
            System.out.println("8. Exit");
            System.out.print("Choose option from this: ");
            opr = scanner.nextInt();


            switch (opr){
                case 1:
                    movieManager.loadMovies();
                    break;
                case 2:
                    System.out.println("Enter Movie Details: ");
                    int movieId = inputMovieId(scanner);


                    String title = inputTitle(scanner);


                    String genre = inputGenre(scanner);


                    int year = inputReleaseYear(scanner);

                    movieManager.addMovie(movieId, title, genre, year);

                    break;
                case 3:
                    System.out.print("Id of the movie: ");
                    movieId = scanner.nextInt();

                    movieManager.removeMovie(movieId);
                    break;
                case 4:
                    System.out.println("Enter movie to search");
                    scanner.nextLine();
                    String key = scanner.nextLine();

                    List<Movie> movieList = movieManager.serachMovie(key);

                    if(movieList.isEmpty()){
                        System.out.println("No movie found");
                    }else{
                        for(Movie movie : movieList){
                            System.out.println(movie);
                        }
                    }

                    break;
                case 5:
                    System.out.println("How would you like to sort?");
                    System.out.println("1. Sort by ID (Default)");
                    System.out.println("2. Sort by Title");
                    System.out.println("3. Sort by Year");

                    int sortChoice = scanner.nextInt();

                    switch (sortChoice) {
                        case 1:
                            movieManager.sortMovies();
                            break;
                        case 2:
                            movieManager.sortMovies(new TitleComparator());
                            break;
                        case 3:
                            movieManager.sortMovies(new YearComparator());
                            break;
                        default:
                            System.out.println("Invalid sorting choice.");
                    }
                    break;

                case 6:
                    List<Movie> allMoviesList = movieManager.getMovieList();
                    if(allMoviesList.isEmpty()){
                        System.out.println("No movie added");
                    }else{

                        for(Movie movie : allMoviesList){
                            System.out.println(movie);
                        }

                    }
                    break;

                case 7:
                    movieManager.saveMovies();
                    break;

                case 8:
                    System.out.println("Returning the program...");
                    return;

                default:
                    System.out.println("Please enter valid value");


            }

        }
    }

    public static int inputMovieId(Scanner scanner){
        int movieId;
        while (true) {
            System.out.print("Id of the movie: ");
            if (scanner.hasNextInt()) {
                movieId = scanner.nextInt();
                scanner.nextLine();
                if (movieId > 0) {
                    break;
                } else {
                    System.out.println("Id must be positive.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        return movieId;
    }

    public static int inputReleaseYear(Scanner scanner){
        int releaseYear;
        while (true) {
            System.out.print("Release year of the movie: ");
            if (scanner.hasNextInt()) {
                releaseYear = scanner.nextInt();
                scanner.nextLine();

                if (releaseYear >= 1888 && releaseYear <= java.time.Year.now().getValue()) {
                    break;
                } else {
                    System.out.println("Enter a valid year (1888 - current year).");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        return releaseYear;
    }

    public static String inputTitle(Scanner scanner){
        String title;
        while (true) {
            System.out.print("Name of the movie: ");
            title = scanner.nextLine().trim();
            if (!title.isEmpty()) {
                break;
            } else {
                System.out.println("Title cannot be empty.");
            }
        }
        return title;
    }

    public static String inputGenre(Scanner scanner){
        String genre;
        while (true) {
            System.out.print("Genre of the movie: ");
            genre = scanner.nextLine().trim();
            if (!genre.isEmpty()) {
                break;
            } else {
                System.out.println("Genre cannot be empty.");
            }
        }
        return genre;
    }
}
