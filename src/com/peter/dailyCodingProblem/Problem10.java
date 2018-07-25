package com.peter.dailyCodingProblem;

/*
Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
*/

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Problem10 {
    public static void main(String[] args) {
        Runnable runnable = () -> f();
        System.out.println("Time: " + Calendar.getInstance().getTime().toString());
        scheduler(runnable, 3000); // call after 3 seconds
    }

    private static void scheduler(Runnable function, int n) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(function, n, TimeUnit.MILLISECONDS);
    }

    private static void f() {
        System.out.println("Do work...");
        System.out.println("Time: " + Calendar.getInstance().getTime().toString());
        System.exit(0);
    }
}
