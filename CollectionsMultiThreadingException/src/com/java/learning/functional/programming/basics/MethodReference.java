package com.java.learning.functional.programming.basics;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

interface FuncInterface {
    void display(String message);
}

public class MethodReference {

    public MethodReference() {
        System.out.println("Creating an object via default constructor !");
    }

    public MethodReference(String s) {
        System.out.println("Creating an object via parametrized constructor and the message is : " + s);
    }

    public static void main(String[] args) {
        new MethodReference().show();
    }

    public static void printMessageStatic(String message) {
        System.out.println(message);
    }

    private static void myStaticRun() {
        System.out.println("Thread name is : " + Thread.currentThread().getName());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void myRun() {
        System.out.println("Thread name is : " + Thread.currentThread().getName());
    }

    public int add(int a, int b) {
        return a + b;
    }

    private void show() {

        FuncInterface funcInterface = new MethodReference()::printMessage; //instance method
        funcInterface.display("Hey Instance Buddy!");

        FuncInterface funcInterface2 = MethodReference::printMessageStatic; //Static method
        funcInterface2.display("Hey Static Buddy!");


        FuncInterface funcInterface3 = MethodReference::new;
        funcInterface3.display("Hey Constructor Buddy!");


        Thread thread = new Thread(new MethodReference()::myRun);
        Thread thread2 = new Thread(MethodReference::myStaticRun);
        thread.start();
        thread2.start();


        BiFunction<Integer, Integer, Integer> adder = new MethodReference()::add;
        Integer result = adder.apply(10, 20);

        System.out.println("result is " + result);

        //Write a Java 8 program to square the list of numbers and then filter out the numbers greater than 100 and then find the average of the remaining numbers?
        Integer[] arr = new Integer[]{100, 100, 9, 8, 200};


        List<Integer> list = Arrays.asList(arr);
        OptionalDouble average = Arrays.stream(arr).mapToInt(number -> number * number).filter(number -> number > 100).average();
        System.out.println("Average : " + average);

        Consumer<String> tConsumer = str -> System.out.println(str);
        tConsumer.accept("Testing");


        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());


        Predicate<Integer> isNumGrtThan10 = number -> number > 10;
        System.out.println("isNumGrtThan10 : " + isNumGrtThan10.test(11));


        ToIntBiFunction<Integer, Integer> adder2 = (a, b) -> a + b;
        int finalResult = adder2.applyAsInt(10, 20);
        System.out.println("Added result : "+ finalResult);


        // Write a Java 8 program to find the lowest and highest number of a Stream?

        Integer high = Stream.of(1, 2, 3, 77, 6, 5).max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Largest : "+ high);
        Integer lowest = Stream.of(1, 2, 3, 77, 6, 5).min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Smallest : "+ lowest);


        StringJoiner joiner = new StringJoiner(",");
        joiner.add("Raghav");
        joiner.add("Archana");
        joiner.add("Bangara");
        System.out.println("joiner :- " + joiner);

        StringJoiner joinerWithPrefixAndSuffix = new StringJoiner(",", "(", ")");
        joinerWithPrefixAndSuffix.add("Raghav");
        joinerWithPrefixAndSuffix.add("Archana");
        joinerWithPrefixAndSuffix.add("Bangara");
        System.out.println("joinerWithPrefixAndSuffix :- " + joinerWithPrefixAndSuffix);


        Stream<Integer> numbers = Stream.iterate(2, count -> count + 1).filter(num -> num%2 == 0).limit(5);


        numbers.forEach(System.out::println);

    }


}
