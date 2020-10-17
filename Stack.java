package com.datastructure;

import java.util.Arrays;

public class Stack {
    private int size;
    private int loadFactor;
    private int topElement;
    private int arraySize;
    private int[] stack;
    private int initialCapacity;

    public Stack() {
        loadFactor = 7;
        topElement = -1;
        arraySize = 10;
        stack = new int[arraySize];
        initialCapacity = 10;
    }

    public Stack(int initialCapacity) {
        this.topElement = -1;
        this.arraySize = initialCapacity;
        this.stack = new int[arraySize];
        this.initialCapacity = initialCapacity;
    }

    public void push(int value) {
        if (size == loadFactor) {
            arraySize *= 2;
            loadFactor *= 2;
            stack = Arrays.copyOf(stack, arraySize);
        }
        stack[size++] = value;
        topElement = value;
    }

    public int peek() {
        return this.topElement;
    }

    public int pop() {
        int lastElement = topElement;
        stack[size-- - 1] = 0;
        topElement = stack[size - 1];
        return lastElement;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean search(int value) {
        for (int i = 0; i < size(); i++) {
            if (stack[i] == value)
                return true;
        }
        return false;
    }

    public int size() {
        if (isEmpty())
            return 0;
        return this.size;
    }

    public void clear() {
        this.stack = new int[initialCapacity];
        topElement = -1;
        size = 0;
    }

}
