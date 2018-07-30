package com.peter.dailyCodingProblem;

/*
The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.

Hint: The basic equation of a circle is x^2 + y^2 = r^2.
*/

public class Problem14 {
    public static void main(String[] args) {
        computePi();
    }

    private static void computePi() {
        int numOfThrows = 0;
        int numOfSuccess = 0;
        double x, y;

        for (int i = 0; i < 10000000; i++) {
            x = Math.random();
            y = Math.random();
            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                numOfSuccess++;
            }
            numOfThrows++;
        }

        double pi = 4 * ((double)numOfSuccess/(double) numOfThrows);
        System.out.println("Estimated value of Pi: " + pi);
        System.out.println("Actual value of Pi: " + Math.PI);
    }
}
