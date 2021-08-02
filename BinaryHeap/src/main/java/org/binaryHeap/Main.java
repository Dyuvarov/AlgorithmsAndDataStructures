package org.binaryHeap;

import java.sql.SQLOutput;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<Integer>(Comparator.naturalOrder());
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(-1);
        minHeap.insert(9999);
        minHeap.insert(Integer.MIN_VALUE);
        minHeap.insert(Integer.MAX_VALUE);


        while (minHeap.size() > 0) {
            System.out.println("size: " + minHeap.size() + " min: " + minHeap.getMin());
            minHeap.deleteMin();
        }

        System.out.println("***********************************************");

        MaxHeap<Integer> maxHeap = new MaxHeap<>(Comparator.naturalOrder());
        maxHeap.insert(0);
        maxHeap.insert(Integer.MIN_VALUE);
        maxHeap.insert(888);
        maxHeap.insert(-42);
        maxHeap.insert(101);
        maxHeap.insert(Integer.MAX_VALUE);


        while (maxHeap.size() > 0) {
            System.out.println("size: " + maxHeap.size() + " max: " + maxHeap.getMax());
            maxHeap.deleteMax();
        }
    }
}
