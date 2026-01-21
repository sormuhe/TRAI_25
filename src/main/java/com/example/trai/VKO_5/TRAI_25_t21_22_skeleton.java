package com.example.trai.VKO_5;

// TRAI_25_t21_22.java SJ

import fi.uef.cs.tra.TraSet;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TRAI_25_t21_22_skeleton {

    public static void main(String[] args) {

        int N = 10;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        Set<Integer> JS1 = new HashSet<>();
        Set<Integer> JS2 = new HashSet<>();
        Set<Integer> JS3 = new HashSet<>();

        Random r = new Random(42);
        Integer x, y;
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N + 2);
            y = r.nextInt(N + 2);
            JS1.add(x);
            JS2.add(x - y);
            JS3.add(x + y);
        }

        TraSet<Integer> TS1 = new TraSet<>(JS1);
        TraSet<Integer> TS2 = new TraSet<>(JS2);
        TraSet<Integer> TS3 = new TraSet<>(JS3);


        System.out.println("TS1:      " + TS1);
        System.out.println("TS2:      " + TS2);
        System.out.println("TS3:      " + TS3);


        System.out.println("twoInTreeJava: " + twoInThree(JS1, JS2, JS3));

        System.out.println("twoInTreeTRA : " + twoInThree(TS1, TS2, TS3));

    } // main()


    /**
     * 21. Write an algorithm that creates a â€two out of threeâ€ intersection of sets. Algorithm gets as
     * parameter three sets (java.util.Set), and creates a new set that contains those elements that
     * are contained in exactly two input sets (not all three, not less than two). Do not modify the
     * input sets. What is the time complexity of your algorithm?
     *
     * @param A   input set
     * @param B   input set
     * @param C   input set
     * @param <E> element type
     * @return a new set containing the elements that appear in exactly two of the input sets.
     */
    public static <E> Set<E> twoInThree(Set<E> A, Set<E> B, Set<E> C) {
        Set<E> result = new HashSet<>();

        // TODO
        // use set operations

        return result;
    }


    /**
     * 22. Write an algorithm that creates a â€two out of threeâ€ intersection of sets. Algorithm gets as
     * parameter three sets of our data structure library (TraSet), and creates a new set that contains
     * those elements that are contained in exactly two input sets (not all three, not less than two).
     * Do not change the input sets. Do not use Java Set -types or mappings. What is the time
     * complexity of your algorithm?
     *
     * @param A   input set
     * @param B   input set
     * @param C   input set
     * @param <E> element type
     * @return a new set containing the elements that appear in exactly two of the input sets.
     */
    public static <E> TraSet<E> twoInThree(TraSet<E> A, TraSet<E> B, TraSet<E> C) {

        // TODO
        // use set operations

        return null; // TODO

    } // twoInThree()


} // class TRAI_25_t21_22
