package com.peter.algoexpert;

import java.util.Arrays;
import java.util.HashSet;

//Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. If any two numbers in the input array sum up to the target sum, the function should return them in an array, in sorted order. If no two numbers sum up to the target sum, the function should return an empty array. Assume that there will be at most one pair of numbers summing up to the target sum.

public class twoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoNumberSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10)));
    }

    private static int[] twoNumberSum(int[] array, int targetSum) {
        if (array.length == 1) {
            return new int[0];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i : array) {
            if (set.contains(targetSum - i)) {
                int res1 = targetSum - i;
                if (res1 > i) {
                    return new int[]{i, res1};
                }
                else {
                    return new int[]{res1, i};
                }
            }else {
                set.add(i);
            }
        }
        return new int[0];
    }
}
