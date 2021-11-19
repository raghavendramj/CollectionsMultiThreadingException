package com.java.learning.functional.programming.streams;

import java.util.Arrays;
import java.util.List;

public class _07_UniqueValues {

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("A", 10),
                new Movie("B", 15),
                new Movie("B", 15),
                new Movie("C", 20),
                new Movie("C", 20)
        );

        movies.stream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println);
    }

    static class Movie {
        private String title;
        private int likes;

        public Movie(String title, int likes) {
            this.title = title;
            this.likes = likes;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

}
