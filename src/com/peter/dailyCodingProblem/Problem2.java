package com.peter.dailyCodingProblem;

/*

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem2 {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solutionWithDivision(input1)));//should return [120, 60, 40, 30, 24]
        System.out.println(Arrays.toString(solutionWithoutDivision(input1)));
        System.out.println(Arrays.toString(optimalSolution(input1)));

        int[] input2 = {3, 2, 1};
        System.out.println(Arrays.toString(solutionWithDivision(input2)));//should return [2, 3, 6]
        System.out.println(Arrays.toString(solutionWithoutDivision(input2)));
        System.out.println(Arrays.toString(optimalSolution(input2)));

    }

    private static int[] optimalSolution(int[] input) {
        final int length = input.length;
        ArrayList<Integer> prefixList = new ArrayList<>();
        for (int i : input) {
            if (prefixList.isEmpty()) {
                prefixList.add(i);
            } else {
                prefixList.add(prefixList.get(prefixList.size() - 1) * i);
            }
        }
        ArrayList<Integer> suffixList = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            if (suffixList.isEmpty()) {
                suffixList.add(input[i]);
            } else {
                suffixList.add(suffixList.get(suffixList.size() - 1) * input[i]);
            }
        }
        Collections.reverse(suffixList);

        int[] result = new int[length];
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                resultList.add(suffixList.get(i + 1));
            } else if (i == length - 1) {
                resultList.add(prefixList.get(i - 1));
            } else {
                resultList.add(prefixList.get(i - 1) * suffixList.get(i + 1));
            }
        }
        for (int i = 0; i < length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
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
