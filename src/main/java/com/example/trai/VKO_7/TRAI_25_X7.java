package com.example.trai.VKO_7;

import java.util.Queue;

/**
 * Implementation of a Queue. Oldest element will be removed first (FIFO)
 * @param <E> Element type
 */

// implementing Iterable is part of task 32, but keep this here anyway.
// the skeleton has a ready "implementation"
public interface TRAI_25_X7<E> extends Queue<E>   {


    // The operations that you need to implement in X7:


    /**
     * Adds an element to the tail of the queue.
     *
     * @param x element to add
     * @return true
     */
    public boolean offer(E x);


    /**
     * Removes and returns the head of the queue
     * @throws java.util.NoSuchElementException if queue was empty
     * @return element that was removed
     */
    public E remove();


    /**
     * Returns but does not remove the head of the queue.
     * @return the head of the queue, or null if the queue was empty.
     */
    public E peek();

    /**
     * Number of elements currently in the queue.
     * @return number of elements
     */
    public int size();



    // Other methods of the Queue interface, no need to implement in X7:

    /**
     * Adds an element to the tail of the queue.
     *
     * @param x element to add
     * @return true
     */
    default boolean add(E x) {
        return offer(x);
    }


    /**
     * Removes and returns the head of the queue
     * @return element that was removed, or null if the queue was empty.
     */
    public default E poll() {
        if (isEmpty())
            return null;
        else
            return remove();
    }

    /**
     * Returns but does not remove the head of the queue.
     * @throws java.util.NoSuchElementException if queue was empty
     * @return the head of the queue
     */
    public default E element() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("Queue is empty");
        else
            return peek();
    }


    /**
     * Is queue empty or not?
     * @return true if this queue is empty, false otherwise
     */
    public default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Empties the queue.
     * This can be made more efficiently in the implementing class as soon
     * as the implementation is ready.
     * Not need to do it.
     */
    public default void clear() {
        while (! isEmpty())
            remove();
    }

    public default boolean contains(Object o) {
        throw  new UnsupportedOperationException("Not needed in X7.");
    }


}
