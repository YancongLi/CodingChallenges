package com.peter.dailyCodingProblem;

/*
A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1

*/

public class Problem8 {
    public static void main(String[] args) {
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(0);
        Node node3 = new Node(1);
        Node node4 = new Node(0);
        Node node5 = new Node(1);
        Node node6 = new Node(1);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node1.right = node6;

        System.out.println(countUnivalSubtrees(root)); // should return 5

    }

    public static class Node {
        int value;
        Node left, right;

        Node(int val) {
            value = val;
            left = right = null;
        }
    }

    private static boolean isUnival(Node root) {
        return univalHelper(root, root.value);
    }

    private static boolean univalHelper(Node root, int value) {
        if (root == null) {
            return true;
        }

        if (root.value == value) {
            return univalHelper(root.left, value) && univalHelper(root.right, value);
        }

        return false;
    }

    private static int countUnivalSubtrees(Node root) {
        if (root == null) {
            return 0;
        }
        int left = countUnivalSubtrees(root.left);
        int right = countUnivalSubtrees(root.right);
        if (isUnival(root)) {
            return 1 + left + right;
        } else {
            return left + right;
        }
    }

}
