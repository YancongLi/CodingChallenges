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
        System.out.println(Arrays.toString(maxValuesOfSubArray(a1, 3)));//should return [10, 7, 8, 8]
        System.out.println(Arrays.toString(maxSlidingWindow(a1, 3)));//should return [10, 7, 8, 8]
        int[] a2 = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxValuesOfSubArray(a2, 3)));//should return [3,3,5,5,6,7]
        System.out.println(Arrays.toString(maxSlidingWindow(a2, 3)));//should return [3,3,5,5,6,7]
    }

    private static int[] maxSlidingWindow(int[] a, int k) {//O(n)
        if (k < 1 || k > a.length) {
            return new int[0];
        }
        int[] leftMax = new int[a.length];
        int[] rightMax = new int[a.length];
        int leftMaxVal = 0;
        int rightMaxVal = a[a.length - 1];
        for (int i = 0; i < a.length; i++) {
            leftMaxVal = (i % k == 0) ? a[i] : Math.max(leftMaxVal, a[i]);
            leftMax[i] = leftMaxVal;
        }
        //System.out.println("lefMax array: " + Arrays.toString(leftMax));
        for (int i = a.length - 1; i >= 0; i--) {
            rightMaxVal = ((i + 1) % k == 0) ? a[i] : Math.max(rightMaxVal, a[i]);
            rightMax[i] = rightMaxVal;
        }
        //System.out.println("rightMax array: " + Arrays.toString(rightMax));
        int[] output = new int[a.length - k + 1];
        int j = 0;
        for (int i = 0; i + k <= a.length; i++) {
            output[j++] = Math.max(rightMax[i], leftMax[i + k - 1]);
        }
        return output;
    }

    private static int[] maxValuesOfSubArray(int[] a, int k) {//this is O(n * k)
        if (k < 1 || k > a.length) {
            return new int[0];
        }
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
