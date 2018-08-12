package com.peter.dailyCodingProblem;

/*
Implement regular expression matching with the following special characters:

. (period) which matches any single character
* (asterisk) which matches zero or more of the preceding element
That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.

For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.

Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.
*/

// https://leetcode.com/problems/regular-expression-matching/description/

public class Problem25 {
    public static void main(String[] args) {
        System.out.println(isRegexMatch("ra.", "ray"));    //should return true
        System.out.println(isRegexMatch("ra.", "raymond"));//should return false

        System.out.println(isRegexMatch(".*at", "chat"));  //should return true
        System.out.println(isRegexMatch(".*at", "chats")); //should return false

        System.out.println(isRegexMatch("a", "aa"));       //should return false
        System.out.println(isRegexMatch("a*", "aa"));      //should return true

        System.out.println(isRegexMatch("c*a*b", "aab"));  //should return true
    }

    private static boolean isRegexMatch(String pattern, String text) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean isFirstCharMatch = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isRegexMatch(pattern.substring(2), text) ||
                    (isFirstCharMatch && isRegexMatch(pattern, text.substring(1))));
        }else {
            return (isFirstCharMatch && isRegexMatch(pattern.substring(1), text.substring(1)));
        }
    }
}
