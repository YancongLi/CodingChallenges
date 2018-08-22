package com.peter.dailyCodingProblem;

/*
Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible anywhere in the word. If there is more than one palindrome of minimum length that can be made, return the lexicographically earliest one (the first one alphabetically).

For example, given the string "race", you should return "ecarace", since we can add three letters to it (which is the smallest amount to make a palindrome). There are seven other palindromes that can be made from "race" by adding three letters, but "ecarace" comes first alphabetically.

As another example, given the string "google", you should return "elgoogle".
*/
public class Problem34 {
    public static void main(String[] args) {
        String string1 = "race";
        System.out.println(producePalindrome(string1));//should return "ecarace"
        String string2 = "google";
        System.out.println(producePalindrome(string2));//should return "elgoogle"
    }

    private static String producePalindrome(String string) {
        if (string.length() <= 1) {
            return string;
        }
        String palindrome1 = makePalindromeFromLastChar(string);
        String palindrome2 = makePalindromeFromFirstChar(string);

        if (palindrome1.length() == palindrome2.length()) {
            if (palindrome1.charAt(0) < palindrome2.charAt(0)) {
                return palindrome1;
            } else return palindrome2;
        }

        if (palindrome1.length() < palindrome2.length()) {
            return palindrome1;
        } else {
            return palindrome2;
        }
    }

    private static String makePalindromeFromFirstChar(String base) {
        String suffix = "";
        int index = 0;
        while (!isPalindrome(base + suffix)) {
            suffix = base.charAt(index) + suffix;
            index++;
        }
        return base + suffix;
    }

    private static String makePalindromeFromLastChar(String base) {
        String prefix = "";
        int index = base.length() - 1;
        while (!isPalindrome(prefix + base)) {
            prefix = prefix + base.charAt(index);
            index--;
        }
        return prefix + base;
    }

    private static boolean isPalindrome(String s) {
        int firstPointer = 0;
        int lastPointer = s.length() - 1;
        while (firstPointer < lastPointer) {
            if (s.charAt(firstPointer) != s.charAt(lastPointer)) {
                return false;
            }
            firstPointer++;
            lastPointer--;
        }
        return true;
    }
}
