package com.example.trai.VKO_3;
import java.util.LinkedList;
import java.util.ListIterator;

public class TRAI_26_X3_sormuhei implements TRAI_26_X3 {
    //                  ^^^^^ own userid here

    /**
     * SELF-EVALUATION HERE:
     * Tehtävä ei toimi oikein, eikä se lisää siis kaikkia alkioita oikein listaan.
     *
     * Jossain vaiheessa toimi melkein oikein.
     * Aika loppui kesken.
     *
     *
     */


    /**
     * Add new elements to a sorted list.
     * Adds to list A such elements of B that are not in A originally.
     * Boths lists are sorted and the list A also remains sorted.
     * @param A sorted list to which elements are added
     * @param B sorted list whose elements are added if they are not originally in list A
     * @param <E> element type
     */
    @Override
    public <E extends Comparable<? super E>> void addNew(LinkedList<E> A, LinkedList<E> B) {

        // TODO
        // hints: adding to A is fast using an iterator, A and B are sorted

        ListIterator<E> listIteratorA = A.listIterator();
        ListIterator<E> listIteratorB = B.listIterator();

            // Jos A on tyhjä, lisätään kaikki B:n alkiot.
        if (!listIteratorA.hasNext()) {
            while (listIteratorB.hasNext()) {
                listIteratorA.add(listIteratorB.next());
            }
            return;
        }

        while (listIteratorB.hasNext()) {

            E arvoB = listIteratorB.next();
            boolean lisatty = false;

            while (listIteratorA.hasNext()) {

                E arvoA = listIteratorA.next();

                if (arvoA.compareTo(arvoB) > 0) {
                    listIteratorA.previous();
                    listIteratorA.add(arvoB);
                    lisatty = true;
                    break;

                } else if (arvoA.compareTo(arvoB) == 0) {
                    listIteratorA.previous();
                    lisatty = true;
                    break;
                }
            }

            if (!lisatty) {
                listIteratorA.add(arvoB);
            }
        }
    }
}



