package com.example.trai.VKO_2;

import java.util.*;

/**
 * Test class TRA I 2026 task X2.
 */
public class TRAI_26_X2_test {

    static Random rnd = new Random();

    static TRAI_26_X2 mySolution = new TRAI_26_X2_sormuhei(); /* <-- Own userid her */

    public static void main(String[] args) {

        // array size
        int N = 6;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        // seed for random variables
        int seed = 42;
        if (args.length > 1)
            seed = Integer.parseInt(args[1]);

        // amount of printing
        int print = 3;
        if (args.length > 2)
            print = Integer.parseInt(args[2]);

        rnd.setSeed(seed);

        boolean ok = true;

        // random inputs
        ok &= testResultX2(N, N, 0, 0, N, N, false,  print);
        ok &= testResultX2(N, N, 0, 0, N * 2, N * 5, false, print);

        // one has smaller, but still mixed
        ok &= testResultX2(N, N, 0, 2, N , N+2, true, print);
        ok &= testResultX2(N, N, 2, 0, N+2 , N, true, print);

        // largest of one is smallest of the other
        ok &= testResultX2(N, N, 0, N, N , N*2, true, print);
        ok &= testResultX2(N, N, N, 0, N*2 , N, true, print);

        // largest of one is smaller than smallest of the other
        ok &= testResultX2(N, N, 0, N+1, N , N*2, true, print);
        ok &= testResultX2(N, N, N+1, 0, N*2 , N, true, print);

        // short lists
        ok &= testResultX2(1, 1, 0, 0, N, N, false, print);
        ok &= testResultX2(1, 2, 0, 0, 1, 1, false, print);
        ok &= testResultX2(2, 1, 0, 0, 3, 2, false, print);
        ok &= testResultX2(2, 0, 0, 0, N, N, false, print);
        ok &= testResultX2(0, 1, 0, 0, N, N, false, print);
        ok &= testResultX2(1, 1, 0, 0, N, N, false, print);
        ok &= testResultX2(0, 0, 0, 0, N, N, false, print);

        // larger values
        ok &= testResultX2(N, N, 1000, 1000, 1000+N, 1000+N, false,  print);
        ok &= testResultX2(N, N, 1000, 1000, 1000 + N * 2, 1000 + N * 3, false, print);


        if (ok)
            System.out.println("All initial tests gave correct result.");

        // set "random" seed
        rnd.setSeed(System.currentTimeMillis());

        // test with many random inputs
        int nTest = 1000;
        int k = 1;
        int errors = 0;
        for (k = 1; k < nTest; k++) {
            if (! testResultX2(N, N, 0, 0, N, N, rnd.nextBoolean(),  0))
                errors++;
            if (errors >= 30)
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
     * Testaa yhdistettÃ¤ eri kokoisille taulukoille.
     *
     * @param n1            1. taulukon alkioiden mÃ¤Ã¤rÃ¤
     * @param n2            2. taulukon alkioiden mÃ¤Ã¤rÃ¤
     * @param min1          pienin luku taulukossa 1
     * @param min2          pienin luku taulukossa 2
     * @param max1          suurin luku taulukossa 1
     * @param max2          suurin luku taulukossa 2
     * @param ensureLimits varmistetaanko min ja max kuhunkin taulukkoon
     * @param print
     * @return
     */
    static boolean testResultX2(int n1, int n2, int min1, int min2,
                                int max1, int max2, boolean ensureLimits, int print) {

        // generate inputs
        ArrayList<Integer> A = randomGrowingList(n1, min1, max1, ensureLimits);
        ArrayList<Integer> B = randomGrowingList(n2, min2, max2, ensureLimits);

        // copies of input
        ArrayList<Integer> cA = new ArrayList<>(A);
        ArrayList<Integer> cB = new ArrayList<>(B);

        // print inputs
        if (print > 0) System.out.println("\nTEST n1="+n1 + " n2="+n2 + " min1="+min1 +
                " min2="+min2 + " max1="+max1 + " max2="+max2);
        if ((n1 < 20 && n2 < 20 && print > 2) || print > 5) {
            System.out.println("A[" + n1 + "]: " + A);
            System.out.println("B[" + n2 + "]: " + B);
        }

        // call actual method to be tested
        ArrayList<Integer> result = mySolution.unionOfSortedLists(A, B);

        // print result and compare with expected
        if ((result.size() < 20 && print > 1) || print > 5)
            System.out.println("Union: " + result);

        boolean ok = true;

        ok &= isInOrder(result, print);
        ok &= areUniqueElements(result, print);

        boolean inputUnchanged = A.equals(cA) && B.equals(cB);
        if (! inputUnchanged && print > 0)
            System.out.println("Error: method modifies the input!");

        // compare against reference result
        ok &= compare(result, unionUsingSets(A, B), print);

        return ok && inputUnchanged;

    }


    /**
     * Generate a random list with ascending order of elements
     *
     * @param n             number of elements
     * @param min           smallest element
     * @param max           largest element
     * @param ensureLimits  if true, ensure that min and max are included (unless n<2)
     * @return              new list
     */
    static ArrayList<Integer> randomGrowingList(int n, int min, int max, boolean ensureLimits) {
        ArrayList<Integer> result = new ArrayList<>(n);
        int k = 0;
        if (max < 1)
            max = 1;
        if (n < 2)
            max = min;
        if (ensureLimits) {
            if (n >= 1) {
                result.add(min);
                k++;
            }
            if (n >= 2) {
                result.add(max);
                k++;
            }
        }
        for (int i = k; i < n; i++) {
            result.add(rnd.nextInt(max - min + 1) + min);
        }
        Collections.sort(result);
        return result;
    }



    /**
     * Checks if the given list is in ascending order.
     *
     * The method verifies if all elements in the input list are in ascending order.
     * If any element is found that violates the ascending order condition,
     * a message is printed (if the print parameter is greater than 1), and the method returns false.
     * If the entire list is in ascending order and the print parameter is greater than 1,
     * a confirmation message is printed.
     *
     * @param A the list of integers to check for ascending order
     * @param print the verbosity level of output; if greater than 1, additional
     *              information about order violations or confirmation is printed
     * @return true if the list is in ascending order, false otherwise
     */
    static public boolean isInOrder(ArrayList<Integer> A, int print) {
        for (int i = 0; i < A.size() - 1; i++)
            if (A.get(i).compareTo(A.get(i + 1)) > 0) {
                if (print > 1)
                    System.out.println("Wrong order: A[" + i + "]=" + A.get(i) +
                            "A[" + (i + 1) + "]=" + A.get(i + 1));
                return false;
            }
        if (print > 1)
            System.out.println("Ascending order ok");
        return true;
    }




    /**
     * Checks if the given list contains only unique elements.
     *
     * The method verifies if all elements in the input list are distinct.
     * If duplicates are found, a message specifying the duplicate element
     * is printed, and the method returns false. If there are no duplicates
     * and the print parameter is greater than 1, a message confirming the
     * uniqueness of elements is printed.
     *
     * @param A the list of integers to check for uniqueness
     * @param print the verbosity level of output; if greater than 1, additional
     *              information is printed
     * @return true if all elements in the list are unique, false otherwise
     */
    static public boolean areUniqueElements(ArrayList<Integer> A, int print) {
        HashSet<Integer> HS = new HashSet<>(A.size()*2);
        for (Integer x : A) {
            if (!HS.add(x)) {
                System.out.println("Element " + x + " several times.");
                return false;
            }
        }
        if (print > 1)
            System.out.println("Unique elements ok");
        return true;
    }


    /**
     * Compares two lists
     *
     * @param A     result list
     * @param V     expected list
     * @param print amount of print
     * @return      true of the lists have the same elements in same order, false otherwise
     */

    static public boolean compare(ArrayList<Integer> A, ArrayList<Integer> V, int print) {

        if (print > 1 && A.size() <= 20 && V.size() <= 20) {
            System.out.println("Compare");
            System.out.println("A=" + A);
            System.out.println("V=" + V);
        }

        if (A.size() != V.size()) {
            if (print > 0) System.out.println("Intersection size: T:" + A.size() + "  V:" + V.size());
            if (A.size() > V.size()) {
                if (print > 0) System.out.println("Result list has more elements than expected.");
            } else {
                if (print > 0) System.out.println("Result list has less elements than expected.");
            }
            return false;
        }

        if (! A.containsAll(V) || !V.containsAll(A)) {
            if (print > 0) System.out.println("Content does not match");
            return false;
        }

        if (print > 1)
            System.out.println("Compare ok");

        return true;
    }


    /**
     * Computes the union of two lists using a TreeSet to ensure uniqueness and maintain ascending order.
     *
     * The method takes two input lists, combines their elements into a TreeSet (which removes duplicates and sorts the elements),
     * and returns a new ArrayList containing the elements of the TreeSet.
     *
     * THIS USES FORBIDDEN Set HELPER CLASS.
     *
     * @param A the first input list
     * @param B the second input list
     * @return a new list containing the union of elements from A and B in ascending order, with duplicates removed
     */
    static public ArrayList<Integer> unionUsingSets(ArrayList<Integer> A, ArrayList<Integer> B) {
        TreeSet<Integer> ts = new TreeSet<Integer>(A);
        ts.addAll(B);
        return new ArrayList<Integer>(ts);
    }


}