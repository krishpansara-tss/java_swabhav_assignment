package com.moviemanager.model;

import java.io.Serializable;

public class Movie implements Comparable<Movie>, Serializable {
//    private static int nextId = 100;
    private static final long serializationUID = 1l;

    private int id;
    private String title;
    private String genre;
    private int releaseYear;

    public Movie(int id, String title, String genre, int year) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseYear = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int year) {
        this.releaseYear = year;
    }

    public String toFileString() {
        return this.id + "|" + this.title + "|" + this.genre + "|" + this.releaseYear;
    }
    
    @Override
    public String toString() {
        return
                "Id=" + id +
                " | Title=" + title +
                " | Genre=" + genre +
                " | Year=" + releaseYear;
    }

    @Override
    public int compareTo(Movie o) {
        return this.id - o.getId();
    }
}
