package com.peter.dailyCodingProblem;
/*
Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

is_locked, which returns whether the node is locked
lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
You may augment the node to add parent pointers or any other property you would like. You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. Each method should run in O(h), where h is the height of the tree.
*/
public class Problem24 {
    public static void main(String[] args) {
        TreeNodeWithLock node1= new TreeNodeWithLock(1);
        TreeNodeWithLock node2 = new TreeNodeWithLock(2);
        TreeNodeWithLock node3 = new TreeNodeWithLock(3);
        TreeNodeWithLock node4 = new TreeNodeWithLock(4);
        TreeNodeWithLock node5 = new TreeNodeWithLock(5);

        buildATestTree(node1, node2, node3, node4, node5);

        testOutputs(node1, node2, node3, node4, node5);
    }

    private static void testOutputs(TreeNodeWithLock node1, TreeNodeWithLock node2, TreeNodeWithLock node3, TreeNodeWithLock node4, TreeNodeWithLock node5) {
        System.out.println(node3.isLocked());//should return false
        System.out.println(node3.lock());    //should return true
        System.out.println(node3.isLocked());//should return true
        System.out.println(node1.lock());    //should return false
        System.out.println(node1.unlock());  //should return false
        System.out.println(node4.lock());    //should return false
        System.out.println(node4.unlock());  //should return false
        System.out.println(node5.lock());    //should return false
        System.out.println(node5.unlock());  //should return false
        System.out.println(node2.lock());    //should return true
        System.out.println(node3.unlock());  //should return true
    }

    private static void buildATestTree(TreeNodeWithLock node1, TreeNodeWithLock node2, TreeNodeWithLock node3, TreeNodeWithLock node4, TreeNodeWithLock node5) {
        node1.leftNode = node2;
        node2.parentNode = node1;
        node1.rightNode = node3;
        node3.parentNode = node1;
        node3.leftNode = node4;
        node4.parentNode = node3;
        node3.rightNode = node5;
        node5.parentNode = node3;
    }

    static class TreeNodeWithLock {
        private int data;
        private boolean isLocked;
        TreeNodeWithLock leftNode;
        TreeNodeWithLock rightNode;
        TreeNodeWithLock parentNode;
        private int numOfLockedDescendants = 0;

        TreeNodeWithLock(int value) {
            this.data = value;
        }

        boolean isLocked() {
            return this.isLocked;
        }

        private boolean canLockOrUnlock() {
            if (numOfLockedDescendants > 0) {
                return false;
            }
            TreeNodeWithLock nodePointer = this.parentNode;
            while (nodePointer != null) {
                if (nodePointer.isLocked()) {
                    return false;
                }
                nodePointer = nodePointer.parentNode;
            }
            return true;
        }
        boolean lock() {
            if (this.isLocked) {
                return false;
            }
            if (!canLockOrUnlock()) {
                return false;
            }
            this.isLocked = true;
            increaseNumOfDescendantsByOneForParentNodes();
            return true;
        }

        boolean unlock(){
            if (!this.isLocked) {
                return false;
            }
            if (!canLockOrUnlock()) {
                return false;
            }
            this.isLocked = false;
            decreaseNumOfDescendantsByOneForParentNodes();
            return true;
        }

        private void increaseNumOfDescendantsByOneForParentNodes() {
            TreeNodeWithLock nodePointer = this.parentNode;
            while (nodePointer != null) {
                nodePointer.numOfLockedDescendants ++;
                nodePointer = nodePointer.parentNode;
            }
        }

        private void decreaseNumOfDescendantsByOneForParentNodes() {
            TreeNodeWithLock nodePointer = this.parentNode;
            while(nodePointer!= null) {
                nodePointer.numOfLockedDescendants--;
                nodePointer = nodePointer.parentNode;
            }
        }
    }
}
