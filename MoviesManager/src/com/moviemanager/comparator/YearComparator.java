package com.moviemanager.comparator;

import com.moviemanager.model.Movie;

import java.util.Comparator;

public class YearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getReleaseYear() - o2.getReleaseYear();
    }
}
