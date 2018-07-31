package com.peter.dailyCodingProblem;

/*
Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
*/

import java.util.Arrays;
import java.util.Random;

public class Problem15 {
    public static void main(String[] args) {
        int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        selectKItems(stream, stream.length, 1);
        selectKItems(stream, stream.length, 5);
    }

    private static void selectKItems(int[] stream, int n, int k) {
        int i;// index for elements in stream[]

        int reservoir[] = new int[k]; // reservoir[] is the output array. Initialize it with first k elements from stream[]
        for (i = 0; i < k; i++) {
            reservoir[i] = stream[i];
        }

        Random r = new Random();

        for (; i < n; i++) {// Iterate from the (k+1)th element to nth element
            int j = r.nextInt(i + 1); // Pick a random index from 0 to i.

            if (j < k) {// If the randomly  picked index is smaller than k,
                reservoir[j] = stream[i]; // then replace the element present at the index with new element from stream
            }
        }

        System.out.println("Following are " + k + " randomly selected items: \n" + Arrays.toString(reservoir));
    }
}
