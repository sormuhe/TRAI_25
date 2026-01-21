package com.example.trai.VKO_6;

// TRAI_24_27.java SJ

import java.util.*;

public class TRAI_25_t29_skeleton {

    public static void main(String[] args) {

        int N = 7;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        List<Set<Integer>> LL = new LinkedList<>();

        Random r = new Random(N + 1);
        // System.out.println("Input sets:");
        for (int i = 0; i < N; i++) {
            Set<Integer> L = new TreeSet<>();
            int ni = r.nextInt(N*2);
            for (int j = 0; j < ni; j++) {
                L.add(r.nextInt(N * 2));
            }
            LL.add(L);
            // System.out.println("S" + i + ": " + L);
        }

        LinkedList<Set<Integer>> LS = new LinkedList<>(LL);
        System.out.println("Set list:");
        printByLines(LS);

        sortBySize(LS);

        System.out.println("Set list sorted according to the number of elements:");
        printByLines(LS);

    } // main()

    /**
     * Print collection by lines
     *
     * @param CC  input collection
     * @param <E> element type
     */
    static <E> void printByLines(Collection<E> CC) {
        System.out.println("(");
        for (E x : CC) {
            System.out.println(x.toString());
        }
        System.out.println(")");
    }



    /*
     * 29. Write an algorithm that takes as a parameter a list of sets (List<Set<E>>) and
     * sorts the list based on the number of elements in the sets.
     * Hint: Collections.sort() or List.sort() and Comparator<Set>.
     * What is the time complexity of your algorithm?
     *
     * @param LS input list
     * @param <E> element type of the sets (not used)
     */
    public static <E> void sortBySize(List<Set<E>> LS) {
        // TODO
    }



} // class
