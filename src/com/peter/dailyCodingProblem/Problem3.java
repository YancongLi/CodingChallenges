package com.peter.dailyCodingProblem;

/*

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserialize(s) the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'

*/

public class Problem3 {
    public static void main(String[] args) {
        Node testNode
                = new Node("root", new Node("left", new Node("left.left", null, null), null), new Node("right", null , null));

        String nodeString =  Solution.serialize(testNode);
        System.out.println(nodeString);
        String result = Solution.deserialize(nodeString).left.left.val;
        System.out.println(result);// should return "left.left"
    }

    public static class Solution {
        // Encodes a tree to a single string.
        static String serialize(Node root) {
            return "";
        }

        // Decodes your encoded data to tree.
        static Node deserialize(String data) {
            return new Node("", null, null);
        }
    }

    public static class Node {
        String val;
        Node left, right;

        Node(String value, Node left, Node right) {
            this.val = value;
            this.left = left;
            this.right = right;
        }
    }
}
