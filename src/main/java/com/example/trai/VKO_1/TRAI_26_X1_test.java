package com.example.trai.VKO_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * Test class TRA I 2026 task X1.
 */
public class TRAI_26_X1_test {

    static Random rnd = new Random();

    static TRAI_26_X1 mySolution = new TRAI_26_X1_sormuhei(); /* <-- Own userid here */

    public static void main(String[] args) {

        // array size
        int N = 11;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        // seed for random variables
        int seed = 42;
        if (args.length > 1)
            seed = Integer.parseInt(args[1]);

        // amount of printing
        int print = 7;
        if (args.length > 2)
            print = Integer.parseInt(args[2]);

        rnd.setSeed(seed);

        boolean ok = true;

        // test with example inputs
        ok &= testResultX1(0, 0, false, false, print);
        ok &= testResultX1(1, 0, false, false, print);
        ok &= testResultX1(2, 0, true, false, print);
        ok &= testResultX1(2, 0, false, false, print);
        ok &= testResultX1(3, 0, true, false, print);
        ok &= testResultX1(3, 0, false, false, print);
        ok &= testResultX1(4, 0, true, false, print);
        ok &= testResultX1(N, 0, true, false, print);
        ok &= testResultX1(N, 0, false, false, print);
        ok &= testResultX1(N/2, 0, false, false, print);
        ok &= testResultX1(N*2, 0, true, false, print);
        ok &= testResultX1(5, 300, false, false, print);    // works with large numbers?
        ok &= testResultX1(5, 300, true, false, print);

        if (ok)
            System.out.println("All initial tests gave correct result.");

        // set "random" seed
        rnd.setSeed(System.currentTimeMillis());

        // test with many random inputs
        int nTest = 1000;
        int k = 0;
        int errors = 0;
        for (k = 0; k < nTest; k++) {
            if (! testResultX1(rnd.nextInt(nTest)+2, rnd.nextInt(nTest), rnd.nextBoolean(), false, 0))
                errors++;
            if (errors > 30)
                break;
        }
        if (errors > 0)
            ok = false;
        System.out.println("\nOut of " + k + " extra tests, " + (k-errors) + " were correct.");

        if (ok)
            System.out.println("\nAll tests gave correct answer.\n\nRemeber self-evaluation.");
        else
            System.out.println("\nSome tests had errors.");


    }



    /**
     * Test the tasks with a random input.
     *
     * @param n                input size
     * @param min              smallest integer to use
     * @param duplicates       whether to put unique values into the input or not
     * @param onlyOneDuplicate whether to put exactly one duplicate into the input or not
     * @param print            amount of printing
     * @return true if the result is correct, false otherwise
     */
    static boolean testResultX1(int n, int min, boolean duplicates, boolean onlyOneDuplicate, int print) {

        // generate input, copy input and print if needed
        Integer[] A = randomArray(n, min, duplicates, onlyOneDuplicate);
        Integer[] cA = Arrays.copyOf(A, A.length);

        if (print > 0) System.out.println("\nTest n="+n + " min="+min + " duplicates=" + duplicates);
        if (n < 20 && print > 2 || print > 5) System.out.println("A[" + n + "]: " + Arrays.toString(A));

        // call actual method to be tested
        boolean result = mySolution.haveDuplicates(A);

        // print result and compare with expected
        if (print > 1) System.out.println("Result: " + result);
        if (print > 0 && result != duplicates)
            System.out.println("Wrong result: " + result + ", expected: " + duplicates);

        boolean inputUnchanged = Arrays.equals(A, cA);
        if (! inputUnchanged && print > 0)
            System.out.println("Error: method modifies the input!");

        if (print > 1 && (result == duplicates) && inputUnchanged)
            System.out.println("Test ok");

        return (result == duplicates) && inputUnchanged;

    }





    /**
     * Generates an array of random integers with optional configurations for duplicates.
     *
     * The method creates an array of size n, with random integers starting from the minimum
     * value given by min. Options are provided to allow duplicates within the array and control
     * whether exactly one duplicate should be present.
     *
     * @param n                  The size of the array to be generated. Must be non-negative.
     * @param min                The minimum value that can be present in the generated array.
     * @param duplicates         Indicates whether duplicates are allowed in the array.
     * @param onlyOneDuplicate   Indicates whether exactly one duplicate should be introduced
     *                           if duplicates are allowed. This parameter is ignored if duplicates
     *                           is false.
     * @return                   An array of random integers based on the specified conditions.
     * @throws RuntimeException  If the input parameters specify an impossible configuration,
     *                           such as requiring one duplicate in an array with duplicates disallowed.
     */
    static Integer[] randomArray(int n, int min, boolean duplicates, boolean onlyOneDuplicate) {
        if (n < 0 || (n < 2 && duplicates) || (!duplicates && onlyOneDuplicate))
            throw new RuntimeException("Impossible request.");
        boolean hasDuplicate = false;
        Integer[] A = new Integer[n];
        if (min > Integer.MAX_VALUE - 4*n)
            min = Integer.MAX_VALUE - 4*n;
        HashSet<Integer> hs = new HashSet<>();
        int i = 0;
        while (i < n) {
            Integer x = min + rnd.nextInt(2 + n*3);
            if (hs.add(x))
                A[i++] = x; // new element
            else if (onlyOneDuplicate && duplicates) { // poista kommenttimerkit jos vain yksi duplikaattipari sallitaan
                A[i++] = x; // lisÃ¤tÃ¤Ã¤n ensimmÃ¤inen duplikaatti jos siihen oli lupa
                hasDuplicate = true;
            } //
        }
        if (duplicates && !hasDuplicate)    // jollei tullut duplikaattia, niin lisÃ¤tÃ¤Ã¤n
            addDuplicate(A);
        return A;
    }


    /**
     * Introduces a duplicate value in the given array by copying the value of one random
     * element to another random index in the array. The array must have at least two elements
     * to accommodate the operation.
     *
     * @param A The input array of integers where a duplicate will be introduced.
     *          The array must not be null and must have a length of at least two.
     * @throws RuntimeException if the input array is null or contains less than two elements.
     */
    static void addDuplicate(Integer[] A) {
        if (A == null || A.length < 2)
            throw new RuntimeException("Impossible request!");
        int n = A.length;
        int i1 = rnd.nextInt(n);
        int i2 = i1;
        while (i1 == i2)
            i2 = rnd.nextInt(n);
        A[i1] = A[i2];

    }

}
