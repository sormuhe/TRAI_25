package com.example.trai.VKO_1;

// TRAI_25_4_5_skeleton.java SJ
// Main program and skeleton for week 1 tasks 5 and 6

import java.util.ArrayList;
import java.util.List;

public class TRAI_25_4_5_skeleton {


    // Main program usage:
    // java TRAI_25_4_5_skeleton [N] [N2] [S]
    // where N is the number of elements, N2 is the number of elements of the second array,
    // and S is the seed for random number generation
    public static void main(String[] args) {

        // input sizes
        int N1 = 12;
        if (args.length > 0)
            N1 = Integer.parseInt(args[0]);

        int N2 = N1+2;
        if (args.length > 1)
            N2 = Integer.parseInt(args[1]);

        // random number seed
        int seed = 2025;
        if (args.length > 2)
            seed = Integer.parseInt(args[2]);

        // create input arrays
        Integer[] T1 = new Integer[N1];
        Integer[] T2 = new Integer[N2];

        // fill with elements
        java.util.Random r = new java.util.Random(seed);
        for (int i = 0; i < N1; i++) {
            T1[i] = r.nextInt(N1);
        }

        for (int i = 0; i < N2; i++) {
            T2[i] = r.nextInt(N2 * 4 / 3);
        }

        // print arrays (unless there are a lot of elements)
        if (N1 <= 20 && N2 <= 20) {
            System.out.print("A1: ");
            for (int i = 0; i < N1; i++)
                System.out.print(" " + T1[i]);
            System.out.println();

            System.out.print("A2: ");
            for (int i = 0; i < N2; i++)
                System.out.print(" " + T2[i]);
            System.out.println();
        }

        // call task 4
        Integer[] I4 = intersection4(T1, T2);

        System.out.print("Task 4, intersection = ");
        if (N1 <= 20 && N2 <= 20) {
            for (Integer i : I4)
                System.out.print(" " + i);
            System.out.println();
        } else {
            System.out.println(I4.length + " element array");
            // notice: this prints array size, not the number of real elements
        }

        // Copy arrays into ArrayLists
        ArrayList<Integer> L1 = new ArrayList<>(List.of(T1));
        ArrayList<Integer> L2 = new ArrayList<>(List.of(T2));

        // call task 5
        ArrayList<Integer> I5 = intersection5(L1, L2);

        System.out.print("Task 5, intersection = ");
        if (N1 <= 20 && N2 <= 20) {
            for (Integer i : I5)
                System.out.print(" " + i);
            System.out.println();
        } else {
            System.out.println(I5.size() + " elements");
        }

    } // main()


    /**
     * Intersection of arrays A1 and A2

     * Returns the intersection of the arrays A1 and A2.
     * null elements are ignored.
     *
     * @param A1 first array
     * @param A2 secord array
     * @return new array containing those elements that are both in A1 and in A2.
     */
    public static Integer[] intersection4(Integer[] A1, Integer[] A2) {

        Integer[] result = new Integer[A1.length]; // TODO

        // TODO
        int vapaa = 0;
//
//        if (int i = 0; i < vapaa; i++) {
//            for (int j = 0; j < 0; j++) {
//
//            }
//
//
//        }

        // refine stepwise from your plan in task 3
        // until you have the working Java -method

        return result;


    } // intersection4 ()

    /**
     * 5. Review the ArrayList class covered in the Programming II course. For more infor-
     * mation, see: <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList">...</a>.
     * html. Modify the algorithm from the previous task to work with ArrayList collections
     * instead of arrays. What is the time complexity of your algorithm? Could it be improved?
     * <p>
     * Returns the intersection of the lists L1 and L2.
     * null elements are ignored.
     * T(|L1|, |L2|) =
     *
     * @param L1 first ArrayList
     * @param L2 secord ArrayList
     * @return new ArrayList containing elements are in L1 and/or L2
     */
    public static ArrayList<Integer> intersection5(ArrayList<Integer> L1, ArrayList<Integer> L2) {
        ArrayList<Integer> result = new ArrayList<>();

        // TODO

        return result;

    } // intersection5()


} // class

