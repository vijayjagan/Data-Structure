package com.company;

public class MyLinkedList {
    class Node {
        public int value;
        public Node nextNode;
    }

    private int size;
    private Node head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node node = getNodeAt(index);
        return node == null ? -1 : node.value;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node();
        node.value = val;
        node.nextNode = head;
        this.head = node;
        this.size += 1;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
            size++;
            return;
        }
        Node node = getNodeAt(size - 1);
        Node tailNode = new Node();
        tailNode.value = val;
        node.nextNode = tailNode;
        this.size += 1;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (this.size < index)
            return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node node = getNodeAt(index - 1);
        Node newNode = new Node();
        newNode.value = val;
        newNode.nextNode = node.nextNode;
        node.nextNode = newNode;
        this.size += 1;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (this.size <= index)
            return;
        if (index == 0) {
            deleteHeadNode();
            return;
        }
        Node node = getNodeAt(index - 1);
        if (size-- == index) {
            node.nextNode = null;
            // Last Node will be remove Due to garbage collection
            return;
        }
        node.nextNode = node.nextNode.nextNode;
    }

    public Node getNodeAt(int index) {
        if (head == null || this.size <= index)
            return null;
        Node node = this.head;
        for (int i = 0; i < index; i++)
            if (node.nextNode != null)
                node = node.nextNode;
        return node;
    }

    public void deleteHeadNode() {
        this.head = head.nextNode;
        size--;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += get(i);
            if (i != size - 1)
                result += ",";
        }
        return result + "]";
    }
}
