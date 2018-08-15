package com.peter.otherQuestions;

/*
Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index
*/
public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {1, 2, 3};
        System.out.println(pivotIndex(nums1));//should return 3
        System.out.println(pivotIndex(nums2));//should return -1
    }

    private static int pivotIndex(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        int pointer = 0;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        while (pointer < nums.length) {
            if (leftSum == rightSum) {
                return pointer;
            } else {
                leftSum += nums[pointer];
                rightSum -= (pointer + 1 == nums.length ? 0 : nums[pointer + 1]);
                pointer++;
            }
        }
        return -1;
    }
}
