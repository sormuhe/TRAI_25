package com.example.trai.VKO_5;

// TRAI_25_t23_25.java SJ

import java.util.*;

public class TRAI_25_t23_25_skeleton {

    public static void main(String[] args) {

        int N = 6;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);
        Random rnd = new Random(N);

        // test 24
        LinkedList<Integer> LL = new LinkedList<>();
        for (int i = 0; i < N; i++)
            LL.add(rnd.nextInt((int) (N / 1.5)));

        System.out.println("LL: " + LL);
        System.out.println("Occurrences: " + occurrences(LL));


        // generate input for 23&25
        Set<Set<Integer>> SS = new HashSet<>();

        Random r = new Random(N + 1);
        System.out.println("\nInputs:");
        for (int i = 0; i < N; i++) {
            Set<Integer> S = new HashSet<>();
            for (int j = 0; j < N; j++) {
                S.add(r.nextInt(N * 2));
            }
            SS.add(S);
            System.out.println("S" + i + ": " + S);
        }

        // call 23
        Set<Integer> result = inOneOnly23(SS);
        System.out.println("\nInOneOnly 23: " + result);
        System.out.println();

        // call 25
        result = inOneOnly25(SS);
        System.out.println("InOneOnly 25: " + result);
        System.out.println();


    } // main()


    /**
     * 23. Write an algorithm that takes as a parameter a set of sets (Set<Set<E>>) and returns
     * as a set (Set<E>) all the elements that appear in exactly one of the input sets. Elements
     * that appear in more than one of the input sets should not be included in the result. Do not
     * modify the input sets. You may not use a mapping (Map). Use only set operations. What
     * is the time complexity of your algorithm?
     *
     * @param SS  input set of sets
     * @param <E> element type
     * @return the elements that occur in one set only
     */
    public static <E> Set<E> inOneOnly23(Set<Set<E>> SS) {
        Set<E> result = new HashSet<>();

        // TODO
        // plan and use set operations

        return result;
    } // inOneOnly23()


    /**
     * 24. Write an algorithm that takes as a parameter a collection (Collection<E>) and creates and re-
     * turns a map (HashMap<E, Integer>) where the keys are all the distinct elements found in the
     * collection. The value for each key is the number of occurrences of that element. For example,
     * from the list (a, b, a), the resulting map would be {(a: 2), (b: 1)}. Hint: all collections support
     * for(:) iteration. Use only the basic operations of the mapping: .get() ja .put(). Do not use op-
     * erations compute, forEach, merge, replaceAll. What is the time complexity of your algorithm?
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
     * 25. Write an algorithm that takes as a parameter a set of sets (Set<Set<E>>) and returns as
     * a set (Set<E>) all the elements that appear in exactly one of the input sets. Elements that
     * appear in more than one of the input sets should not be included in the result. Do not modify
     * the input sets. Hint: Use a for(:) iteration, a map, and the solution of task 24. What is
     * the time complexity of your algorithm?
     *
     * @param SS  set of sets
     * @param <E> element type of sets
     * @return all elements that appear in exactly one of the sets
     */
    public static <E> Set<E> inOneOnly25(Set<Set<E>> SS) {
        Set<E> result = new HashSet<>();

        // TODO
        // use map as the tool

        return result;
    } // inOneOnly25


} // class
