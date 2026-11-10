package com.example.trai.VKO_3;

import java.util.LinkedList;

public interface TRAI_26_X3 {


    /**
     * Add new elements to a sorted list.
     * Adds to list A such elements of B that are not in A originally.
     * Boths lists are sorted and the list A also remains sorted.
     * @param A sorted list to which elements are added
     * @param B sorted list whose elements are added if they are not originally in list A
     * @param <E> element type
     */
    public <E extends Comparable<? super E>> void addNew(LinkedList<E> A, LinkedList<E> B);

}