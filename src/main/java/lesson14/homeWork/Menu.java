package lesson14.homeWork;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    MovieDatabase movieDatabase = new MovieDatabase();
    ArrayList<Movie> listOfMoviesFromTxTFile = movieDatabase.getListOfMoviesFromFile();
    MovieService movieService = new MovieService();

    Scanner scanner = new Scanner(System.in);

    public void menuX() {
        menuSelection();
        System.out.print("Your selection: \t\t\t");
        int selectedOption = scanner.nextInt();
        menuFunctionality(selectedOption);
    }

    private static void menuSelection() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\tPlease select option from 1-6, action with Movies selection:");
        System.out.println("\t\t\t\t1. Show all                         2. Movies by creator");
        System.out.println("\t\t\t\t3. Find/Sort by name                4. Find/Sort by genre");
        System.out.println("\t\t\t\t5. Find by given name               6. Highest cost");
        System.out.println("\t\t\t\t7. Find by given budget margin      8. Find oldest and latest");
        System.out.println("\t\t\t\t9. Sort by given year              ");
        System.out.println("\t\t\t\t10. TOP5 movies     ");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    private void menuFunctionality(int selectedOption) {
        if (selectedOption == 1) {
            movieService.getAllMoviesNames(listOfMoviesFromTxTFile);
            menuX();
        }
        if (selectedOption == 2) {
            movieService.getAllMoviesByCreator(listOfMoviesFromTxTFile);
            menuX();
        }
        if (selectedOption == 3) {
            movieService.getAllMoviesNamesSortedByName(listOfMoviesFromTxTFile);
            menuX();
        }
        if (selectedOption == 4) {
            movieService.getAllMoviesByGenre(listOfMoviesFromTxTFile);
            menuX();
        }
        if (selectedOption == 5) {
            movieService.findMovieByName(listOfMoviesFromTxTFile, inputFromUserForMovieToFindByName());
            menuX();
        }
        if (selectedOption == 6) {
            movieService.sortByBudgetDescending(listOfMoviesFromTxTFile);
            menuX();
        }
        if (selectedOption == 7) {
            movieService.findMoviesAboveGivenBudget(listOfMoviesFromTxTFile, inputFromUserForRequestedMarginAbove());
            menuX();
        }
        if (selectedOption == 8) {
            movieService.latestOldestMovie(listOfMoviesFromTxTFile);
            menuX();
        }
        if (selectedOption == 9) {
            movieService.findMoviesAboveGiveYearMargin(listOfMoviesFromTxTFile, inputFromUserForFirstYear(),inputFromUserForSecondYear());
            menuX();
        }
        if (selectedOption == 10) {
            movieService.topFiveByCost(listOfMoviesFromTxTFile);
            menuX();
        }
    }

    public Menu() throws IOException {
    }

    public String inputFromUserForMovieToFindByName() {
        System.out.println("Enter movie name to find, by first letters");
        String movieTofFind = scanner.next();
        return movieTofFind;
    }

    public Integer inputFromUserForRequestedMarginAbove() {
        System.out.println("Please provide margin above you are interested ");
        int inputMargin = Integer.parseInt(scanner.next());
        return inputMargin;
    }
    public Year inputFromUserForFirstYear() {
        System.out.println("Please enter Year search from date");
        Year inputFirstYear = Year.parse(scanner.next());
        return inputFirstYear;
    }
    public Year inputFromUserForSecondYear() {
        System.out.println("Please enter year to movie date");
        Year inputSecondYear = Year.parse(scanner.next());
        return inputSecondYear;
    }
}
