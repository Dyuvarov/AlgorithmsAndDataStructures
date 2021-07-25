package org.binaryHeap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
A Binary Heap is a Binary Tree with following properties.
1) It’s a complete tree
 (All levels are completely filled except possibly the last level and the last level has all keys as left as possible).
 This property of Binary Heap makes them suitable to be stored in an array.
2) A Binary Heap is either Min Heap or Max Heap.
 In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap.
 The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to MinHeap.

 Elements stores in ArrayList:
 Parent of i-th element: (i - 1) / 2
 Left element:           (i * 2) + 1
 Right element:          (i * 2) + 2
 */
public abstract class BinHeap<T> {
    protected List<T>       values;
    protected Comparator    comparator;

    BinHeap(Integer size, Comparator comparator){
        values = new ArrayList<T>(size);
        this.comparator = comparator;
    }

    BinHeap(Comparator comparator) {
        values = new ArrayList<T>();
        this.comparator = comparator;
    }

    protected Integer parent(Integer index){
        if (index == 0)
            return null;
        return (index - 1) / 2;
    }

    protected Integer left(Integer index) throws IndexOutOfBoundsException {
        return index * 2 + 1;
    }

    protected Integer right(Integer index) throws IndexOutOfBoundsException {
        return index * 2 + 2;
    }

    /**
     *
     * @return number of elements in heap
     */
    public Integer size() {
        return values.size();
    }

    public abstract void insert(T value);

    public abstract void delete(T value);

    /**
     * Puts root element to the correct place.
     */
    protected abstract void balanceTree(Integer rootIndex);

}
