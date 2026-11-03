package com.example.trai.VKO_2;

import java.util.ArrayList;

public interface TRAI_26_X2 {


    /**
     * Union of two lists that are in ascending order.
     *
     * Returns a new list that contains all the elements that are in list1 and/or in list1,
     * Each element will be in result list only once, even it is in list1 and/or list2
     * several times.
     * The result list will be in ascending order.
     * If either of the lists is not in ascending order, the result can be anything.
     * @param list1 first input list, elements in ascending order
     * @param list2 second input list, elements in ascending order
     * @return intersection list, elements in ascending order
     */

    ArrayList<Integer> unionOfSortedLists(ArrayList<Integer> list1, ArrayList<Integer> list2);

}