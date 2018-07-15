package com.peter;

/*

Implement a function that assigns correct numbers in a field of Minesweeper, which represented as a 2 dimentional array.

Example: The size of the the field is 3 x 4, and there are bombs at the position
[0, 0] (row index = 0, column index = 0) and [0, 1] (row index = 0, column index = 1).

Then, the resulting field should be:
[[-1, -1, 1, 0],
 [ 2,  2, 1, 0],
 [ 0,  0, 0, 0]]

*/

import java.util.Arrays;

public class AssignNumInMinesweeper {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] bombs1 = {{0, 2}, {2, 0}};
        // mineSweeper(bombs1, 3, 3) should return:
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]
        System.out.println("Test case 1:");
        System.out.println(Arrays.deepToString(mineSweeper(bombs1, 3, 3)));

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        // mineSweeper(bombs2, 3, 4) should return:
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]
        System.out.println("Test case 2:");
        System.out.println(Arrays.deepToString(mineSweeper(bombs2, 3, 4)));

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        // mineSweeper(bombs3, 5, 5) should return:
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]
        System.out.println("Test case 3:");
        System.out.println(Arrays.deepToString(mineSweeper(bombs3, 5, 5)));
    }

    // Implemented my solution below.
    public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];

        for (int[] bomb : bombs) {
            int rowIndex = bomb[0];
            int colIndex = bomb[1];
            field[rowIndex][colIndex] = -1;

            for (int i = rowIndex - 1; i <= rowIndex + 1; i++) {
                for (int j = colIndex - 1; j <= colIndex + 1; j++) {
                    if ((i >= 0 && i < numRows) && (j >= 0 && j < numCols) && (field[i][j] != -1)) {
                        field[i][j] += 1;
                    }
                }
            }
        }
        return field;
    }
}
