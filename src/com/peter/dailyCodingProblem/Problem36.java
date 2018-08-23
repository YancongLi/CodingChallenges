package com.peter.dailyCodingProblem;

/*
Given the root to a binary search tree, find the second largest node in the tree.
*/
public class Problem36 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        /*
        Create following BST:
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80
       */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println(tree.secondLargest(tree.root));//should return 70
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    private static class BinarySearchTree {
        Node root;
        int count;
        int secondLargest;

        private BinarySearchTree() {
            root = null;
        }

        private void insert(int data) {
            this.root = this.insertRec(this.root, data);
        }

        Node insertRec(Node node, int data) {
            if (node == null) {
                this.root = new Node(data);
                return this.root;
            }

            if (data < node.data) {
                node.left = this.insertRec(node.left, data);
            } else {
                node.right = this.insertRec(node.right, data);
            }
            return node;
        }

        private int secondLargest(Node root) {
            this.count = 0;
            reverseInorder(root);
            return this.secondLargest;
        }

        private void reverseInorder(Node root) {
            if (root == null || this.count >= 2) {
                return;
            }
            reverseInorder(root.right);

            this.count++;
            if (this.count == 2) {
                this.secondLargest = root.data;
                return;
            }
            reverseInorder(root.left);
        }
    }
}
