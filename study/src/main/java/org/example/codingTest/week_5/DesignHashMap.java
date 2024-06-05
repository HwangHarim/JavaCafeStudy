package org.example.codingTest.week_5;

public class DesignHashMap {
    static class Node {
        int key;
        int val;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }

    Node[] nodes = new Node[100000];

    public DesignHashMap() {

    }

    public void put(int key, int value) {
        int index = key % nodes.length;

        if (nodes[index] == null) {
            nodes[index] = new Node(key, value);
            return;
        }

        Node node = nodes[index];

        while (node != null) {
            if (node.key == key) {
                node.val = value;
                return;
            }

            if (node.next == null) {
                break;
            }
            node = node.next;
        }
        node.next = new Node(key, value);
    }

    public int get(int key) {
        int index = key % nodes.length;
        if (nodes[index] == null) {
            return -1;
        }
        Node node = nodes[index];
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }

        return -1;
    }

    public void remove(int key) {

        int index = key % nodes.length;

        if (nodes[index] == null) {
            return;
        }

        Node node = nodes[index];
        if (node.key == key) {
            if (node.next == null) {
                nodes[index] = null;
            } else {
                nodes[index] = node.next;
            }
        }

        Node prev = node;
        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                return;
            }

            prev = node;
            node = node.next;
        }
    }
}
