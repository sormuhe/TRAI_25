package com.example.trai.VKO_5;

// TRAI_26_t22.java SJ

import java.util.*;

public class TRAI_26_t22_skeleton {

    public static void main(String[] args) {

        int N = 6;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        Set<Set<Integer>> SS = new HashSet<>();

        Random r = new Random(N + 1);
        System.out.println("Inputs:");
        for (int i = 0; i < N; i++) {
            Set<Integer> S = new HashSet<>();
            for (int j = 0; j < N; j++) {
                S.add(r.nextInt(N * 2));
            }
            SS.add(S);
            System.out.println("S" + i + ": " + S);
        }

        Set<Integer> result = inOneOnly(SS);
        System.out.println("InOneOnly: " + result);
        System.out.println();


    } // main()


    /**
     * 22. Write an algorithm that takes as a parameter a set of sets (Set<Set<E>>) and returns
     * as a set (Set<E>) all the elements that appear in exactly one of the input sets. Elements
     * that appear in more than one of the input sets should not be included in the result. Do
     * not modify the input sets. Hint: Use a foreach iteration and a map. What is the time
     * complexity of your algorithm?
     *
     * @param SS  set of sets
     * @param <E> element type of sets
     * @return all elements that appear in exactly one of the sets
     */
    public static <E> Set<E> inOneOnly(Set<Set<E>> SS) {
        Set<E> result = new HashSet<>();
        Set<E> useammassajoukossa = new HashSet<>();

        for (Set<E> S : SS) {
            Set<E> kopioresult = new HashSet<>(result);

//            if (result.isEmpty()) {
//                result.addAll(S);
//            }
//
//            if (!kopioresult.isEmpty()) {
                kopioresult.retainAll(S);
                useammassajoukossa.addAll(kopioresult);
                result.removeAll(useammassajoukossa);
                result.addAll(S);
                result.removeAll(useammassajoukossa);
           // }
        }

        // TODO


        return result;
    } // inOneOnly


} // class
