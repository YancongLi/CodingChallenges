package com.peter.dailyCodingProblem;

/*

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?

*/

import java.util.Arrays;
import java.util.HashSet;

public class Problem1 {
    public static void main(String[] args) {
        int[] a1 = {10, 15, 3, 7};
        System.out.println(solution(a1, 17));//should return true
        System.out.println(binarySearchSolution(a1, 17));
        System.out.println("-----");

        int[] a2 = {};
        System.out.println(solution(a2, 1));//should return false
        System.out.println(binarySearchSolution(a2, 1));
        System.out.println("-----");

        int[] a3 = {0, 2, 1, 2};
        System.out.println(solution(a3, 3));//should return true
        System.out.println(binarySearchSolution(a3, 3));
        System.out.println("-----");

        int[] a4 = {1, 2, 3, 4};
        System.out.println(solution(a4, 0));//should return false
        System.out.println(binarySearchSolution(a4, 0));
        System.out.println("-----");

        int[] a5 = {-3, -2, 3, 2};
        System.out.println(solution(a5, -5));//should return true
        System.out.println(binarySearchSolution(a5, -5));
        System.out.println("-----");

        int[] a6 = {1, 4, 6, 9, 2, 3, 2, 9};
        System.out.println(solution(a6, 5));//should return true
        System.out.println(binarySearchSolution(a6, 4));
        System.out.println("-----");

    }

    private static boolean binarySearchSolution(int[] a, int k) {
        int[] sortedArray = a;
        Arrays.sort(sortedArray);

        for (int i = 0; i < sortedArray.length; i++) {
            int target = k - sortedArray[i];
            int indexResult = Arrays.binarySearch(sortedArray, target);

            if (indexResult == -1) {
                continue;
            } else if (indexResult != i) {
                return true;
            }
        }

        return false;
    }

    private static boolean solution(int[] array, int k) {
        if (array.length == 0) {
            return false;
        }
        HashSet<Integer> seen = new HashSet<>();
        for (int i : array) {
            if (seen.contains((k - i))) {
                return true;
            } else {
                seen.add(i);
            }
        }
        return false;
    }


}
