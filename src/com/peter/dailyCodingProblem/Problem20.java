package com.peter.dailyCodingProblem;
/*
Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

A better example:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
*/


public class Problem20 {
    public static void main(String[] args) {
        //A = 3 -> 7 -> 8 -> 10
        LinkedList linkedListA = new LinkedList();
        linkedListA.head = new LinkedList.Node(3);
        LinkedList.Node secondA = new LinkedList.Node(7);
        LinkedList.Node thirdA = new LinkedList.Node(8);
        LinkedList.Node fourthA = new LinkedList.Node(10);
        linkedListA.head.next = secondA;
        secondA.next = thirdA;
        thirdA.next = fourthA;

        //B = 99 -> 1 -> 8 -> 10
        LinkedList linkedListB = new LinkedList();
        linkedListB.head = new LinkedList.Node(99);
        LinkedList.Node secondB = new LinkedList.Node(1);
        linkedListB.head.next = secondB;
        secondB.next = thirdA;

        System.out.println(findIntersectNodeForTwoSinglyLinkedLists(linkedListA, linkedListB));//should return 8
    }

    private static int findIntersectNodeForTwoSinglyLinkedLists(LinkedList l1, LinkedList l2) {//using 2 pointers
        int aLength = 0;
        int bLength = 0;
        LinkedList.Node currentA = l1.head;
        LinkedList.Node currentB = l2.head;
        //calculate length for both linked lists:
        while (currentA != null) {
            aLength++;
            currentA = currentA.next;
        }
        while (currentB != null) {
            bLength++;
            currentB = currentB.next;
        }

        currentA = l1.head;
        currentB = l2.head;
        if (aLength > bLength) {
            for (int i = aLength - bLength; i > 0; i--) {
                currentA = currentA.next;
            }
        } else {
            for (int i = bLength - aLength; i > 0; i--) {
                currentB = currentB.next;
            }
        }

        while (currentA != currentB) {
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return currentA.data;
    }

    static class LinkedList {
        Node head;

        static class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }
    }
}