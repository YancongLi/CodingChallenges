package com.peter.dailyCodingProblem;

import java.util.ArrayDeque;
import java.util.Queue;

/*
You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
*/
public class Problem23 {
    public static void main(String[] args) {
        boolean[][] board = new boolean[][]{
                {false, false, false, false},
                {true, true, false, true},
                {false, false, false, false},
                {false, false, false, false}
        };
        SearchBoardWithBFS searchBoardWithBFS = new SearchBoardWithBFS(board);

        Point startPoint = new Point(3, 0);
        Point endPoint = new Point(0, 0);

        System.out.println(searchBoardWithBFS.minimumNumOfSteps(startPoint, endPoint));// should return 7.
    }

    static class Point {
        int x;
        int y;

        Point(int row, int col) {
            this.x = row;
            this.y = col;
        }
    }

    static class QueueNode {
        Point point;
        int distance;

        QueueNode(Point source, int distance) {
            this.point = source;
            this.distance = distance;
        }
    }

    static class SearchBoardWithBFS {
        //To get row and column numbers of 4 neighbours of a given cell:
        private final int[] rowDirection = new int[]{-1, 0, 0, 1};
        private final int[] colDirection = new int[]{0, -1, 1, 0};
        //-------------------
        private int numOfRow;
        private int numOfCol;
        private boolean[][] board;

        SearchBoardWithBFS(boolean[][] board) {
            this.numOfRow = board[0].length;
            this.numOfCol = board.length;
            this.board = board;
        }

        boolean isInTheRangeOfBoard(int row, int col) {
            return (row >= 0 && row < numOfRow) && (col >= 0 && col < numOfCol);
        }

        int minimumNumOfSteps(Point source, Point destination) {
            if (board[source.x][source.y] || board[destination.x][destination.y]) {
                return -1;
            }

            boolean[][] visited = new boolean[numOfRow][numOfCol];

            Queue<QueueNode> queueNodes = new ArrayDeque<>();
            QueueNode sourceNode = new QueueNode(source, 0);
            queueNodes.add(sourceNode);

            while (!queueNodes.isEmpty()) {
                QueueNode current = queueNodes.peek();
                Point point = current.point;

                if (point.x == destination.x && point.y == destination.y) {
                    return current.distance;
                }

                queueNodes.poll();

                for (int i = 0; i < 4; i++) {
                    int row = point.x + rowDirection[i];
                    int col = point.y + colDirection[i];

                    if (isInTheRangeOfBoard(row, col) && !board[row][col] && !visited[row][col]) {
                        visited[row][col] = true;
                        QueueNode adjacentCell = new QueueNode(new Point(row, col), current.distance + 1);
                        queueNodes.add(adjacentCell);
                    }
                }
            }
            return -1;
        }
    }
}
