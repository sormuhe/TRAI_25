package com.example.trai.VKO_2;

import java.util.ArrayList;
import java.util.Iterator;

public class TRAI_26_X2_sormuhei implements TRAI_26_X2 {
    //                  ^^^^^
    //             own userid here

    /**
     * SELF-EVALUATION HERE:
     *
     *
     *
     */


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
    @Override
    public ArrayList<Integer> unionOfSortedLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        ArrayList<Integer> result = new ArrayList<>();

        Iterator<Integer> iterA = list1.iterator();
        Iterator<Integer> iterB = list2.iterator();

        /*
        jos lista1 on tyhjä, lisää lista 2
        jos lista 2 on tyhjä, lisää lista1

        jos i <= j
        lisää i,
        kasvata i
        muuten lisää j
        kasvata j

        while true
        jos i >= listan koko
        jos lista2 j equals result get sice -1
        add j
        j++


        jos j >= list 2 size
            niin kauan kun i < list1 size
            i equals tulos get result size -1
            break

        jos i <= j --> tulokseen i ja kasvata i
        muuten lisää j



         */


        // Tarkistetaan, ovatko listat tyhjiä
        if (!iterA.hasNext()) {
            return new ArrayList<>(list2);
        }
        if (!iterB.hasNext()) {
            return new ArrayList<>(list1);
        }

        int i  = iterA.next();
        int j = iterB.next();

        while (true) {

            if (i < j ) {
                if (result.isEmpty() || result.get(result.size() - 1) != i) {
                    result.add(i);
                }

            } else if (j < i) {
                if (result.isEmpty() || result.get(result.size() - 1) != j) {
                    result.add(j);
                }

                if (iterB.hasNext()) {
                    j = iterB.next();
                } else {
                    if (result.isEmpty() || result.get(result.size() - 1) != i) {
                        result.add(i);
                    }

                    if (iterA.hasNext() && iterB.hasNext()) {
                        i = iterA.next();
                        j = iterB.next();
                    } else {
                        break;
                    }
                }
            }}

        // use the fact that the lists are in ascending order _already_ in the plan!

        return result;
    }

}