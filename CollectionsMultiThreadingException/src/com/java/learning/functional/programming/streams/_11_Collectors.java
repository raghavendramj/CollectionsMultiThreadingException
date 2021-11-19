package com.java.learning.functional.programming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _11_Collectors {

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

        @Override
        public String toString() {
            return "Movie{" +
                    "title='" + title + '\'' +
                    ", likes=" + likes +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Conjouring", 10),
                new Movie("The New York", 15),
                new Movie("Laagan", 20)
        );

        System.out.println("Result toList is :- "+ movies.stream().filter(m -> m.getLikes() > 10).collect(Collectors.toList()));
        System.out.println("Result toSet is :- "+ movies.stream().filter(m -> m.getLikes() > 10).collect(Collectors.toSet()));
        System.out.println("Result toMap(Movie::getTitle, Movie::getLikes) is :- "+ movies.stream().filter(m -> m.getLikes() > 10).collect(Collectors.toMap(Movie::getTitle, Movie::getLikes)));
        System.out.println("Result toMap(Movie::getTitle, m -> m)  m -> m is :- "+ movies.stream().filter(m -> m.getLikes() > 10).collect(Collectors.toMap(Movie::getTitle, m -> m)));
        System.out.println("Result toMap(Movie::getTitle, Function.identity() is :- "+ movies.stream().filter(m -> m.getLikes() > 10).collect(Collectors.toMap(Movie::getTitle, Function.identity())));
        System.out.println("Result Collectors.summingInt(Movie::getLikes) is :- "+ movies.stream().filter(m -> m.getLikes() > 10).collect(Collectors.summingInt(Movie::getLikes)));
        System.out.println("Result Collectors.summarizingInt(Movie::getLikes) is :- "+ movies.stream().filter(m -> m.getLikes() > 10).collect(Collectors.summarizingInt(Movie::getLikes)));
        System.out.println("Result Collectors.joining(\",  \") is :- "+ movies.stream().map(Movie::getTitle).collect(Collectors.joining(",  ")));

    }
}
