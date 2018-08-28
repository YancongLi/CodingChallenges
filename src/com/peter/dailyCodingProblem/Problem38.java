package com.peter.dailyCodingProblem;

import static com.peter.dailyCodingProblem.Problem38.NQueens.totalNQueens;

/*
You have an N by N board. Write a function that, given N, returns the number of possible arrangements of the board where N queens can be placed on the board without threatening each other, i.e. no two queens share the same row, column, or diagonal.
*/
public class Problem38 {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));//should return 2
        System.out.println(totalNQueens(5));//should return 10
        System.out.println(totalNQueens(6));//should return 4
        System.out.println(totalNQueens(7));//should return 40
    }

    static class NQueens {
        static int total;

        static int totalNQueens(int n) {
            total = 0;
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][i] = '.';
                }
            }

            dfs(0, board);
            return total;
        }

        private static void dfs(int col, char[][] board) {
            int size = board.length;

            if (col == size) {
                total++;
                return;
            }

            for (int i = 0; i < size; i++) {
                if (isValid(board, col, i)) {
                    board[i][col] = 'Q';
                    dfs(col + 1, board);
                    board[i][col] = '.';
                }
            }
        }

        private static boolean isValid(char[][] board, int x, int y) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < x; col++) {
                    if (board[row][col] == 'Q' &&
                            (row + col == x + y || y == row || row - col == y - x)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
