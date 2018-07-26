package com.peter.dailyCodingProblem;

/*
Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Problem11 {
    public static void main(String[] args) {
        String queryString = "de";
        String[] possibleStrings = {"dog", "deer", "deal"};
        System.out.println(Arrays.toString(autocomplete(queryString, possibleStrings)));// should return [deer, deal]
    }

    private static String[] autocomplete(String queryString, String[] possibleStrings) {
        String[] result = new String[0];
        final int length = queryString.length();
        if (length == 0 || possibleStrings.length == 0) {
            return result;
        }
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (String str: possibleStrings) {
            String temp = str.substring(0, length);
            if (temp.equals(queryString)) {
                stringArrayList.add(str);
            }
        }
        result = new String[stringArrayList.size()];
        for (int i = 0; i< result.length; i++) {
            result[i] = stringArrayList.get(i);
        }
        return result;
    }
}
