package com.example.trai.VKO_6;

/**
 * Peek stack: stack with access to second topmost element.
 * @param <E> element type
 */
public interface TRAI_25_t30<E> {

    /**
     * Is stack empty
     * @return true if stack has no elements, false otherwise.
     */
    public default boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * Number of elements.
     * @return number of elements.
     */
    public int size();

    /**
     * Add element x to stack
     *
     * @param x element to add.
     */
    public void push(E x);

    /**
     * Topmost element.
     * @return topmost element.
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public E top();

    /**
     * Second element.
     * @return second element.
     * @throws java.util.NoSuchElementException if stack has less than two elements.
     */
    public E top2();

    /**
     * Removes topmost element.
     * @return topmost element.
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public E pop();

    /**
     * Removes second element.
     * @return second element.
     * @throws java.util.NoSuchElementException if stack has less than two elements
     */
    public E pop2();

}
