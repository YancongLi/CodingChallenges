package com.peter.elevenEssentialCodingQuestions;

/*
* Find the most frequently occurring item in an array.

Example: The most frequently occurring item in [1, 3, 1, 3, 2, 1] is 1.

If you're given an empty array, you should return null (in Java) or None (in Python).

You can assume that there is always a single, unique value that appears most frequently unless the array is empty.  For instance, you won't be given an array such as [1, 1, 2, 2].
*/

import java.util.HashMap;

public class MostFreItemInArray {

    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        // mostFrequent(array1) should return 1.
        int[] array1 = {1, 3, 1, 3, 2, 1};
        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        // mostFrequent(array3) should return null.
        int[] array3 = {};
        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};

        System.out.println(mostFreqent(array1));
        System.out.println(mostFreqent(array2));
        System.out.println(mostFreqent(array3));
        System.out.println(mostFreqent(array4));
        System.out.println(mostFreqent(array5));
    }

    // Implement your solution below.
    public static Integer mostFreqent(int[] givenArray) {
        Integer maxItem = null;

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < givenArray.length; i++) {

            Integer key = givenArray[i];
            Integer value = map.get(key);
            if (value == null) {
                map.put(key, 1);
            } else {
                map.put(key, ++value);
            }

            if (map.get(key) > max) {
                max = map.get(key);
                maxItem = key;
            }
        }

        return maxItem;
    }
}
