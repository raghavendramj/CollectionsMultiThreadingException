package com.java.learning.concurrency.basics;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class _09_ConcurrentCollections {

    public static void main(String[] args) {

        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "a");

        map.get(1);

        map.remove(1);

    }
}
