package com.peter.dailyCodingProblem;

/*
Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?
*/

import java.util.Arrays;

public class Problem9 {
    public static void main(String[] args) {
        int[] a1 = {2, 4, 6, 2, 5};
        //System.out.println(largestSumOfNonAdjacentNumbersWithRecursion(a1)); // should return 13 (2 + 6 + 5)
        System.out.println(largestSumOfNonAdjacentNumbersWithDP(a1)); // should return 13 (2 + 6 + 5)

        int[] a2 = {5, 1, 1, 5};
        //System.out.println(largestSumOfNonAdjacentNumbersWithRecursion(a2));// should return 10 (5 + 5)
        System.out.println(largestSumOfNonAdjacentNumbersWithDP(a2));// should return 10 (5 + 5)

        int[] a3 = {1, 2};
        System.out.println(largestSumOfNonAdjacentNumbersWithDP(a3));// should return 2
    }

    private static int largestSumOfNonAdjacentNumbersWithDP(int[] a) {
        if (a.length <= 2) {
            return Math.max(0, Arrays.stream(a).max().getAsInt());
        }

        int[] cache = new int[a.length];
        cache[0] = Math.max(0, a[0]);
        cache[1] = Math.max(cache[0], a[1]);

        for (int i = 2; i < a.length; i++) {
            int num = a[i];
            cache[i] = Math.max((num + cache[i - 2]), cache[i - 1]);
        }
        return cache[a.length - 1];
    }

//    private static int largestSumOfNonAdjacentNumbersWithRecursion(int[] array) { --->  O(2^n)
//        if (array.length == 0) {
//            return 0;
//        }
//        return Math.max(largestSumOfNonAdjacentNumbersWithRecursion(Arrays.copyOfRange(array, 1, array.length)),
//                       (array[0] + (largestSumOfNonAdjacentNumbersWithRecursion(array.length >= 2 ? Arrays.copyOfRange(array, 2, array.length) : array))));
//    }
}
