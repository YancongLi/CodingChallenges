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
        int[] a2 = {13, 19, 13, 13};
        System.out.println(findNonDuplicatedInt(a2));//should return 19
    }

    private static int findNonDuplicatedInt(int[] a) {//O(N) time but not O(1) space.
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
