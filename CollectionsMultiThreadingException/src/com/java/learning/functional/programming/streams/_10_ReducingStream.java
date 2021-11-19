package com.java.learning.functional.programming.streams;

import java.util.Arrays;
import java.util.List;

public class _10_ReducingStream {

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

        Integer addedSum = movies.stream()
                .map(m -> m.getLikes())
                .reduce((a, x) -> a + x).get();

        System.out.println("addedSum -> "+ addedSum);

        Integer addedSum2 = movies.stream()
                .map(m -> m.getLikes())
                .reduce(Integer::sum).get();

        System.out.println("addedSum2 -> "+ addedSum2);

        Integer addedSum3 = movies.stream()
                .map(m -> m.getLikes())
                .reduce(0, Integer::sum);

        System.out.println("addedSum3 -> "+ addedSum3);

    }
}
