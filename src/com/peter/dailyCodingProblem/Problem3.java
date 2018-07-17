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
                = new Node("root", new Node("left", new Node("left.left", null, null), null), new Node("right", null, null));

        String nodeString = Solution.serialize(testNode);
        //System.out.println(nodeString);
        String result = Solution.deserialize(nodeString).left.left.val;
        System.out.println(result);// should return "left.left"
    }

    public static class Solution {
        static final String separator = ",";

        // Encodes a tree to a single string.
        static String serialize(Node root) {
            if (root == null) {
                return "null";
            }
            return root.val + separator + serialize(root.left) + separator + serialize(root.right);
        }

        // Decodes your encoded data to tree.
        static Node deserialize(String data) {
            String[] temp = data.split(separator);
            return deserializeStringArray(temp, new int[]{0});
        }

        private static Node deserializeStringArray(String[] temp, int[] index) {
            if (index[0] > temp.length || temp[index[0]].equals("null")) {
                index[0]++;
                return null;
            }
            return new Node(temp[index[0]++], deserializeStringArray(temp, index), deserializeStringArray(temp, index));
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
