package com.example.trai.VKO_2;
import java.util.ArrayList;

public interface TRAI_25_X2 {

    /**
     * Difference of two lists that are in ascending order.
     *
     * Returns a new list that contains all the elements that are in list A and in list B,
     * If an element is in A and B several times, it will be in the result list as many times
     * as in the list that has fewer occurences.
     * Result list will be in ascending order.
     * If either of the lists is not in ascending order, result can be anything.
     * @param A first input list, elements in ascending order
     * @param B second input list, elements in ascending order
     * @return intersection list, elements in ascending order
     */
    ArrayList<Integer> intersectionOfGrowingLists(ArrayList<Integer> A, ArrayList<Integer> B);

}