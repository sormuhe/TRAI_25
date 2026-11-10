package com.example.trai.VKO_3;

import fi.uef.cs.tra.*;
import java.util.*;

public class TRAI_26_t11_12_13_skeleton {
    public static void main(String[] args) {

        Random rnd = new Random();
        // input size
        int N = 10;
        if (args.length > 0) N = Integer.parseInt(args[0]);

        // seed
        int seed = N;
        if (args.length > 1) seed = Integer.parseInt(args[1]);

        rnd.setSeed(seed);

        // test a couple of inputs
        LinkedList<String> LL = randomStringList(rnd, N, 4, 1);
        ArrayList<String> AL = new ArrayList<>(LL);
        TraLinkedList<String> TL = collectionToTraLinkedList(LL);

        int ret = 0;
        // for each input, call to three tasks
        System.out.println("\nInput:    " + LL);
        ret = removeConsecutiveDuplicates11(AL);
        System.out.println("Output11: " + AL + " (" + ret + " elements removed)");
        ret = removeConsecutiveDuplicates12(LL);
        System.out.println("Output12: " + LL + " (" + ret + " elements removed)");
        ret = removeConsecutiveDuplicates13(TL);
        System.out.println("Output13: " + listToString(TL) + " (" + ret + " elements removed)");

        LL = randomStringList(rnd, N, 3, 1);
        AL = new ArrayList<>(LL);
        TL = collectionToTraLinkedList(LL);

        System.out.println("\nInput:    " + LL);
        ret = removeConsecutiveDuplicates11(AL);
        System.out.println("Output11: " + AL + " (" + ret + " elements removed)");
        ret = removeConsecutiveDuplicates12(LL);
        System.out.println("Output12: " + LL + " (" + ret + " elements removed)");
        ret = removeConsecutiveDuplicates13(TL);
        System.out.println("Output13: " + listToString(TL) + " (" + ret + " elements removed)");

        LL = randomStringList(rnd, N, 2, 1);
        AL = new ArrayList<>(LL);
        TL = collectionToTraLinkedList(LL);

        System.out.println("\nInput:    " + LL);
        ret = removeConsecutiveDuplicates11(AL);
        System.out.println("Output11: " + AL + " (" + ret + " elements removed)");
        ret = removeConsecutiveDuplicates12(LL);
        System.out.println("Output12: " + LL + " (" + ret + " elements removed)");
        ret = removeConsecutiveDuplicates13(TL);
        System.out.println("Output13: " + listToString(TL) + " (" + ret + " elements removed)");

        LL = randomStringList(rnd, N, 1, 1);
        AL = new ArrayList<>(LL);
        TL = collectionToTraLinkedList(LL);

        System.out.println("\nInput:    " + LL);
        ret = removeConsecutiveDuplicates11(AL);
        System.out.println("Output11: " + AL + " (" + ret + " elements removed)");
        ret = removeConsecutiveDuplicates12(LL);
        System.out.println("Output12: " + LL + " (" + ret + " elements removed)");
        ret = removeConsecutiveDuplicates13(TL);
        System.out.println("Output13: " + listToString(TL) + " (" + ret + " elements removed)");
    }

    /**
     * Removes consecutive duplicate elements from the specified list in place.
     *
     * Only adjacent elements that are equal are treated as duplicates; the first
     * element of each consecutive run is retained, and later equal elements in the
     * same run are removed. Equal elements that are not adjacent are not removed.
     *
     * @param <E> the type of elements in the list
     * @param AL the list from which consecutive duplicate elements are removed
     * @return number of elements removed
     */
    public static <E> int removeConsecutiveDuplicates11(ArrayList<E> AL) {

        // TODO

        return 0;
    }

    /**
     * Removes consecutive duplicate elements from the specified list in place.
     *
     * Only adjacent elements that are equal are treated as duplicates; the first
     * element of each consecutive run is retained, and later equal elements in the
     * same run are removed. Equal elements that are not adjacent are not removed.
     *
     * @param <E> the type of elements in the list
     * @param LL the list from which consecutive duplicate elements are removed
     * @return number of elements removed
     */
    public static <E> int removeConsecutiveDuplicates12(LinkedList<E> LL) {

        // TODO

        return 0;
    }

    /**
     * Removes consecutive duplicate elements from the specified list in place.
     *
     * Only adjacent elements that are equal are treated as duplicates; the first
     * element of each consecutive run is retained, and later equal elements in the
     * same run are removed. Equal elements that are not adjacent are not removed.
     *
     * @param <E> the type of elements in the list
     * @param TL the list from which consecutive duplicate elements are removed
     * @return number of elements removed
     * @return number of elements removed
     */
    public static <E> int removeConsecutiveDuplicates13(TraLinkedList<E> TL) {

        // TODO

        return 0;
    }


    /**
     * Creates a new TraLinkedList containing the strings from the specified collection.
     *
     * The elements are inserted in the iteration order of the collection.
     *
     * @param C the collection whose elements are copied into the new list
     * @return a new TraLinkedList containing all elements from the collection
     */
    public static TraLinkedList<String> collectionToTraLinkedList(Collection<String> C) {
        TraLinkedList<String> L = new TraLinkedList<>();
        for (String s : C) {
            L.insert(L.EOL, s);
        }
        return L;
    }

    public static LinkedList<String> randomStringList(Random r, int n, int s, int len) {
        LinkedList<String> L = new LinkedList<>();

        for (int i = 0; i < n; i++)
            L.add(randomString(r, len, s));

        return L;
    }

    public static String randomString(Random r, int len, int s) {
        char[] C = new char[len];
        for (int i = 0; i < len; i++) C[i] = (char) (r.nextInt(s) + 'a');
        return new String(C);
    }


    public static  <E> String listToString(TraLinkedList<E> TL) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        ListNode<E> n = TL.first();
        while (n != TL.EOL) {
            sb.append(n.getElement());
            if (n.next() != TL.EOL)
                sb.append(", ");
            n = n.next();
        }
        sb.append(")");
        return sb.toString();
    }

}
