package com.peter.dailyCodingProblem;

/*
There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
*/

public class Problem12 {
    public static void main(String[] args) {
        System.out.println(numOfWaysToClimb(1));//should return 1
        System.out.println(numOfWaysToClimb(2));//should return 2
        System.out.println(numOfWaysToClimb(3));//should return 3
        System.out.println(numOfWaysToClimb(4));//should return 5
    }

    private static int numOfWaysToClimb(int n) {
        if (n <= 1) {
            return 1;
        }
        return numOfWaysToClimb(n-1) + numOfWaysToClimb(n-2);
    }
}
