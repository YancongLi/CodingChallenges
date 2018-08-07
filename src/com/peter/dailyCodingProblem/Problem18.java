package com.peter.dailyCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
*/
public class Problem18 {
    public static void main(String[] args) {
        int[] a1 = {10, 5, 2, 7, 8, 7};
        System.out.println(Arrays.toString(maxValuesOfSubarray(a1, 3)));//should return [10, 7, 8, 8]
    }

    private static int[] maxValuesOfSubarray(int[] a, int k) {//this is O(n * k)
        ArrayList<Integer> resultArray = new ArrayList<>();
        ArrayList<Integer> inputArray = new ArrayList<>();
        for (int i : a) {
            inputArray.add(i);
        }
        ArrayList<Integer> subArray = new ArrayList<>(inputArray.subList(0, inputArray.size()));
        for (int i = 0; i < inputArray.size() - k + 1; i++) {
            int max = subArray.get(0);
            for (int j = 0; j < k; j++) {
                if (subArray.get(j) > max) {
                    max = subArray.get(j);
                }
            }
            resultArray.add(max);
            subArray = new ArrayList<>(inputArray.subList(i + 1, inputArray.size()));
            //System.out.println("index i: " + i + "|" + subArray);
        }
        int[] result = new int[resultArray.size()];
        for (int i = 0; i < resultArray.size(); i++) {
            result[i] = resultArray.get(i);
        }
        return result;
    }
}
