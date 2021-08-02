package org.binaryHeap;

import java.util.Collections;
import java.util.Comparator;

public class MaxHeap<T> extends BinHeap<T>{
    MaxHeap(Integer size, Comparator comparator) {
        super(size, comparator);
    }

    MaxHeap(Comparator comparator) {
        super(comparator);
    }

    /**
     * @return max (first) element
     */
    public T getMax() {
        if (size() == 0)
            return null;

        return values.get(0);
    }

    /**
     * Add new element to the heap
     * @param value: value to be added
     */
    @Override
    public void insert(T value) {
        values.add(value);
        int i = values.size()-1;
        while (i != 0 && comparator.compare(values.get(i), values.get(parent(i))) > 0) {
            Collections.swap(values, i, parent(i));
            i = parent(i);
        }
    }

    /**
     * Delete max (first) element
     */
    public void deleteMax() {
       if (size() > 0) {
           Collections.swap(values, 0, values.size() - 1);  //before deleting max(first) element, swap it with last
           values.remove(size() - 1);                      //remove max element from heap
           balanceTree(0);
       }
    }

    /**
     * Delete element with value 'value'
     * @param value - value to be deleted
     */
    @Override
    public void delete(T value) {
        int index = values.indexOf(value);
        if (index < 0)
            return;

        putValueOnTop(index);

        deleteMax();
    }

    /**
     * Puts root element to the correct place recursively.
     */
    @Override
    protected void balanceTree(Integer rootIndex) {
        int left = left(rootIndex);
        int right = right(rootIndex);
        int biggest = rootIndex;

        if (left < size() && comparator.compare(values.get(left), values.get(biggest)) > 0)
            biggest = left;
        if (right < size() && comparator.compare(values.get(right), values.get(biggest)) > 0)
            biggest = right;
        if (biggest != rootIndex) {
            Collections.swap(values, biggest, rootIndex);
            balanceTree(biggest);
        }
    }
}
