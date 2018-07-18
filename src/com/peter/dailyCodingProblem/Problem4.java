package com.peter.dailyCodingProblem;

/*
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
*/

import java.util.Arrays;

public class Problem4 {
    public static void main(String[] args) {
        int[] input0 = {};
        System.out.println(firstMissingPositiveInteger(input0));// should return 1

        int[] input1 = {3, 4, 5, 1, 2, 7, 7, 4, 2, 3};
        System.out.println(firstMissingPositiveInteger(input1));// should return 6

        int[] input2 = {3, 4, -1, 1};
        System.out.println(firstMissingPositiveInteger(input2));// should return 2

        int[] input3 = {1, 2, 0};
        System.out.println(firstMissingPositiveInteger(input3));// should return 3

        int[] input4 = {1, -5, 1, 2, 0};
        System.out.println(firstMissingPositiveInteger(input4));// should return 3

        int[] input5 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositiveInteger(input5));// should return 1

        int[] input6 = {0, -1, 2, 3, 4};
        System.out.println(firstMissingPositiveInteger(input6));// should return 1

        int[] input7 = {1};
        System.out.println(firstMissingPositiveInteger(input7));// should return 2

        int[] input8 = {1, 1};
        System.out.println(firstMissingPositiveInteger(input8));// should return 2
    }

    private static int firstMissingPositiveInteger(int[] input) {
        final int length = input.length;
        if (length == 0) {
            return 1;
        }
        Arrays.sort(input);
        int pointer = 0;
        while (input[pointer] <= 0 && pointer < length - 1) {
            pointer++;
        }
        //pointer starts pointing positive elements:
        if (input[pointer] <= 0 || input[pointer] > 1) {
            return 1;
        }
        for (int i = pointer; i < length - 1; i++) {
            if (input[i] + 1 < input[i + 1]) {
                return input[i] + 1;
            }
        }
        return input[length - 1] + 1;
    }
}
