package com.moviemanager.service;

import com.moviemanager.model.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MovieManager {
    List<Movie> movieList = new ArrayList<>();

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void addMovie(int id, String title, String genre, int year){
        Movie movie = new Movie(id, title, genre, year);

        movieList.add(movie);

        System.out.println("Movie " + title + " added to the list Successfully");
    }

    public void loadMovies() {

        try{

            System.out.println("Loading the movies");

            BufferedReader reader = new BufferedReader(new FileReader("data/movies"));
            String line;

            while((line = reader.readLine()) != null){
                String[] tokens = line.split("\\|");

                int movieId = Integer.parseInt(tokens[0]);
                String title = tokens[1];
                String genre = tokens[2];
                int releaseYear = Integer.parseInt(tokens[3]);

                movieList.add(new Movie(movieId, title, genre, releaseYear));
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("No saved data found. Starting with an empty list. "+e.getMessage());
        } catch(IOException e){
            System.out.println("Error reading the file:" + e.getMessage());
        }

    }

    public void saveMovies() {
        System.out.println("Saving changes to file...");
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/movies"));

            for(Movie movie : movieList){
                writer.write(movie.toFileString());
                writer.newLine();
            }


            System.out.println("All changes permanently saved to file!");
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(IOException e){
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }

    // removeMovie
    public void removeMovie(int movieId){
        boolean removed = movieList.removeIf(movie -> movie.getId() == movieId);

        if (removed) {
            System.out.println("Movie with ID " + movieId + " removed from memory.");
        } else {
            System.out.println("No movie found with ID: " + movieId);
        }
    }

    public List<Movie> serachMovie(String key){
        List<Movie> result = new ArrayList<>();

        for(Movie movie : movieList){
            if(movie.getTitle().toLowerCase().contains(key.toLowerCase())){
                result.add(movie);
            }
        }
        return result;
    }

    public void sortMovies(){
        movieList.sort(null);
        System.out.println("Movies sorted successfully!");
    }
    public void sortMovies(Comparator<Movie> comparator){
        movieList.sort(comparator);
        System.out.println("Movies sorted successfully!");
    }


}
