package com.peter.dailyCodingProblem;

import java.util.ArrayList;
import java.util.Collections;

/*
Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2
*/
public class Problem33 {
    public static void main(String[] args) {
        int[] sequence1 = {2, 1, 5, 7, 2, 0, 5};
        printRunningMedians(sequence1);
    }

    private static void printRunningMedians(int[] input) {
        int lengthOfInput = input.length;
        ArrayList<Integer> sortedInput = new ArrayList<>();
        for (int i = 0; i < lengthOfInput; i++) {
            sortedInput.add(input[i]);
            Collections.sort(sortedInput);
            double median = getMedianForSortedList(sortedInput);
            System.out.println(median);
        }
    }

    private static double getMedianForSortedList(ArrayList<Integer> sortedInput) {
        int length = sortedInput.size();
        if (length % 2 == 0) {
            return (double) (sortedInput.get(length / 2) + sortedInput.get(length / 2 - 1)) / 2;
        } else {
            return sortedInput.get(length / 2);
        }
    }
}
