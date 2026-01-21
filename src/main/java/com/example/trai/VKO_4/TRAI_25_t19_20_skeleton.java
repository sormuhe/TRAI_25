package com.example.trai.VKO_4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;


public class TRAI_25_t19_20_skeleton {


    public static void main(String[] args) {

        // input sizes
        int n = 10;
        if (args.length > 0)
            n = Integer.parseInt(args[0]);

        int n2 = n + 2;
        if (args.length > 1)
            n2 = Integer.parseInt(args[1]);


        // random number seed
        int seed = n + n2;
        if (args.length > 2)
            seed = Integer.parseInt(args[2]);
        Random r = new Random(n );

        // example sets of the 1st grade book, find the correct solution manually
        Set<Integer> set19 = inTwoNotInTwo( Set.of(1, 3, 5, 6, 7, 8), Set.of(2, 4, 5, 6, 7, 8),
                Set.of(2, 3, 4, 6), Set.of(1, 4, 6, 7, 8, 9) );
        System.out.println("set19 example = " + set19);

        // a random test
        Set<Integer> I1 = new HashSet<>();
        Set<Integer> I2 = new HashSet<>();
        Set<Integer> N1 = new HashSet<>();
        Set<Integer> N2 = new HashSet<>();

        for (int i = 0; i < n; i++) {
            I1.add(r.nextInt(n*4/5));
            I2.add(r.nextInt(n*4/5));
            N1.add(r.nextInt(n*10/5));
            N2.add(r.nextInt(n*10/5));
        }

        System.out.println("\nI1 = " + I1);
        System.out.println("I2 = " + I2);
        System.out.println("N1 = " + N1);
        System.out.println("N2 = " + N2);

        set19 = inTwoNotInTwo(I1, I2, N1, N2);
        System.out.println("set19 = " + set19);


        // test 20
        r.setSeed(n+1);
        Set<Set<Integer>> SS = new HashSet<>();


        System.out.println("\nTask 20 inputs:");
        for (int i = 0; i < n; i++) {
            Set<Integer> S = new HashSet<>();
            for (int j = 0; j < n; j++) {
                S.add(r.nextInt(n*2/5));
            }
            SS.add(S);
            System.out.println("S" + i + ": " + S);
        }

        Set<Integer> set20 = intersection(SS);
        System.out.println("intersection: " + set20);



    } // main()



    /**
     * 19.
     * Return the elements that are in isHere1 and isHere2, but are not
     * in notHere1 and notHere2.
     * @param isHere1 Input set, the elements of the result must be here.
     * @param isHere2 Input set, the elements of the result must be here.
     * @param notHere1 Input set, the elements of the result may not be here.
     * @param notHere2 Input set, the elements of the result may not be here.
     * @return A new set.
     * @param <E> Element type.
     */
    public static <E> Set<E> inTwoNotInTwo(Set<E> isHere1, Set<E> isHere2, Set<E> notHere1, Set<E> notHere2) {

        Set<E> result = new HashSet<>();

        // TODO
        // use set operations, do not iterate over elements
        // plan carefully, use Venn diagrams when planning

        return result;

    }


    /**
     * 20.
     * Intersection of a set of sets.
     * @param SS  set of sets
     * @param <E> element type of sets
     * @return all elements that appear in all of the the sets
     */
    public static <E> Set<E> intersection(Set<Set<E>> SS) {
        Set<E> result = new HashSet<>();

        // TODO
        // use set operations, do not iterate over elements
        // plan carefully, use Venn diagrams when planning

        return result;
    }

    /**
     * Returns a random string of length len
     *
     * @param r   random number generator
     * @param len string length
     * @return new string
     */
    public static String randomString(Random r, int len, int s) {
        char[] C = new char[len];
        for (int i = 0; i < len; i++)
            C[i] = (char) (r.nextInt(s) + 'a');
        return new String(C);
    }



} // class

