package com.moviemanager.comparator;

import com.moviemanager.model.Movie;

import java.util.Comparator;

public class TitleComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o2.getTitle().compareTo(o1.getTitle());
    }
}
