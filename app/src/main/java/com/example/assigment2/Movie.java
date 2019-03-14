package com.example.assigment2;

import java.util.Objects;

public class Movie {
    private int id;
    private String movieName;
    private float rating;

    public Movie(int id, String movieName, float rating) {
        this.id = id;
        this.movieName = movieName;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                Float.compare(movie.rating, rating) == 0 &&
                Objects.equals(movieName, movie.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieName, rating);
    }
}
