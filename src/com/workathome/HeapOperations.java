package com.workathome;

import java.util.Objects;

public class HeapOperations {

    public static <E extends Comparable<E>> Heap<E> buildMinHeap(E[] elements) {

        Heap<E> heap = new Heap<>();
        for(E elem : elements) {
            heap.add(elem);
        }
        return heap;
    }

    public static <E extends Comparable<E>> Object[] sort(E[] elements) {
        Heap<E> heap = buildMinHeap(elements);
        Object[] result = new Object[elements.length];
        int index = 0;
        while(Objects.nonNull(heap.peek())) {
            result[index++] = heap.poll();
        }
        return  result;
    }
}
