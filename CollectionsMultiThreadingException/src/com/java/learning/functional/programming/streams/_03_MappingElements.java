package com.java.learning.functional.programming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _03_MappingElements {


    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("A", 10),
                new Movie("B", 15),
                new Movie("C", 20)
        );

        movies.stream()
                .map(movie -> movie.getTitle())
                .forEach(name -> System.out.println(name));

        long count = movies.stream().mapToInt(movie -> movie.getLikes()).count();
        System.out.println("Count is " + count);

        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 7), Arrays.asList(8, 10, 12));

        listStream.flatMap(list -> list.stream())
                .forEach(n -> System.out.println(n));


        Stream<List<Integer>> listStream2 = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 7), Arrays.asList(8, 10, 12));
        List<Integer> integerList = listStream2.flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println("Faltted out list : "+ integerList);


        Map<String, Integer> convertedMap = movies.stream().collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));
        System.out.println("Mapped Elements:- "+ convertedMap);
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
