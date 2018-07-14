package com.peter.dailyCodingProblem;

/*

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

*/

import java.util.ArrayList;

public class Problem1 {
    public static void main(String[] args) {
        int[] a1 = {10, 15, 3, 7};
        System.out.println(solution(a1, 17));//should return true

        int[] a2 = {};
        System.out.println(solution(a2, 1));//should return false

        int[] a3 = {0, 2, 1, 2};
        System.out.println(solution(a3, 3));//should return true

        int[] a4 = {1, 2, 3, 4};
        System.out.println(solution(a4, 0));//should return false

        int[] a5 = {-3, -2, 3, 2};
        System.out.println(solution(a5, -5));//should return true


    }

    private static boolean solution(int[] array, int k) {
        if (array.length == 0) {
            return false;
        }
        ArrayList<Integer> referenceArray = new ArrayList<>();
        for (int i : array) {
            referenceArray.add(k - i);
        }
        int seenTwice = 0;
        for (int i : array) {
            if (referenceArray.contains(i)) {
                seenTwice++;
                if (seenTwice == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
