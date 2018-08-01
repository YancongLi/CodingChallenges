package com.peter.dailyCodingProblem;

/*
You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

record(order_id): adds the order_id to the log
get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
You should be as efficient with time and space as possible.
*/

import java.util.Arrays;

public class Problem16 {
    public static void main(String[] args) {
        circularBuffer circularBuffer = new circularBuffer(4);
        circularBuffer.record(1);
        circularBuffer.record(2);
        circularBuffer.record(3);
        circularBuffer.record(4);
        System.out.println(circularBuffer.printArray());//should return: [1, 2, 3, 4]
        System.out.println(circularBuffer.getLast(1));//should return 4
        System.out.println(circularBuffer.getLast(2));//should return 3
        System.out.println(circularBuffer.getLast(3));//should return 2
        System.out.println(circularBuffer.getLast(4));//should return 1
        circularBuffer.record(5);
        circularBuffer.record(6);
        System.out.println(circularBuffer.printArray());//should return: [5, 6, 3, 4] <--- now the pointerToTheNextSlot is in array[2]
        System.out.println(circularBuffer.getLast(1));
        System.out.println(circularBuffer.getLast(2));
        System.out.println(circularBuffer.getLast(3));
        System.out.println(circularBuffer.getLast(4));

    }

    static class circularBuffer {
        private int size;
        private int[] array;
        private int pointerToCurrentSlot;
        private int pointerToTheNextSlot;

        circularBuffer(int size) {
            this.size = size;
            array = new int[size];
            pointerToCurrentSlot = 0;
            pointerToTheNextSlot = 0;
        }

        void record(int order_id) {
            if (array.length == size) {
                array[pointerToTheNextSlot] = order_id;
            } else {
                array[pointerToCurrentSlot] = order_id;
                pointerToCurrentSlot++;
            }
            pointerToTheNextSlot = (pointerToTheNextSlot + 1) % size;
        }

        int getLast(int i) {
            if (i <= size) {
                return (pointerToTheNextSlot - i >= 0) ? array[pointerToTheNextSlot - i] : array[size + (pointerToTheNextSlot - i)];
            } else {
                System.out.println("Out of bound");
                return -1;
            }
        }

        String printArray() {
            return Arrays.toString(array);
        }
    }
}
