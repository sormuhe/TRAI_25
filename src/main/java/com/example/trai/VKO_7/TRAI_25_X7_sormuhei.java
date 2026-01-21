
package com.example.trai.VKO_7;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of interface TRAI_25_X7 which is the sama as interface Queue.
 * Inherits a lot of basic functionality from AbstractQueue and interface TRAI_25_X7.
 * @param <E> Element type.
 */
public class TRAI_25_X7_sormuhei<E> extends AbstractQueue<E> implements TRAI_25_X7<E>, Iterable<E>  {
    //                    ^^^^^
    //                own userid here

    /**
     * SELF-EVALUATION HERE:
     * Aika oli äärimmäisen liukuva käsite tällä viikolla, ja selitys on huonokin selitys.
     * Töiden ja (TRAn) kertauksen vuoksi jäi tämä viikko todella huonolle huomiolle.
     * Joten en saanut tehtyä mitään, panostus oli olematon.
     */

    // TODO


    public void AbstractQueue() {
        // ???
    }


    // Use either array (E[] data)
    // or use dynamic linked implementation by introducing an inner
    // class (QueueNode, etc.) and use references to those nodes.

    /**
     * Create a new empty queue.
     */
    public TRAI_25_X7_sormuhei() {
        // TODO

        AbstractQueue<E> uusiJono = new AbstractQueue<>() {
            public boolean offer(E e) {
                return false;
            }

            public E poll() {
                return null;
            }

            public E peek() {
                return null;
            }

            public Iterator<E> iterator() {
                return null;
            }

            public int size() {
                return 0;
            }
        };
    }

    /**
     * Adds an element to the tail of the queue.
     * @param x element to add
     * @return true
     */
    @Override
    public boolean offer(E x) {
        // TODO





        return false;
    }

    /**
     * Removes and returns the head of the queue.
     * @throws NoSuchElementException if queue was empty
     * @return element that was removed
     */
    @Override
    public E remove() {
        // TODO
        return null;
    }

    /**
     * Returns but does not remove the head of the queue.
     * @return the head of the queue, or null if the queue was empty.
     */
    @Override
    public E peek() {
        // TODO
        return null;
    }

    /**
     * Number of elements currently in the queue.
     * @return number of elements
     */
    @Override
    public int size() {
        // TODO
        return 0;
    }


    /**
     * Returns a String representation of the queue.
     *
     * This is for task 31.
     * But keep this when submitting task X7
     * It is not tested in X7.
     *
     * @return a string showing the direction and content of the queue.
     */
    @Override
    public String toString() {
        // TODO
        return "";
    }



    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * This is for task 32.
     * But keep this when submitting task X7
     * It is not tested in X7.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        // TODO
        return null;
    }



}
