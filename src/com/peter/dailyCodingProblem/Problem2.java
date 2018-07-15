package com.peter.dailyCodingProblem;

/*

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

*/

import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solutionWithDivision(input1)));//should return [120, 60, 40, 30, 24]
        System.out.println(Arrays.toString(solutionWithoutDivision(input1)));

        int[] input2 = {3, 2, 1};
        System.out.println(Arrays.toString(solutionWithDivision(input2)));//should return [2, 3, 6]
        System.out.println(Arrays.toString(solutionWithoutDivision(input2)));

    }


    private static int[] solutionWithDivision(int[] input) {
        final int length = input.length;
        int[] result = new int[length];

        int productOfAllElements = 1;
        for (int i : input) {
            productOfAllElements *= i;
        }

        for (int i = 0; i < length; i++) {
            result[i] = productOfAllElements / input[i];
        }

        return result;
    }

    //what if you can't use division:
    private static int[] solutionWithoutDivision(int[] input) {
        final int length = input.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = 1;
            for (int j = 0; j < length; j++) {
                if (j != i) {
                    result[i] *= input[j];
                }
            }
        }
        return result;
    }
}
