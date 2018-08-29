package com.peter.dailyCodingProblem;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.
*/
public class Problem40 {
    public static void main(String[] args) {
        int[] a1 = {6, 1, 3, 3, 3, 6, 6};
        System.out.println(findNonDuplicatedInt(a1));//should return 1
        System.out.println(singleNumber(a1));//should return 1
        int[] a2 = {13, 19, 13, 13};
        System.out.println(findNonDuplicatedInt(a2));//should return 19
        System.out.println(singleNumber(a2));//should return 19
    }

    private static int singleNumber(int[] arr) {//O(N) time and O(1) space
        int ones = 0, twos = 0;
        int common_bit_mask;
        for (int i = 0; i < arr.length; i++) {
            /*"one & arr[i]" gives the bits that are there in
            both 'ones' and new element from arr[]. We
            add these bits to 'twos' using bitwise OR*/
            twos = twos | (ones & arr[i]);

            /*"one & arr[i]" gives the bits that are
            there in both 'ones' and new element from arr[].
            We add these bits to 'twos' using bitwise OR*/
            ones = ones ^ arr[i];

            /* The common bits are those bits which appear third time
            So these bits should not be there in both 'ones' and 'twos'.
            common_bit_mask contains all these bits as 0, so that the bits can
            be removed from 'ones' and 'twos'*/
            common_bit_mask = ~(ones & twos);

            /*Remove common bits (the bits that appear third time) from 'ones'*/
            ones &= common_bit_mask;

            /*Remove common bits (the bits that appear third time) from 'twos'*/
            twos &= common_bit_mask;
        }
        return ones;
    }

    private static int findNonDuplicatedInt(int[] a) {//O(N) time and O(n) space.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return result;
    }
}
