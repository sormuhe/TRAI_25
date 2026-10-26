package com.example.trai.VKO_1;

// TRAI_26_t4_5_skeleton.java SJ
// Main program and skeleton for week 1 tasks 5 and 6

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TRAI_26_t4_5_skeleton {


    // Main program usage:
    // java TRAI_t26_4_5_skeleton [N] [N2] [S]
    // where N is the number of elements, N2 is the number of elements of the second array
    // and S is the seed for random number generation
    public static void main(String[] args) {

        // input sizes
        int n1 = 12;
        if (args.length > 0)
            n1 = Integer.parseInt(args[0]);

        int n2 = n1+2;
        if (args.length > 1)
            n2 = Integer.parseInt(args[1]);

        // random number seed
        int seed = 2026;
        if (args.length > 2)
            seed = Integer.parseInt(args[2]);

        // create input arrays
        Integer[] array1 = new Integer[n1];
        Integer[] array2 = new Integer[n2];

        // fill with elements
        java.util.Random r = new java.util.Random(seed);
        for (int i = 0; i < n1; i++) {
            array1[i] = r.nextInt(n1);
        }

        for (int i = 0; i < n2; i++) {
            array2[i] = r.nextInt(n2 * 4 / 3);
        }

        // print arrays (unless there are a lot of elements)
        if (n1 <= 20 && n2 <= 20) {
            System.out.print("a1: ");
            for (int i = 0; i < n1; i++)
                System.out.print(" " + array1[i]);
            System.out.println();

            System.out.print("a2: ");
            for (int i = 0; i < n2; i++)
                System.out.print(" " + array2[i]);
            System.out.println();
        }

        // call task 4
        Integer[] diff4 = difference4(array1, array2);

        System.out.print("Task 4, difference = ");
        if (n1 <= 20 && n2 <= 20) {
            for (Integer i : diff4)
                System.out.print(" " + i);
            System.out.println();
        } else {
            System.out.println(diff4.length + " element array");
            // notice: this prints array size, not the number of real elements
        }

        // Copy arrays into ArrayLists
        ArrayList<Integer> al1 = new ArrayList<>(List.of(array1));
        ArrayList<Integer> al2 = new ArrayList<>(List.of(array2));

        // call task 5
        ArrayList<Integer> diff5 = difference5(al1, al2);

        System.out.print("Task 5, difference = ");
        if (n1 <= 20 && n2 <= 20) {
            for (Integer i : diff5)
                System.out.print(" " + i);
            System.out.println();
        } else {
            System.out.println(diff5.size() + " elements");
        }

    } // main()


    /**
     Difference of arrays array1 and array2
     * <p>
     * Returns the difference of the arrays array1 and array2.
     * null elements are ignored.
     *
     * @param array1 first array
     * @param array2 secord array
     * @return new array containing elements that are in array1 but not in  array2
     */
    public static Integer[] difference4(Integer[] array1, Integer[] array2) {

        // TODO

        ArrayList<Integer> C = new ArrayList<>();

        for (Integer x : array1) {

            boolean onsama = false;

            for (Integer y : array2) {
                if (x == y) {
                    onsama = true;
                    break;
                }
            }
            if (!onsama) {
                C.add(x);
            }
        }

        return  C.toArray(new Integer[0]); // TODO

    } // difference4 ()


    /**
     * 5. Review the ArrayList class covered in the Programming II course. For more infor-
     * mation, see: <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList">...</a>.
     * html. Modify the algorithm from the previous task to work with ArrayList collections
     * instead of arrays. What is the time complexity of your algorithm? Could it be improved?
     * <p>
     * Returns the difference of the lists list1 and list2.
     * null elements are ignored.
     * T(|list1|, |list2|) =
     *
     * @param list1 first ArrayList
     * @param list2 secord ArrayList
     * @return new ArrayList containing elements are in list1 and/or list2
     */
    public static ArrayList<Integer> difference5(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();

        // TODO

        return result;

    } // difference5()


} // class

