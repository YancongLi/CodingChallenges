package com.peter;

/*
* Is One Array a Rotation of Another? (Java)

Write a function that returns true if one array is a rotation of another.

NOTE: There are no duplicates in each of these arrays.

Example: [1, 2, 3, 4, 5, 6, 7] is a rotation of [4, 5, 6, 7, 1, 2, 3].
*
* */


import java.util.ArrayList;

public class RotationArray {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2a = {4, 5, 6, 7, 8, 1, 2, 3};
        // isRotation(array1, array2a) should return false.
        System.out.println(isRotation(array1, array2a));

        int[] array2b = {4, 5, 6, 7, 1, 2, 3};
        // isRotation(array1, array2b) should return true.
        System.out.println(isRotation(array1, array2b));

        int[] array2c = {4, 5, 6, 9, 1, 2, 3};
        // isRotation(array1, array2c) should return false.
        System.out.println(isRotation(array1, array2c));

        int[] array2d = {4, 6, 5, 7, 1, 2, 3};
        // isRotation(array1, array2d) should return false.
        System.out.println(isRotation(array1, array2d));

        int[] array2e = {4, 5, 6, 7, 0, 2, 3};
        // isRotation(array1, array2e) should return false.
        System.out.println(isRotation(array1, array2e));

        int[] array2f = {1, 2, 3, 4, 5, 6, 7};
        // isRotation(array1, array2f) should return true.
        System.out.println(isRotation(array1, array2f));
    }

    // Implement your solution below.
    public static Boolean isRotation(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        ArrayList<Integer> a1 = new ArrayList<>();
        for (int i : array1) {
            a1.add(i);
        }

        int pointer = a1.indexOf(array2[0]);
        if (pointer == -1) {
            return false;
        }

        for (int i = 0; i < array2.length; i++) {
            if (array1[pointer] != array2[i]) {
                return false;
            }

            if (pointer + 1 == array1.length) {
                pointer = 0;
            } else {
                pointer++;
            }

        }
        return true;
    }
}
