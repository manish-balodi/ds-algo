package com.workathome;

import java.util.Arrays;

public class Heap<T extends Comparable<T>> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ITEMS = {};

    private Object[] items;

    private int size;

    private int capacity;

    public Heap(int initialCapacity) {
        if (initialCapacity > 0) {
            this.items = new Object[initialCapacity];
            this.capacity = initialCapacity;
        } else if (initialCapacity == 0) {
            this.items = EMPTY_ITEMS;
        } else {
            throw new IllegalArgumentException(String.format("Illegal Capacity: %s ", initialCapacity));
        }
    }

    public Heap() {
        this(DEFAULT_CAPACITY);
    }

    public Object[] getItems() {
        return items;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private boolean hasLeftChild(int index) {

        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {

        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private T getLeftChild(int parentIndex) {
        return (T) items[getLeftChildIndex(parentIndex)];
    }

    private T getRightChild(int parentIndex) {
        return (T) items[getRightChildIndex(parentIndex)];
    }

    private T getParent(int index) {
        return (T) items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        T temp = (T) items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    public T poll() {
        if (size == 0) return null;
        T root = (T) items[0];
        items[0] = items[size - 1];
        items[size - 1] = null;
        size--;
        heapifyDown();
        return root;
    }

    public T peek() {
        if (size == 0) return null;
        return (T) items[0];
    }

    public void add(T item) {
        ensureInternalCapacity();
        items[size++] = item;
        heapifyUp();
    }

    private void ensureInternalCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity = capacity * 2;
        }
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index).compareTo((T) items[index]) > 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {

        int index = 0;
        while (hasLeftChild(index)) {
            int smallChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index).compareTo(getLeftChild(index)) < 0) {
                smallChildIndex = getRightChildIndex(index);
            }
            if (((Comparable<T>) items[index]).compareTo((T) items[smallChildIndex]) < 0) {
                break;
            } else {
                swap(index, smallChildIndex);
            }
            index = smallChildIndex;
        }
    }
}
