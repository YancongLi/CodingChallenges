package com.peter.dailyCodingProblem;

import java.util.Arrays;

/*
Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
*/
public class Problem35 {
    public static void main(String[] args) {
        char[] characters1 = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        System.out.println(Arrays.toString(segregateRGB(characters1)));//should return ['R', 'R', 'R', 'G', 'G', 'B', 'B']
    }

    private static char[] segregateRGB(char[] characters) {
        if (characters.length <= 1) {
            return characters;
        }
        int pointer1 = 0;
        int pointer2 = 1;

        while (pointer2 < characters.length) {
            if (characters[pointer2] == 'R'){
                Character temp = characters[pointer1];
                characters[pointer1] = characters[pointer2];
                characters[pointer2] = temp;
                pointer1++;
            }
            pointer2++;
        }

        pointer2 = pointer1 + 1;
        while (pointer2 < characters.length) {
            if (characters[pointer2] == 'G') {
                Character temp = characters[pointer1];
                characters[pointer1] = characters[pointer2];
                characters[pointer2] = temp;
                pointer1++;
            }
            pointer2++;
        }

        return characters;
    }
}
