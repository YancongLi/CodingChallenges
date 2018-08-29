package com.peter.dailyCodingProblem;

/*
Conway's Game of Life takes place on an infinite two-dimensional board of square cells. Each cell is either dead or alive, and at each tick, the following rules apply:

Any live cell with less than two live neighbours dies.
Any live cell with two or three live neighbours remains living.
Any live cell with more than three live neighbours dies.
Any dead cell with exactly three live neighbours becomes a live cell.
A cell neighbours another cell if it is horizontally, vertically, or diagonally adjacent.

Implement Conway's Game of Life. It should be able to be initialized with a starting list of live cell coordinates and the number of steps it should run for. Once initialized, it should print out the board state at each step. Since it's an infinite board, print out only the relevant coordinates, i.e. from the top-leftmost live cell to bottom-rightmost live cell.

You can represent a live cell with an asterisk (*) and a dead cell with a dot (.).
*/
public class Problem39 {
    public static void main(String[] args) {
        int M = 10, N = 10;
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println("Original Generation");
        printBoard(M, N, grid);
        System.out.println();
        printNextGeneration(grid, M, N);
    }

    private static void printNextGeneration(int grid[][], int M, int N) {
        int[][] future = new int[M][N];
        // Loop through every cell
        for (int l = 1; l < M - 1; l++) {
            for (int m = 1; m < N - 1; m++) {
                // finding number of neighbours that are alive
                int aliveNeighbours = getAliveNeighbours(grid, l, m);
                // Implementing the Rules of Life:
                liveOrDie(grid[l][m], future, l, m, aliveNeighbours);
            }
        }
        System.out.println("Next Generation");
        printBoard(M, N, future);
    }

    private static int getAliveNeighbours(int[][] grid, int l, int m) {
        int numOfAliveNeighbour = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                numOfAliveNeighbour += grid[l + i][m + j];
            }
        }
        // The cell needs to be subtracted from its neighbours as it was counted before
        numOfAliveNeighbour -= grid[l][m];
        return numOfAliveNeighbour;
    }

    private static void liveOrDie(int i, int[][] future, int l, int m, int aliveNeighbours) {
        // Any live cell with less than two live neighbours dies.
        if ((i == 1) && (aliveNeighbours < 2)) {
            future[l][m] = 0;
        }
        // Any live cell with more than three live neighbours dies.
        else if ((i == 1) && (aliveNeighbours > 3)) {
            future[l][m] = 0;
        }
        // Any dead cell with exactly three live neighbours becomes a live cell.
        else if ((i == 0) && (aliveNeighbours == 3)) {
            future[l][m] = 1;
        }
        // Any live cell with two or three live neighbours remains living.
        else {
            future[l][m] = i;
        }
    }

    private static void printBoard(int m, int n, int[][] grid) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
