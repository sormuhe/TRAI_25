package com.example.trai.VKO_3;

import fi.uef.cs.tra.ListNode;
import fi.uef.cs.tra.TraLinkedList;

import java.util.*;

public class TRAI_25_t11_13_skeleton {
    public static void main(String[] args) {

        Random rnd = new Random();
        // input size
        int N = 10;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        // seed
        int seed = N;
        if (args.length > 1)
            seed = Integer.parseInt(args[1]);


        // a couple of different tests of size N
        for (int i = 0; i < 5; i++) {

            // generate inputs
            rnd.setSeed(seed + i);
            LinkedList<String> LL = randomStringList(rnd, N, 4, 1);
            ArrayList<String> AL = new ArrayList<>(LL);
            TraLinkedList<String> TL = listToTraLinkedList(LL);

            // pick a random element as the limit
            // String limit = AL.get(rnd.nextInt(AL.size()));
            // vary the limit
            String limit = new String(new byte[]{(byte) ('a' + i)});

            System.out.println("\nInput: " + LL);
            System.out.println("Limit: " + limit);

            // task 11
            int removedAL = removeLarger(AL, limit);
            System.out.println("Result AL (" + removedAL + ") : " + AL);

            // task 12
            int removedLL = removeLarger(LL, limit);
            System.out.println("Result LL (" + removedLL + ") : " + LL);

            // task 13
            int removedTL = removeLarger(TL, limit);
            System.out.println("Result TL (" + removedTL + ") : " + listToString(TL));

        } // for i

        // test large input
        // a linear algorithm processes 10M elements about instantly
        // quadratic algorithm takes hours
        LinkedList<String> LL = randomStringList(rnd, 10_000_000, 4, 1);
        ArrayList<String> AL = new ArrayList<>(LL);
        TraLinkedList<String> TL = listToTraLinkedList(LL);
        String limit = "b";
        System.out.println("\nInput: " + LL.size() + " elements");

        System.out.println("Start task 11 (AL)");
        int removedAL = removeLarger(AL, limit);
        System.out.println("Result AL, removed " + removedAL + " elements, remaining : " + AL.size());

        System.out.println("Start task 12 (LL)");
        int removedLL = removeLarger(LL, limit);
        System.out.println("Result LL, removed " + removedLL + " elements, remaining : " + LL.size());

        System.out.println("Start task 13 (TL)");
        int removedTL = removeLarger(TL, limit);
        System.out.println("Result TL, removed " + removedTL + " elements, remaining : " + listSize(TL));


    } // main


    /**
     * 11.
     * Remove elements that are larger than limit.
     * @param AL input list
     * @param limit larger that this will be removed
     * @return number of removed elements
     * @param <E> element type
     */

    static <E extends Comparable<? super E>> int removeLarger(ArrayList<E> AL, E limit) {
        int removed = 0;
        int writeHead = 0;


        for (int readHead = 0; readHead < AL.size() ;) {    // readHead ei kasva listan kokoa suuremmaksi, käydään listaa läpi lukuosoittimen avulla
            E currentElement = AL.get(readHead);            // asetetaan raedHeadin arvo nykyiseksi

            if (currentElement.compareTo(limit) > 0) {      // verrataan nykyistä arvoa, onko suurempi kuin raja
                removed++;                                  // kasvatetaan removed-arvoa
            } else {
                AL.set(writeHead, AL.get(readHead));        // asetetaan uusi readHead-arvo writeHeadiin
                writeHead++;                                // siirretään readHeadiä
              }

            readHead++;
            }
        AL.remove(AL.size()-1);                        // poistetaan


        // TODO
        // use .set and .get and remove from end
        return removed;
    }

    /**
     * 12.
     * Remove elements that are larger than limit.
     * @param LL input list
     * @param limit larger that this will be removed
     * @return number of removed elements
     * @param <E> element type
     */
    static <E extends Comparable<? super E>> int removeLarger(LinkedList<E> LL, E limit) {
        int removed = 0;
        ListIterator<E> a = LL.listIterator();

        while (a.hasNext() ) {                       // niin kauan kun elementtejä on listassa
            E currentElement = a.next();            // a.next on nykyinen elementti

            if (currentElement.compareTo(limit) > 0) {      // verrataan nykyistä arvoa, onko suurempi kuin raja
                a.remove();                         // poistetaan elementti
                removed++;                          // kasvatetaan laskuria
            }
         }

        // TODO
        // use iterator
        return removed;
    }


    /**
     * 13.
     * Remove elements that are larger than limit.
     * @param TL input list
     * @param limit larger that this will be removed
     * @return number of removed elements
     * @param <E> element type
     */
    static <E extends Comparable<? super E>> int removeLarger(TraLinkedList<E> TL, E limit) {
        int removed = 0;

        ListNode<E> solmu = TL.first();// solmuun tallennetaan ensimmäinen alkio, jonka ListNode palauttaa


        while (solmu != TL.EOL ) {                     // niin kauan kun elementtejä on listassa

            if (solmu.getElement().compareTo(limit) > 0) {           // verrataan nykyistä arvoa, onko suurempi kuin raja
                ListNode<E> next = solmu.next();         // talteen seuraava solmu
                TL.remove(solmu);                   // poistetaan elementti
                solmu = next;
                removed++;                          // kasvatetaan laskuria
            } else {
                solmu = solmu.next();
            }

        }

        // TODO
        // use ListNode operations
        return removed;
    }



    // input generation helpers

    public static LinkedList<String> randomStringList(Random r, int n, int s, int len) {
        LinkedList<String> L = new LinkedList<>();
        for (int i = 0; i < n; i++)
            L.add(randomString(r, len, s));
        return L;
    }

    public static String randomString(Random r, int len, int s) {
        char[] C = new char[len];
        for (int i = 0; i < len; i++)
            C[i] = (char) (r.nextInt(s) + 'b');
        return new String(C);
    }

    public static <E> TraLinkedList<E> listToTraLinkedList(List<E> A) {
        TraLinkedList<E> TL = new TraLinkedList<>();
        for (E x : A)
            TL.insert(TL.EOL, x);
        return TL;
    }

    public static  <E> String listToString(TraLinkedList<E> L) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode<E> n = L.first();
        while (n != L.EOL) {
            sb.append(n.getElement());
            if (n != L.last())
                sb.append(", ");
            n = n.next();
        }
        sb.append("]");
        return sb.toString();
    }

    public static <E> int listSize(TraLinkedList<E> L) {
        ListNode<E> n = L.first();
        int size = 0;
        while (n != L.EOL) {
            size++;
            n = n.next();
        }
        return size;
    }

}
