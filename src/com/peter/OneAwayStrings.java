package com.peter;

/*
Write a function that takes two strings and returns true if they are one away
from each other.

They are one away from each other if a single operation (changing a character, deleting a character or adding a character) will change one of the strings to the other.

Examples:

- "abcde" and "abcd" are one away (deleting a character).
- "a" and "a" are one away (changing the only character 'a' to the equivalent character 'a').
- "abc" and "bcc" are not one away. (They are two operations away.);
*/
public class OneAwayStrings {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        isOneAway("abcde", "abcd");  // should return true
        isOneAway("abde", "abcde");  // should return true
        isOneAway("a", "a");  // should return true
        isOneAway("abcdef", "abqdef");  // should return true
        isOneAway("abcdef", "abccef");  // should return true
        isOneAway("abcdef", "abcde");  // should return true
        isOneAway("aaa", "abc");  // should return false
        isOneAway("abcde", "abc");  // should return false
        isOneAway("abc", "abcde");  // should return false
        isOneAway("abc", "bcc");  // should return false
    }

    // Implement your solution below.
    public static Boolean isOneAway(String s1, String s2) {
        return false;
    }
}
