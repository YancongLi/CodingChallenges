package com.peter.otherQuestions;

//Given an integer, write a function that returns true if the given number is palindrome, else false. For example, 12321 is palindrome, but 1451 is not palindrome.
public class IfANumberIsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1234));//should return false
        System.out.println(isPalindrome(12321));//should return true
    }

    private static boolean isPalindrome(int i) {
        int input = i;
        int reverse = 0;
        while (i > 0) {
            reverse = reverse * 10 + i % 10;
            i = i / 10;
        }
        return (reverse == input);
    }
}
