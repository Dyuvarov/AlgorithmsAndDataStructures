package org.binaryHeap;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Time;
import java.util.Comparator;
import java.util.Random;

public class minHeapTest {


    /** Check that heap contains the values in correct order:
     * root less than left and right values
     * @param heap - minHeap to be checked
     * @return true if order is correct, else return false
     */
    private boolean checkOrder(MinHeap heap){
        boolean wrongOrder = false;
        for (int i = 0; i < heap.size(); i++) {
            int left = heap.left(i);
            int right = heap.right(i);
            if (left < heap.size()) {
                if (heap.comparator.compare(heap.values.get(left), heap.values.get(i)) < 0) {
                    wrongOrder = true;
                    System.out.println("Error on " + i);
                    break ;
                }
            }
            if (right < heap.size()) {
                if (heap.comparator.compare(heap.values.get(right), heap.values.get(i)) < 0) {
                    wrongOrder = true;
                    System.out.println("Error on " + i);
                    break;
                }
            }
        }
        return !wrongOrder;
    }

    @Test
    public void TestOrderIntHeap() {
        MinHeap<Integer> bigInt = new MinHeap<>(Comparator.naturalOrder());
        Random rnd = new Random();
        for (int i = 0; i < 1000000; i++) {
            bigInt.insert(rnd.nextInt());
        }
         Assert.assertTrue(checkOrder(bigInt));
    }

    @Test
    public void TestOrderDoubleHeap() {
        MinHeap<Double> bigDouble = new MinHeap<>(Comparator.naturalOrder());
        Random rnd = new Random();
        for (int i = 0; i < 1000000; i++) {
            bigDouble.insert(rnd.nextDouble());
        }
        Assert.assertTrue(checkOrder(bigDouble));
    }

    @Test
    public void TestOrderStringHeap() {
        MinHeap<String> bigString = new MinHeap<>(Comparator.naturalOrder());
        Random rnd = new Random();
        for (int i = 0; i < 1000000; i++) {
            byte[] alphabet = new byte[10];
            rnd.nextBytes(alphabet);
            bigString.insert(new String(alphabet));
        }
        Assert.assertTrue(checkOrder(bigString));
    }

    @Test
    public void TestDeleteMin() {
        //empty heap
        MinHeap<Integer> heap =  new MinHeap<>(0, Comparator.naturalOrder()); //create empty heap
        heap.deleteMin();
        Assert.assertEquals(heap.size(), Integer.valueOf(0));

        //heap with same values
        heap = new MinHeap<>(Comparator.naturalOrder());
        for (int i = 0; i < 999; i++)
            heap.insert(42);
        for (int i = 0; i < 999; i++)
            heap.deleteMin();

        Assert.assertEquals(heap.size(), Integer.valueOf(0));

        //Usual test
        heap = new MinHeap<>(Comparator.naturalOrder());
        Random rnd = new Random();
        for (int i = 0; i < 999; i++) {
            heap.insert(rnd.nextInt());
        }

        for (int i = 0; i < 999; i++) {
            Integer oldSize = heap.size();
            heap.deleteMin();

            Assert.assertTrue(oldSize - 1 == heap.size());
        }


    }
}
