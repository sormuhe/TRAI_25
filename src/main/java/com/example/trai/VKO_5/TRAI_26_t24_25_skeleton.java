package com.example.trai.VKO_5;

// TRAI_26_t24_25.java SJ

import java.util.*;

public class TRAI_26_t24_25_skeleton {

    // do your own testing also
    // either modify the parameters for input generation, or create your own tests

    public static void main(String[] args) {

        // inputs sizes
        int N1 = 15;
        if (args.length > 0)
            N1 = Integer.parseInt(args[0]);

        int N2 = N1 + 5;
        if (args.length > 0)
            N2 = Integer.parseInt(args[1]);

        // random number seed
        int seed = N1 + N2;
        if (args.length > 2)
            seed = Integer.parseInt(args[2]);

        // same or different elements
        int diff = 0;
        if (args.length > 3)
            diff = 1;

        Random rnd = new Random(seed);

        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();

        for (int i = 0; i < N1; i++) {
            L1.add(rnd.nextInt((int) (N1 / 1.5)));
        }
        for (int i = 0; i < N1; i++) {
            L2.add(rnd.nextInt((int) (N2 / 1.5) + diff * N1));
        }

        // print input
        if (N1 <= 20 && N2 <= 20) {
            System.out.println("L1: " + L1);
            System.out.println("L2: " + L2);
        }

        // call 24
        System.out.println();
        HashMap<Integer, Integer> occ1 = occurrences(L1);
        for (Map.Entry<Integer, Integer> e : occ1.entrySet()) {
            System.out.println("Element " + e.getKey() + " ocurred in list L1 " + e.getValue() + " times.");
        }
        System.out.println();

        // call 24
        System.out.println();
        HashMap<Integer, Integer> occ2 = occurrences(L2);
        for (Map.Entry<Integer, Integer> e : occ2.entrySet()) {
            System.out.println("Element " + e.getKey() + " ocurred in list L2 " + e.getValue() + " times.");
        }
        System.out.println();


        // call 25
        System.out.println();
        HashMap<Integer, Integer> yhdiste = bagIntersection(occ1, occ2);
        for (Map.Entry<Integer, Integer> e : yhdiste.entrySet()) {
            System.out.println("Element " + e.getKey() + " occured in intersection " + e.getValue() + " times.");
        }
        System.out.println();


    } // main()


    /**
     * 24. Write an algorithm that takes as a parameter a collection (Collection<E>) and creates
     * and returns a map (HashMap<E, Integer>) where the keys are all the distinct elements
     * found in the collection. The value for each key is the number of occurrences of that element.
     * For example, from the list (a, b, a), the resulting map would be (a: 2), (b: 1). Hint: all
     * collections support foreach iteration. What is the time complexity of your algorithm?
     *
     * @param C   input collection
     * @param <E> element type
     * @return result mapping of element occurrences
     */
    public static <E> HashMap<E, Integer> occurrences(Collection<E> C) {

        HashMap<E, Integer> result = new HashMap<>();

        // TODO

        return result;
    }


    /**
     * 25. Letâ€™s assume that a map (Map<E, Integer>) represents a bag (multiset) implementation.
     * Using the method from task 24, we can create such a map from a collection, where
     * the map contains the occurrence counts of each element. Write a method bagIntersec-
     * tion(Map<E, Integer> A, Map<E, Integer> B) that creates and returns a new map
     * such that the result contains as keys all the elements that appear in both input maps,
     * and the value for each key x is the minimum of the values for key x in the input maps A
     * and B. For example, from the maps A = { (a: 1), (b: 3) } and B = {(a: 2), (b: 2), (c: 3) }, the
     * resulting map would be { (a: 1), (b: 2) }. What is the time complexity of your algorithm?
     *
     * @param A   input map (bag)
     * @param B   input map (bag)
     * @param <E> element type
     * @return result map as an intersection of the input maps (bags)
     */
    public static <E> HashMap<E, Integer> bagIntersection(HashMap<E, Integer> A, HashMap<E, Integer> B) {
        HashMap<E, Integer> result = new HashMap<>();

        // TODO

        return result;
    }


} // class

