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
        testIsRegexMatch();
        System.out.println("----");
        testIsMatch();
    }

    private static void testIsMatch() {
        System.out.println(isMatch("ra.", "ray"));    //should return true
        System.out.println(isMatch("ra.", "raymond"));//should return false

        System.out.println(isMatch(".*at", "chat"));  //should return true
        System.out.println(isMatch(".*at", "chats")); //should return false

        System.out.println(isMatch("a", "aa"));       //should return false
        System.out.println(isMatch("a*", "aa"));      //should return true
    }

    private static void testIsRegexMatch() {
        System.out.println(isRegexMatch("ra.", "ray"));    //should return true
        System.out.println(isRegexMatch("ra.", "raymond"));//should return false

        System.out.println(isRegexMatch(".*at", "chat"));  //should return true
        System.out.println(isRegexMatch(".*at", "chats")); //should return false

        System.out.println(isRegexMatch("a", "aa"));       //should return false
        System.out.println(isRegexMatch("a*", "aa"));      //should return true
    }

    private static boolean isRegexMatch(String pattern, String text) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean isFirstCharMatch = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isRegexMatch(pattern.substring(2), text) ||
                    (isFirstCharMatch && isRegexMatch(pattern, text.substring(1))));
        } else {
            return (isFirstCharMatch && isRegexMatch(pattern.substring(1), text.substring(1)));
        }
    }

    private static boolean isMatch(String p, String s) {
        // base case
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // special case
        if (p.length() == 1) {

            // if the length of s is 0, return false
            if (s.length() < 1) {
                return false;
            }

            //if the first does not match, return false
            else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            }

            // otherwise, compare the rest of the string of s and p.
            else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        // case 1: when the second char of p is not '*'
        if (p.charAt(1) != '*') {
            if (s.length() < 1) {
                return false;
            }
            if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        // case 2: when the second char of p is '*', complex case.
        else {
            //case 2.1: a char & '*' can stand for 0 element
            if (isMatch(s, p.substring(2))) {
                return true;
            }

            //case 2.2: a char & '*' can stand for 1 or more preceding element,
            //so try every sub string
            int i = 0;
            while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}
