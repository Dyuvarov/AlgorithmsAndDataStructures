package org.binaryHeap;

import java.util.Collections;
import java.util.Comparator;


public class MinHeap<T> extends BinHeap<T>{

    public MinHeap(Comparator comparator){ super(comparator); }

    public MinHeap(Integer size, Comparator comparator) {super(size, comparator); }

    /**
     * @return min (first) element
     */
    public T getMin() {
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
        while (i != 0 && comparator.compare(values.get(parent(i)), values.get(i)) > 0) {
            Collections.swap(values, parent(i), i);
            i = parent(i);
        }
    }

    /**
     * Delete min (first) element
     */
    public void deleteMin() {
        if (size() > 0) {
            Collections.swap(values, 0, values.size() -1);  //before deleting min(first) element, swap it with last
            values.remove(values.size() - 1);              //remove min element from heap
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

        while (index != 0) {
            int pInd = parent(index);
            Collections.swap(values, index, pInd);
            index = pInd;
        }
        deleteMin();
    }

    /**
     * Puts root element to the correct place recursively.
     */
    @Override
    protected void balanceTree(Integer rootIndex) {
        int left = left(rootIndex);
        int right = right(rootIndex);
        int smallest = rootIndex;

        if (left < size() && comparator.compare(values.get(left), values.get(smallest)) < 0)
            smallest = left;
        if (right < size() && comparator.compare(values.get(right), values.get(smallest)) < 0)
            smallest = right;
        if (smallest != rootIndex) {
            Collections.swap(values, smallest, rootIndex);
            balanceTree(smallest);
        }
    }


}
