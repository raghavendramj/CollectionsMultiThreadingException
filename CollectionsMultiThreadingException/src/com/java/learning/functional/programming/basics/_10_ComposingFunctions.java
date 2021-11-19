package com.java.learning.functional.programming.basics;

import java.util.function.Function;

public class _10_ComposingFunctions {

    public static void main(String[] args) {
        //"key:value"
        //first: "key=value"
        //second: "{key=value}"

        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";

        //Declarative programming
        String result = replaceColon
                            .andThen(addBraces)
                            .apply("key:value");

        System.out.println("Result :- " + result);


        String composedResult = addBraces
                                    .compose(replaceColon)
                .apply("key:value");
        System.out.println("composedResult :- " + composedResult);


    }
}
