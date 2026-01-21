package com.example.trai.VKO_2;
import java.util.*;

/**
 * Test class for DSA I 2025 task X2.
 */
public class TRAI_25_X2_test {

    static Random rnd = new Random();

    static TRAI_25_X2 mySolution = new TRAI_25_X2_sormuhei(); /* <-- Own id here */


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

        // some random tests
        ok &= testResultX2(N, N, 0, 0, N*2/3, N*2/3, false,  print);
        ok &= testResultX2(N, N, 0, 0, N * 2, N * 5, false, print);

        // one array has smaller element, but still some common
        ok &= testResultX2(N, N, 0, 2, N*2/3 , N*2/3+2, true, print);
        ok &= testResultX2(N, N, 2, 0, N*2/3+2 , N*2/3, true, print);

        // largest of one is smallest of the another
        ok &= testResultX2(N, N, 0, N, N , N*2, true, print);
        ok &= testResultX2(N, N, N, 0, N*2 , N, true, print);

        // one is all greater that largest ot the other
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

        // large values
        ok &= testResultX2(N, N, 1000, 1000, 1000+N, 1000+N, false,  print);
        ok &= testResultX2(N, N, 1000, 1000, 1000 + N * 2, 1000 + N * 3, false, print);


        if (ok)
            System.out.println("All initial tests were correct.");

        // set new seed
        rnd.setSeed(System.currentTimeMillis());

        // test many random inputs
        int nTest = 1000;
        int k = 0;
        int errors = 0;
        while (k < nTest) {
            k++;
            if (! testResultX2(N, N, 0, 0, N, N, rnd.nextBoolean(),  0))
                errors++;
            if (errors >= 30)
                break;
        }
        if (errors > 0)
            ok = false;

        System.out.println("\nOut of " + k + " random tests, " + (k-errors) + " were correct.");

        if (ok)
            System.out.println("\nAll tests gave correct answer.\n\nRemember self-evaluation.");
        else
            System.out.println("\nSome tests had errors.");

    }   // main()

    /**
     * Test task for generated inputs
     *
     * @param n1            input size 1
     * @param n2            input size 2
     * @param min1          smallest element in list 1
     * @param min2          smallest element in list 2
     * @param max1          largest element in list 1
     * @param max2          largest element in list 2
     * @param includeLimits whether to ensure min and max to each list
     * @param print         amount of print
     * @return  true if test gave correct answer, false otherwise
     */
    static boolean testResultX2(int n1, int n2, int min1, int min2,
                                int max1, int max2, boolean includeLimits, int print) {

        // generate inputs, make a copy of inputs
        ArrayList<Integer> A = randomGrowingList(n1, min1, max1, includeLimits);
        ArrayList<Integer> B = randomGrowingList(n2, min2, max2, includeLimits);

        ArrayList<Integer> cA = new ArrayList<>(A);
        ArrayList<Integer> cB = new ArrayList<>(B);

        // print inputs
        if (print > 0) System.out.println("\nTEST n1="+n1 + " n2="+n2 + " min1="+min1 +
                " min2="+min2 + " max1="+max1 + " max2="+max2);
        if ((n1 < 20 && n2 < 20 && print > 2) || print > 5) {
            System.out.println("A[" + n1 + "]: " + A);
            System.out.println("B[" + n2 + "]: " + B);
        }

        // make the call for your solution
        ArrayList<Integer> result = mySolution.intersectionOfGrowingLists(A, B);

        // print results
        if ((result.size() < 20 && print > 1) || print > 5)
            System.out.println("Intersection: " + result);

        boolean ok = true;

        ok &= isSorted(result, print);

        boolean contentUnchanged = A.equals(cA) && B.equals(cB);
        if (! contentUnchanged && print > 0)
            System.out.println("Error: method modifies the content of the input!");

        // compare to expected result
        ok &= compare(result, intersectionUsingMaps(A, B), print);

        return ok && contentUnchanged;

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
        ArrayList<Integer> list = new ArrayList<>(n);
        int k = 0;
        if (max < 1)
            max = 1;
        if (n < 2)
            max = min;
        if (ensureLimits) {
            if (n >= 1) {
                list.add(min);
                k++;
            }
            if (n >= 2) {
                list.add(max);
                k++;
            }
        }
        for (int i = k; i < n; i++) {
            list.add(rnd.nextInt(max - min + 1) + min);
        }
        Collections.sort(list);
        return list;
    }


    /**
     * Checks if the list is in ascending order
     *
     * @param A     list to be checked
     * @param print amount of printing
     * @return true if the list is in ascending order, false otherwise
     */
    static public boolean isSorted(ArrayList<Integer> A, int print) {
        if (A.isEmpty())
            return true;
        for (int i = 0; i < A.size() - 1; i++)
            if (A.get(i).compareTo(A.get(i + 1)) > 0) {
                if (print > 1)
                    System.out.println("Wrong order: A[" + i + "]=" + A.get(i) +
                            "A[" + (i + 1) + "]=" + A.get(i + 1));
                return false;
            }
        if (print > 2)
            System.out.println("Ascending order ok");
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
     * Intersection of two lists that are in ascending order.
     *
     * THIS USES FORBIDDEN MAP HELPER CLASS.
     *
     * ALSO DO NOT USE THIS AS AN EXAMPLE AS THIS IS UNNECESSARILY COMPLEX
     * JUST TO NOT GIVE EXAMPLE ;-)
     *
     * @param A first input list, elements in ascending order
     * @param B second input list, elements in ascending order
     * @return difference list, elements in ascending order
     */
    static <E extends Comparable<? super E>> ArrayList<E> intersectionUsingMaps(ArrayList<E> A, ArrayList<E> B) {
        ArrayList<E> result = new ArrayList<>();
        TreeMap<E, Integer> AM = new TreeMap<>();
        for (E x : A)
            AM.compute(x, (k, v) -> (v == null ? 1 : v+1));
        TreeMap<E, Integer> BM = new TreeMap<>();
        for (E x : B)
            BM.compute(x, (k, v) -> v == null ? 1 : v+1);
        for (Map.Entry<E, Integer> e : AM.entrySet())
            if (BM.containsKey(e.getKey())) {
                int min = Math.min(e.getValue(), BM.get(e.getKey()));
                for (int k = 0 ; k < min; k++)
                    result.add(e.getKey());
            }
        return result;
    }


}
