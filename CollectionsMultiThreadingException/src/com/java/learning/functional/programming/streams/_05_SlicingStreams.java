package com.java.learning.functional.programming.streams;

import java.util.Arrays;
import java.util.List;

public class _05_SlicingStreams {

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

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("A", 10),
                new Movie("B", 15),
                new Movie("C", 20)
        );

        movies.stream()
                .limit(2)
                .forEach(m -> System.out.println(m.getTitle()));

        movies.stream()
                .skip(2)
                .forEach(m -> System.out.println(m.getTitle()));

        //1000 movies
        // 10 movies per page
        // 3rd page
        // skip(20) = skip( (page-1) x pageSize )
        // limit(10) = limit(pageSize)

        movies.stream()
                .skip(20)
                .limit(10)
                .forEach(m -> System.out.println(m.getTitle()));
    }
}
