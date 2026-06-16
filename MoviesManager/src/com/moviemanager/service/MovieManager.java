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
        File file = new File("data/movies.ser");
        System.out.println("Loading the movies");
        if (!file.exists()) {
            System.out.println("No saved data found. Starting fresh.");
            return;
        }
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

            movieList = (List<Movie>) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Movies loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found. Starting with an empty list. "+e.getMessage());
        } catch(IOException | ClassNotFoundException e){
            System.out.println("Error reading the file:" + e.getMessage());
        }

    }

    public void saveMovies() {
        System.out.println("Saving changes to file...");
        File file = new File("data/movies.ser");
        file.getParentFile().mkdirs();

        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(movieList);

            objectOutputStream.close();

            System.out.println("All changes permanently saved to file!");
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
