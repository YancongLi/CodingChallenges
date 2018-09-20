package com.peter.dailyCodingProblem;

import java.util.HashMap;
import java.util.Map;

/*
Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting airport, compute the person's itinerary. If no such itinerary exists, return null. If there are multiple possible itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.

For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].

Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.

Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary. However, the first one is lexicographically smaller.
*/
public class Problem41 {
    public static void main(String[] args) {
        HashMap<String, String> dataSet = new HashMap<>();
//        dataSet.put("SFO", "HKO");
//        dataSet.put("YYZ", "SFO");
//        dataSet.put("YUL", "YYZ");
//        dataSet.put("HKO", "ORD");
//        dataSet.put("Chennai", "Banglore");
//        dataSet.put("Bombay", "Delhi");
//        dataSet.put("Goa", "Chennai");
//        dataSet.put("Delhi", "Goa");

        //If you try the below case, it will loop infinitely, however, it works with above examples
        dataSet.put("A", "B");
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "A");

        printResult(dataSet);
    }

    private static void printResult(HashMap<String, String> dataSet) {
        // To store reverse of given map
        HashMap<String, String> reverseMap = new HashMap<>();

        // To fill reverse map, iterate through the given map
        for (Map.Entry<String,String> entry: dataSet.entrySet())
            reverseMap.put(entry.getValue(), entry.getKey());

        // Find the starting point of itinerary
        String start = null;
        for (Map.Entry<String,String> entry: dataSet.entrySet())
        {
            if (!reverseMap.containsKey(entry.getKey()))
            {
                start = entry.getKey();
                break;
            }
        }

        // If we could not find a starting point, then something wrong
        // with input
        if (start == null)
        {
            System.out.println("Invalid Input");
            return;
        }

        // Once we have starting point, we simple need to go next, next
        // of next using given hash map
        String to = dataSet.get(start);
        while (to != null)
        {
            System.out.print(start +  "->" + to + ", ");
            start = to;
            to = dataSet.get(to);
        }
    }
}
