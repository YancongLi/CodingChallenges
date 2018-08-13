package com.peter.dailyCodingProblem;

/*
Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.

Example:
Given linked list: 1->2->3->4->5, and k = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

*/
public class Problem26 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = node1;
        while (head != null) {
            System.out.print(head.val);
            System.out.print(head.next == null ? "" : "->");
            head = head.next;
        }// should return: 1->2->3->4->5
        head = node1;
        removeKthFromEnd(head, 2);
        System.out.println();
        head = node1;
        while (head != null) {
            System.out.print(head.val);
            System.out.print(head.next == null ? "" : "->");
            head = head.next;
        }// should return: 1->2->3->5
    }

    private static ListNode removeKthFromEnd(ListNode head, int k) {
        ListNode tempNode = new ListNode(666);
        tempNode.next = head;
        ListNode second = tempNode;
        ListNode first = tempNode;
        for (int i = 1; i <= k + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return tempNode.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
