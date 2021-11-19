package com.java.learning.functional.programming.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _09_Reducers {

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
                new Movie("A", 10),
                new Movie("B", 15),
                new Movie("C", 20),
                new Movie("D", 30)
        );

        boolean anyMatch = movies.stream().
                anyMatch(m -> m.getLikes() > 20);

        System.out.println("anyMatch ? "+ movies.stream().anyMatch(m -> m.getLikes() > 20));
        System.out.println("allMatch ? "+ movies.stream().allMatch(m -> m.getLikes() > 20));
        System.out.println("noneMatch ? "+ movies.stream().noneMatch(m -> m.getLikes() > 20));
        System.out.println("findFirst ? "+ movies.stream().findFirst().get());
        System.out.println("findAny ? "+ movies.stream().findAny().get());
        System.out.println("max(Comparator.comparing() ? "+ movies.stream().max(Comparator.comparing(Movie::getLikes)).get());
    }


}
