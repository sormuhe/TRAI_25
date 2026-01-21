package com.example.trai.VKO_6;

// TRAI_25_t28.java SJ


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;


public class TRAI_25_t28_skeleton {

    // java TRAI_25_t28 [N] [K] [S]
    public static void main(String[] args) {

        // input size
        int N = 11;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        // unsorted at the end
        int K = 3;
        if (args.length > 1)
            K = Integer.parseInt(args[1]);

        // random seed
        int seed = 4;
        if (args.length > 2)
            seed = Integer.parseInt(args[2]);


        // fill in the input list
        Random r = new Random(seed);
        ArrayList<Integer> L = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            L.add(r.nextInt(N*3));
        }
        Collections.sort(L);

        // add unsorted elements to the end
        for (int i = 0; i < K; i++) {
            L.add(r.nextInt(N*2));
        }

        System.out.println("Input of " + L.size() + " elements");
        if (N <= 20) System.out.println("L:" + L);

        kSort28(L, K);

        if (N <= 20) System.out.println("L:" + L);

        // add a couple small ones
        L.add(-100);
        L.add(-1000);
        kSort28(L, 2);
        if (N <= 20) System.out.println("L:" + L);

        // add a couple large ones
        L.add(100);
        L.add(1000);
        kSort28(L, 2);
        if (N <= 20) System.out.println("L:" + L);

        // add a couple large ones again
        L.add(100);
        L.add(1000);
        kSort28(L, 2);
        if (N <= 20) System.out.println("L:" + L);

        // no adds
        kSort28(L, 0);
        if (N <= 20) System.out.println("L:" + L);


    } // main()

    /**
     * Sorts the given list in decreasing order for the last k elements, leveraging a priority queue.
     * This method is specifically designed for cases where only the last k elements of the list
     * are unsorted, and the rest of the list is already sorted in ascending order.
     *
     * @param A The list to be partially sorted. Elements must implement the Comparable interface.
     * @param k The number of elements at the end of the list to be sorted in decreasing order.
     *          If k is less than 1, the method returns without any changes. If k exceeds the
     *          list size, k is adjusted to match the size of the list.
     */
    public static <E extends Comparable<? super E>> void kSort28(ArrayList<E> A, int k) {

        // TODO

    }

} // class
