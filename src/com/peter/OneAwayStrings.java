package com.peter;

import java.util.ArrayList;

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
        System.out.println(isOneAway("abcde", "abcd"));  // should return true
        System.out.println(isOneAway("abde", "abcde"));  // should return true
        System.out.println(isOneAway("abcde", "abde"));  // should return true
        System.out.println(isOneAway("a", "a"));  // should return true
        System.out.println(isOneAway("abcdef", "abqdef"));  // should return true
        System.out.println(isOneAway("abcdef", "abccef"));  // should return true
        System.out.println(isOneAway("abcdef", "abcde"));  // should return true
        System.out.println(isOneAway("aaa", "abc"));  // should return false
        System.out.println(isOneAway("abcde", "abc"));  // should return false
        System.out.println(isOneAway("abc", "abcde"));  // should return false
        System.out.println(isOneAway("abc", "bcc"));  // should return false
    }

    // Implement your solution below.
    public static Boolean isOneAway(String s1, String s2) {
        final int s1length = s1.length();
        final int s2length = s2.length();

        if (s1length - s2length > 1 || s2length - s1length > 1) {//"abc", "abcde" => eliminates invalid length difference
            return false;
        }

        if (s1.equals(s2)) {//"a", "a"
            return true;
        }

        if (s1.contains(s2) || s2.contains(s1)) {//"abcde", "abcd"
            return true;
        }

        ArrayList<Character> characterArrayList1 = new ArrayList<>();
        ArrayList<Character> characterArrayList2 = new ArrayList<>();
        ArrayList<Character> tempArray;
        for (char c : s1.toCharArray()) {
            characterArrayList1.add(c);
        }
        for (char c : s2.toCharArray()) {
            characterArrayList2.add(c);
        }

        //case: "abcdef", "abqdef"
        if (s1length == s2length) {
            int differenceCounter = 0;
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            for (int i = 0; i < s1length; i++) {
                if (c1[i] != c2[i]) {
                    differenceCounter++;
                    if (differenceCounter > 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        if (s1length > s2length) {//case: "abcde", "abde"
            for (int i = 1; i < s1length - 1; i++) {
                tempArray = (ArrayList<Character>) characterArrayList1.clone();
                tempArray.remove(i);
                String tempStr = tempArray.toString();
                if (tempStr.equals(characterArrayList2.toString())) {
                    return true;
                }
            }
        } else {//case: "abde", "abcde"
            for (int i = 1; i < s2length - 1; i++) {
                tempArray = (ArrayList<Character>) characterArrayList2.clone();
                tempArray.remove(i);
                String tempStr = tempArray.toString();
                if (tempStr.equals(characterArrayList1.toString())) {
                    return true;
                }
            }
        }

        return false;
    }
}
