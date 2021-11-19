package com.java.learning.functional.programming.streams;

import java.util.Arrays;
import java.util.List;

public class _08_PeekingElements {
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
                .filter(m -> m.getLikes() > 10)
                .peek(m -> System.out.println("Filtered :- "+ m.getTitle()))
                .map(Movie::getTitle)
                .peek(t -> System.out.println("Mapped :- "+ t))
                .forEach(System.out::println);
    }
}
