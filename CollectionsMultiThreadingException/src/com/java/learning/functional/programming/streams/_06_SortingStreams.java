package com.java.learning.functional.programming.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _06_SortingStreams {

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("B", 15),
                new Movie("A", 10),
                new Movie("C", 20)
        );

        System.out.println("Ascending First Time ");
        movies.stream()
                .sorted((a, b) -> a.getTitle()
                        .compareTo(b.getTitle()))
                .forEach(a -> System.out.println(a.getTitle()));

        System.out.println("Ascending Second Time ");
        movies.stream()
                .sorted(Comparator.comparing(m -> m.getTitle()))
                .forEach(m -> System.out.println(m.getTitle()));
        System.out.println("Ascending Third Time ");
        movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(m -> System.out.println(m.getTitle()));

        System.out.println("Descending Fourth Time ");
        movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .forEach(m -> System.out.println(m.getTitle()));
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
