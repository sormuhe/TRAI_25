package com.example.trai.VKO_3;

import java.util.*;

/**
 * Test class for the TRA I task X3.
 */
public class TRAI_26_X3_test {
    static Random random = new Random();
    static TRAI_26_X3 mySolution = new TRAI_26_X3_sormuhei();

    public static void main(String[] args) {
        // Array size
        int N = 10;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        // Random seed
        int seed = 42;
        if (args.length > 1)
            seed = Integer.parseInt(args[1]);

        // Amount of printing
        int print = 3;
        if (args.length > 2)
            print = Integer.parseInt(args[2]);

        random.setSeed(seed);
        boolean ok = true;

        // "Random" test cases
        ok &= testResultX3(N, N, 0, 0, N, N, false, print);
        ok &= testResultX3(N, N, 0, 0, N * 2, N * 5, false, print);

        // The second list has a smaller minimum, but the ranges still overlap
        ok &= testResultX3(N, N, 0, 2, N, N + 2, true, print);
        ok &= testResultX3(N, N, 2, 0, N + 2, N, true, print);

        // The maximum of one list is the minimum of the other
        ok &= testResultX3(N, N, 0, N, N, N * 2, true, print);
        ok &= testResultX3(N, N, N, 0, N * 2, N, true, print);

        // The maximum of one list is smaller than the minimum of the other
        ok &= testResultX3(N, N, 0, N + 1, N, N * 2, true, print);
        ok &= testResultX3(N, N, N + 1, 0, N * 2, N, true, print);

        // Short lists
        ok &= testResultX3(1, 1, 0, 0, N, N, false, print);
        ok &= testResultX3(1, 2, 0, 0, 1, 1, false, print);
        ok &= testResultX3(2, 1, 0, 0, 3, 2, false, print);
        ok &= testResultX3(2, 0, 0, 0, N, N, false, print);
        ok &= testResultX3(0, 1, 0, 0, N, N, false, print);
        ok &= testResultX3(0, 2, 0, 1, 0, 1, false, print);
        ok &= testResultX3(2, 2, 0, 1, 0, 1, false, print);
        ok &= testResultX3(1, 1, 0, 0, N, N, false, print);
        ok &= testResultX3(0, 0, 0, 0, N, N, false, print);

        // Larger numbers
        ok &= testResultX3(N, N, 1000, 1000, 1000 + N, 1000 + N, false, print);
        ok &= testResultX3(
                N, N, 1000, 1000, 1000 + N * 2, 1000 + N * 3, false, print);

        // Test with strings as well
        ok &= testResultX3Strings(N, N, 1, print);
        ok &= testResultX3Strings(N, N, 2, print);

        if (ok)
            System.out.println("All initial tests gave correct result.");

        // Set a "random" random seed
        random.setSeed(System.currentTimeMillis());

        // Run random tests for at most 10 seconds
        long endTime = System.currentTimeMillis() + 10 * 1000;
        int numberOfTests = 1000;
        int k = 0;
        int errors = 0;

        // Test many random inputs
        for (k = 0; k < numberOfTests; k++) {
            int N1 = random.nextInt(k + 2) * 10 + 1;
            int N2 = random.nextInt(k + 2) * 10 + 1;

            if (!testResultX3(
                    N1, N2, 0, 0, N1, N2, random.nextBoolean(), print - 5))
                errors++;

            if (errors > 30)
                break;
            if (System.currentTimeMillis() > endTime)
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
     * Tests the result for lists of different sizes.
     *
     * @param n1 number of elements in the first list
     * @param n2 number of elements in the second list
     * @param min1 smallest value in the first list
     * @param min2 smallest value in the second list
     * @param max1 largest value in the first list
     * @param max2 largest value in the second list
     * @param ensureBounds whether to ensure the minimum and maximum values
     *                     occur in each list
     * @param print amount of output
     * @return true if the test passed; otherwise false
     */
    static boolean testResultX3(
            int n1, int n2, int min1, int min2,
            int max1, int max2, boolean ensureBounds, int print) {

        // Generate inputs
        LinkedList<Integer> A =
                randomSortedList(n1, min1, max1, ensureBounds);
        LinkedList<Integer> B =
                randomSortedList(n2, min2, max2, ensureBounds);

        // Save copies of the inputs
        LinkedList<Integer> copyA = new LinkedList<>(A);
        LinkedList<Integer> copyB = new LinkedList<>(B);

        // Print the inputs
        if (print > 0)
            System.out.println("\nTEST n1=" + n1 + " n2=" + n2
                    + " min1=" + min1 + " min2=" + min2
                    + " max1=" + max1 + " max2=" + max2);

        if ((n1 < 20 && n2 < 20 && print > 2) || print > 5) {
            System.out.println("A[" + n1 + "]: " + A);
            System.out.println("B[" + n2 + "]: " + B);
        }

        // Call the method being tested
        mySolution.addNew(A, B);

        // Compute the reference result
        addNewUsingSetsAndMaps(copyA, copyB);

        // Print the result
        if ((A.size() < 20 && print > 1) || print > 5)
            System.out.println("Result: " + A);

        boolean ok = true;
        ok &= isSortedAscending(A, print);

        boolean inputBPreserved = B.equals(copyB);
        if (!inputBPreserved && print > 0)
            System.out.println("Error: method modifies the input list B!");

        // Compare the result with the reference result
        ok &= compareSortedLists(A, copyA, print);
        return ok && inputBPreserved;
    }

    static boolean testResultX3Strings(int n1, int n2, int length, int print) {
        // Generate inputs
        LinkedList<String> A =
                randomSortedStringList(random, n1, length);
        LinkedList<String> B =
                randomSortedStringList(random, n2, length);

        LinkedList<String> copyA = new LinkedList<>(A);
        LinkedList<String> copyB = new LinkedList<>(B);

        // Print the inputs
        if (print > 0)
            System.out.println("\nTEST String n1=" + n1
                    + " n2=" + n2 + " len=" + length);

        if ((n1 <= 20 && n2 <= 20 && print > 2) || print > 5) {
            System.out.println("A[" + n1 + "]: " + A);
            System.out.println("B[" + n2 + "]: " + B);
        }

        // Call the method being tested
        mySolution.addNew(A, B);

        // Compute the reference result
        addNewUsingSetsAndMaps(copyA, copyB);

        // Print the result
        if ((A.size() <= 20 && print > 1) || print > 5)
            System.out.println("Tulos: " + A);

        boolean ok = true;
        ok &= isSortedAscending(A, print);

        boolean inputBPreserved = B.equals(copyB);
        if (!inputBPreserved && print > 0)
            System.out.println("Error: method modifies the input list B!");

        // Compare the result with the reference result
        ok &= compareSortedLists(A, copyA, print);
        return ok && inputBPreserved;
    }

    public static LinkedList<String> randomSortedStringList(
            Random random, int n, int length) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++)
            list.add(randomString(random, length));
        Collections.sort(list);
        return list;
    }

    public static String randomString(Random random, int length) {
        char[] characters = new char[length];
        for (int i = 0; i < length; i++)
            characters[i] = (char) (random.nextInt(26) + 'a');
        return new String(characters);
    }

    /**
     * Generates a random list of size n in ascending order.
     *
     * @param n number of elements
     * @param min minimum possible value
     * @param max maximum possible value
     * @param ensureBounds if true, min and max are included
     *                    (unless n is less than 2)
     * @return a new list
     */
    static LinkedList<Integer> randomSortedList(
            int n, int min, int max, boolean ensureBounds) {
        LinkedList<Integer> result = new LinkedList<>();
        int k = 0;

        if (max < 1)
            max = 1;
        if (n < 2)
            max = min;

        if (ensureBounds) {
            if (n >= 1) {
                result.add(min);
                k++;
            }
            if (n >= 2) {
                result.add(max);
                k++;
            }
        }

        for (int i = k; i < n; i++)
            result.add(random.nextInt(max - min + 1) + min);

        Collections.sort(result);
        return result;
    }

    /**
     * Checks whether the given list is in ascending order.
     *
     * @param list list to check
     * @param print amount of output
     * @return true if the list is in ascending order; otherwise false
     */
    static public <E extends Comparable<? super E>> boolean isSortedAscending(
            LinkedList<E> list, int print) {
        if (list.size() < 2) // A list with 0 or 1 elements is sorted
            return true;

        ListIterator<E> iterator = list.listIterator();
        E previous = iterator.next();

        while (iterator.hasNext()) {
            E next = iterator.next();
            if (previous.compareTo(next) > 0) {
                if (print > 1)
                    System.out.println("Wrong order: A["
                            + (iterator.previousIndex() - 1) + "]=" + previous
                            + " A[" + iterator.previousIndex() + "]=" + next);
                return false;
            }
            previous = next;
        }

        if (print > 2)
            System.out.println("Increasing order ok");
        return true;
    }

    /**
     * Compares the contents of two sorted lists.
     *
     * @param A list being checked
     * @param expected reference list
     * @param print amount of output
     * @return true if the lists contain the same elements in the same order
     */
    static public <E extends Comparable<? super E>> boolean compareSortedLists(
            LinkedList<E> A, LinkedList<E> expected, int print) {
        if (print > 1 && A.size() <= 20 && expected.size() <= 20) {
            System.out.println("Compare to expected result:");
            System.out.println("Result   =" + A);
            System.out.println("Expected =" + expected);
        }

        if (A.size() != expected.size()) {
            System.out.println("Different size: T:" + A.size()
                    + "  V:" + expected.size());
            if (A.size() > expected.size())
                System.out.println(
                        "Resulting A has too many elements?");
            else
                System.out.println(
                        "Resulting A as too few elements?");
            return false;
        }

        // Traverse the lists in pairs, in order
        ListIterator<E> actualIterator = A.listIterator();
        ListIterator<E> expectedIterator = expected.listIterator();

        while (actualIterator.hasNext() && expectedIterator.hasNext())
            if (!actualIterator.next().equals(expectedIterator.next())) {
                if (print > 0)
                    System.out.println("Content does not match.");
                return false;
            }

        if (actualIterator.hasNext() || expectedIterator.hasNext())
            return false;

        if (print > 1)
            System.out.println("Compare ok");
        return true;
    }

    /**
     * Adds to A those elements of B that are not already in A.
     * This approach based on sets, maps, and clearing A is prohibited
     * in assignment X3.
     *
     * @param A first list
     * @param B second list
     * @param <E> element type
     */
    static public <E extends Comparable<? super E>> void addNewUsingSetsAndMaps(
            LinkedList<E> A, LinkedList<E> B) {
        TreeMap<E, Integer> counts = new TreeMap<>();
        HashSet<E> elementsInA = new HashSet<>(A);

        while (!A.isEmpty())
            counts.compute(A.pop(), (key, value) ->
                    value == null ? 1 : value + 1);

        for (E element : B)
            if (!elementsInA.contains(element))
                counts.compute(element, (key, value) ->
                        value == null ? 1 : value + 1);

        for (Map.Entry<E, Integer> entry : counts.entrySet())
            for (int i = 0; i < entry.getValue(); i++)
                A.add(entry.getKey());
    }
}
