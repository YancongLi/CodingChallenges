package com.peter.dailyCodingProblem;

/*
An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

If using a language that has no pointers (such as Python), you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.

hint: XOR means the output is "false" if both inputs are "false" or if both inputs are "true." Otherwise, return "true".
*/

import java.util.ArrayList;

public class Problem6 {
    public static void main(String[] args) {
    }

    class Node {
        int xor;
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }

    class xorLinkedList {
        Node head;
        Node tail;
        ArrayList<Node> nodeArray = new ArrayList<>(); //This is to prevent garbage collection

        public void add(Node node) {
            if (head == null) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.xor = this.tail.xor ^ System.identityHashCode(node);
                node.xor = System.identityHashCode(node);
                this.tail = node;
            }
            nodeArray.add(node);
        }

        public Node get(int index) {
            int prev_id = 0;
            int next_id = 0;
            Node node = head;
            if (node == null) {
                System.out.println("This xor linked list is empty.");
            }
            for (int i = 0; i < index; i++) {
                next_id = prev_id ^ (node.xor);
                if (next_id != 0) {
                    prev_id = node.xor;
                    node = getObjectFromMemory(next_id);
                } else {
                    System.out.println("Index out of bound.");
                }
            }
            return node;
        }

        private Node getObjectFromMemory(int next_id) {
            return null; //Unfortunately, in java, you can't get an object using memory reference id.
            //However, in python, you can do this:
        /*
        code:
        import ctypes
        a = "hello world"
        print ctypes.cast(id(a), ctypes.py_object).value

        output:
        hello world
        */
        }
    }

}


//Python solution:
/*
import ctypes

# This is hacky. It's a data structure for C, not python.
class Node(object):
    def __init__(self, val):
        self.val = val
        self.both = 0


class XorLinkedList(object):
    def __init__(self):
        self.head = self.tail = None
        self.__nodes = [] # This is to prevent garbage collection

    def add(self, node):
        if self.head is None:
            self.head = self.tail = node
        else:
            self.tail.both = id(node) ^ self.tail.both
            node.both = id(self.tail)
            self.tail = node

        # Without this line, Python thinks there is no way to reach nodes between
        # head and tail.
        self.__nodes.append(node)


    def get(self, index):
        prev_id = 0
        node = self.head
        for i in range(index):
            next_id = prev_id ^ node.both

            if next_id:
                prev_id = id(node)
                node = _get_obj(next_id)
            else:
                raise IndexError('Linked list index out of range')
        return node


def _get_obj(id):
    return ctypes.cast(id, ctypes.py_object).value
*/