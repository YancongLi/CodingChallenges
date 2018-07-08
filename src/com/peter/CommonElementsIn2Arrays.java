package com.peter;

/*
* Write a function that returns the common elements (as an array) between two sorted arrays
* of integers (ascending order).

Example: The common elements between [1, 3, 4, 6, 7, 9] and [1, 2, 4, 5, 9, 10] are [1, 4, 9].
* */

import java.util.ArrayList;
import java.util.Arrays;

public class CommonElementsIn2Arrays {
    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};
        // commonElements(array1A, array2A) should return [1, 4, 9] (an array).
        System.out.println(Arrays.toString(commonElements(array1A, array2A)));

        int[] array1B = {1, 2, 9, 10, 11, 12};
        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
        // commonElements(array1B, array2B) should return [1, 2, 9, 10, 12] (an array).
        System.out.println(Arrays.toString(commonElements(array1B, array2B)));

        int[] array1C = {0, 1, 2, 3, 4, 5};
        int[] array2C = {6, 7, 8, 9, 10, 11};
        // common_elements(array1C, array2C) should return [] (an empty array).
        System.out.println(Arrays.toString(commonElements(array1C, array2C)));
    }

    // Implement your solution below.
    // NOTE: Remember to return an Integer array, not an int array.
    public static Integer[] commonElements(int[] array1, int[] array2) {
        //My solution:
//        ArrayList<Integer> commonArrayList = new ArrayList<>();
//
//        HashMap<Integer, Integer> commonMap = new HashMap<>();
//        for (int i : array1) {
//            int key = i;
//            commonMap.put(key, 1);
//        }
//
//        for (int i: array2) {
//            if (commonMap.get(i) != null) {
//                commonArrayList.add(i);
//            }
//        }
//
//        Integer[] commonInTwoArrays = commonArrayList.toArray(new Integer[0]);
//
//        return commonInTwoArrays;

        //A better solution (Note: two sorted arrays is the key!):

        ArrayList<Integer> commonElementsList = new ArrayList<>();
        int pointerOne = 0;
        int pointerTwo = 0;

        while (pointerOne < array1.length && pointerTwo < array2.length) {
            if (array1[pointerOne] == array2[pointerTwo]) {
                commonElementsList.add(array1[pointerOne]);
                pointerOne++;
                pointerTwo++;
            } else if (array1[pointerOne] > array2[pointerTwo]) {
                pointerTwo++;
            } else {
                pointerOne++;
            }
        }

        Integer[] result = new Integer[commonElementsList.size()];
        result = commonElementsList.toArray(result);

        return result;
    }
}
