package com.peter.dailyCodingProblem;

/*
The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.
*/
public class Problem31 {
    public static void main(String[] args) {
        String string1 = "kitten";
        String string2 = "sitting";
        System.out.println(editDistanceBetweenTwoWords(string1, string2));//should return 3
        System.out.println(editDistanceBetweenTwoWords("sunday", "saturday"));//should return 3
        System.out.println(editDistanceBetweenTwoWords("cat", "cut"));//should return 1
        System.out.println(editDistanceBetweenTwoWords("abc", "abc"));//should return 0
        System.out.println(editDistanceBetweenTwoWords("ab", "a"));
    }

    private static int editDistanceBetweenTwoWords(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        return editDistHelper(str1, str2, length1, length2);
    }

    //A recursive helper method:
    private static int editDistHelper(String str1, String str2, int length1, int length2) {
        if (length1 == 0 || length2 == 0) {
            return Math.max(length1, length2);
        }
        if (str1.charAt(length1 - 1) == str2.charAt(length2 - 1)) {
            return editDistHelper(str1, str2, length1 - 1, length2 - 1);
        }
        return 1 + minOf3(editDistHelper(str1, str2, length1, length2 - 1),
                editDistHelper(str1, str2, length1 - 1, length2),
                editDistHelper(str1, str2, length1 - 1, length2 - 1));
    }

    private static int minOf3(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }
}
