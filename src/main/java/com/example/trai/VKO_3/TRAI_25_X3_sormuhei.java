package com.example.trai.VKO_3;

import java.util.LinkedList;
import java.util.ListIterator;

public class TRAI_25_X3_sormuhei implements TRAI_25_X3 {
    //                        ^^^^^
    //                   own userid here

    /**
     * SELF-EVALUATION HERE:
     *
     * Yritin suunnitella parhaani mukaan aluksi kuinka olisi hyvä edetä.
     * Kuitenkaan suunnitelmani ei taipunut hyvin koodiksi,
     * ja jouduin muutamaan paljon ajatteluani.
     * Lopulta vertaisen kanssa ja ohjauksella sain koodin toimimaan.
     * Olin ajatellut koodin liian vaikeasti, ja koodini ei toiminut sen vuoksi.
     * Koodissani oli kokonainen lohko liikaa, koska en ymmärtänyt sitä,
     * että sitä ei tarvita ollenkaan.
     *
     */


    /**
     * Add all elements to a sorted list.
     *
     * @param A   First list. In ascending order.
     * @param B   Second list. In ascending order.
     * @param <E> element type
     * @return All the elements of A and B, in ascending order.
     */
    @Override
    public <E extends Comparable<? super E>> LinkedList<E> combinationOfSorted(LinkedList<E> A, LinkedList<E> B) {

        LinkedList<E> result = new LinkedList<>();

        ListIterator<E> iteratorA = A.listIterator();     //iteraattori listalle A
        ListIterator<E> iteratorB = B.listIterator();     //iteraattori listalle B

        /**
         * Käytä previousta, jos esim A listassa on suurempi arvo kuin B
         * listassa. Lisää B listaan, siirrä molempia iteraattoreita.
         * Jos edelleen A isompi, tee sama.
         *
         */

        // toistoa niin kauan kun listoissa on alkioita
        while (iteratorA.hasNext() && iteratorB.hasNext()) {
            E elementA = iteratorA.next();                          // seuraava alkio listasta
            E elementB = iteratorB.next();

            if (elementA.compareTo(elementB) < 0) {     // jos a on pienempi kuin b
                result.add(elementA);                   // lisää a listaan
//                E nykyinenA = iteratorA.next();       // siirrä a iter. seuraavaan
                E nykyinenB = iteratorB.previous();     // siirrä b iter. taaksepäin (vrt. seuraavaan a alkioon)
            }
            else {                                      // jos b on pienempi kuin a
                result.add(elementB);                   // lisää b listaan
//                E nykyinenB = iteratorB.next();       // siirrä b iter. seuraavaan
                E nykyinenA = iteratorA.previous();     // siirrä a iter. taaksepäin (vrt. seuraavaan b alkioon)
            }

        } // eka while loppuu

        while (iteratorA.hasNext()) {                   // tarkasta onko listoissa jäljellä alk.
            result.add(iteratorA.next());               // jos on, lisätään listaan
        }
        while (iteratorB.hasNext()) {
            result.add(iteratorB.next());
        }

        return result;
    }
}
