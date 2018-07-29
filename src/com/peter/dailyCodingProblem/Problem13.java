package com.peter.dailyCodingProblem;

/*
Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
*/

public class Problem13 {
    public static void main(String[] args) {
        String string1 = "abcba";
        System.out.println(longestSubStrWithKDistinctChar(string1, 2));//should return "bcb"
    }

    private static String longestSubStrWithKDistinctChar(String str, int k) {
        String result = "-1";
        int length = str.length();
        if (k > length) {
            return result;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < length; i++) {
            int j = i + 1;
            int diffCount = 0;
            String temp = str.substring(i,j);
            while (j < length) {
                if (temp.indexOf(chars[j]) == -1) {
                    diffCount ++;
                    if (diffCount == k) {
                        if (str.substring(i, j).length() > result.length()) {
                            result = str.substring(i, j);
                        }
                    }
                }
                j++;
            }
        }
        return result;
    }
}
