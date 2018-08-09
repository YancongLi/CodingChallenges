package com.peter.dailyCodingProblem;

import java.util.ArrayList;
import java.util.Collections;

/*
Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
*/
public class Problem21 {
    public static void main(String[] args) {
        ArrayList<TimeInterval> arrayOfTimeIntervals1 = new ArrayList<>();
        arrayOfTimeIntervals1.add(new TimeInterval(30, 75));
        arrayOfTimeIntervals1.add(new TimeInterval(0, 50));
        arrayOfTimeIntervals1.add(new TimeInterval(60, 150));
        System.out.println(getMinNumOfRooms(arrayOfTimeIntervals1));//should return 2

        ArrayList<TimeInterval> arrayOfTimeIntervals2 = new ArrayList<>();
        arrayOfTimeIntervals2.add(new TimeInterval(1, 4));
        arrayOfTimeIntervals2.add(new TimeInterval(5, 6));
        arrayOfTimeIntervals2.add(new TimeInterval(8, 9));
        arrayOfTimeIntervals2.add(new TimeInterval(2, 6));
        System.out.println(getMinNumOfRooms(arrayOfTimeIntervals2));//should return 2

    }

    private static int getMinNumOfRooms(ArrayList<TimeInterval> timeIntervals) {
        Collections.sort(timeIntervals);

        int roomNeeded = 1;
        int result = 1;
        int startTimePointer = 1;
        int endTimePointer = 0;
        while (startTimePointer < timeIntervals.size() && endTimePointer < timeIntervals.size()) {
            if (timeIntervals.get(startTimePointer).startTime <= timeIntervals.get(endTimePointer).endTime) {
                roomNeeded++;
                startTimePointer++;
                if (roomNeeded > result) {
                    result = roomNeeded;
                }
            } else {
                roomNeeded--;
                endTimePointer++;
            }
        }
        return result;
    }

    static class TimeInterval implements Comparable<TimeInterval> {
        int startTime;
        int endTime;

        TimeInterval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(TimeInterval o) {
            return this.startTime - o.startTime;
        }
    }
}
