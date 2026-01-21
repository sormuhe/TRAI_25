package com.example.trai.VKO_3;

import java.util.LinkedList;

public interface TRAI_25_X3 {


    /**
     * Combination of two sorted lists.
     *
     * @param A   First list. In ascending order.
     * @param B   Second list. In ascending order.
     * @param <E> element type
     * @return All the elements of A and B, in ascending order.
     */
    public <E extends Comparable<? super E>> LinkedList<E> combinationOfSorted(LinkedList<E> A, LinkedList<E> B);

}