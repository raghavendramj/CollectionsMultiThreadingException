package com.java.learning.functional.programming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _12_GroupingElements {

    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("A", 10, Genre.THRILLER),
                new Movie("B", 15, Genre.ACTION),
                new Movie("C", 20, Genre.COMEDY),
                new Movie("E", 10, Genre.THRILLER),
                new Movie("F", 15, Genre.ACTION),
                new Movie("G", 20, Genre.COMEDY)
        );


        Map<Genre, List<Movie>> genreListMap = movies.stream().collect(Collectors.groupingBy(Movie::getGenre));
        System.out.println(genreListMap);

        System.out.println(movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.toSet())));
        System.out.println(movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting())));
        System.out.println(movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.mapping(Movie::getTitle, Collectors.joining(",")))));

    }

    static enum Genre {
        COMEDY, ACTION, THRILLER;
    }

    static class Movie {
        private String title;
        private int likes;
        private Genre genre;

        public Movie(String title, int likes, Genre genre) {
            this.title = title;
            this.likes = likes;
            this.genre = genre;
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

        public Genre getGenre() {
            return genre;
        }

        public void setGenre(Genre genre) {
            this.genre = genre;
        }

        @Override
        public String toString() {
            return "\nMovie{" +
                    "title='" + title + '\'' +
                    ", likes=" + likes +
                    ", genre=" + genre +
                    '}';
        }
    }
}
