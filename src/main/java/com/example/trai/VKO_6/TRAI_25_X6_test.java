package com.example.trai.VKO_6;

// TRAI_24_X6_test.java SJ

import java.util.*;

public class TRAI_25_X6_test {

    static TRAI_25_X6 mySolution = new TRAI_25_X6_sormuhei(); /* <-- Own user-id here  */

    static Random rnd = null;

    public static void main(String[] args) {

        int N = 5;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);
        int M = 4;
        if (args.length > 1)
            N = Integer.parseInt(args[1]);
        int K = 2;
        if (args.length > 2)
            K = Integer.parseInt(args[2]);
        int print = 4;
        if (args.length > 3)
            print = Integer.parseInt(args[3]);

        rnd = new Random(N);

        boolean ok = true;

        // test first with small sets, then with larger
        ok &= testX6(2, 3, 4, 0, print);
        ok &= testX6(3, 5, 2, 0, print);
        ok &= testX6(4, 5, 3, 1, print);
        ok &= testX6(4, 5, 10, 0, print);
        ok &= testX6(5, 10, 2, 3, print);

        // you can add tests here

        if (!ok) System.out.println("Some tests failed!\n");

        System.out.println("This test program does not check the correctness of the results.");
        System.out.println("It is part of the task to understand the problem and the solution");
        System.out.println("so that you can check the results.");
        System.out.println("You can also modify or make your own test program.");
        // System.out.println("There might be later such test program if I can figure out how to make");
        // System.out.println("reliably an expected result without showing an example solution.");

    } // main()


    /**
     * Tests the functionality of the method determining disjoint sets and verifies certain conditions.
     *
     * @param sets       the number of sets to be generated for testing
     * @param elements   the number of elements in each set
     * @param multiplier a value used to calculate the range of random integers for the sets
     * @param remove     the number of removal operations to ensure some disjoint sets
     * @param print      controls the verbosity level of printed output during the test
     * @return true if the test passes all conditions, false otherwise
     */
    static boolean testX6(int sets, int elements, int multiplier, int remove, int print) {

        boolean ok = true;

        if (print > 0) System.out.println("\n===========\ntestX6 " + sets + " " + elements + "\n");

        Set<Set<Integer>> SS = new HashSet<>(sets*2);
        Set<Set<Integer>> SScopy = new HashSet<>(sets*2);

        makeInput(sets, elements, multiplier, remove, SS, SScopy);

        if (print > 2) {
            System.out.println("Inputs:");
            printInput(SS);
        }

        if (print > 1)
            System.out.println("Calling method.");

        Map<Set<Integer>, Set<Set<Integer>>> result = mySolution.disjointSets(SS);

        if (print > 2) {
            System.out.println("disjointSets result:");
            printMap(result);
        }

        int disJoints = checkResult(result, SS);
        if (disJoints < 0)
            ok = false;
        else if (disJoints < remove) {
            // there should be at least remove disjoint sets in total
            System.out.println("Some disjoint sets are missing?");
            ok = false;
        }

        if (! SScopy.equals(SS)) {
            System.out.println("Input has been changed!");
            ok = false;
        }

        return ok; // does not actually check the result

    }

    /**
     * Prints the contents of a set of sets of integers.
     * Each subset is printed on a new line, enclosed within a pair of delimiters.
     *
     * @param SS a set of sets of integers to be printed
     */
    static void printInput(Set<Set<Integer>> SS) {
        System.out.println("-------");
        for (Set<Integer> S : SS)
            System.out.println(" " + S);
        System.out.println("-------");
    }


    /**
     * Validates the result of computing disjoint sets and ensures it matches the expected criteria.
     * Checks for missing or extraneous sets, null values, and extra sets that are not part of the input.
     *
     * @param result a map where each key is a set of integers, and the value is a set of sets that are disjoint from the key
     * @param SS a set of sets of integers, representing the original input data to be validated against
     * @return a positive integer representing the sum of the number of disjoint sets, a negative value errors
     */
    static int checkResult(Map<Set<Integer>, Set<Set<Integer>>> result, Set<Set<Integer>> SS) {

        int ok = 0;
        if (result == null) {
            System.out.println("Error: result is null!");
            return -1;
        }

        if (!SS.containsAll(result.keySet())) {
            System.out.println("Error: the result contains some sets that are not in the input!");
            ok -= 1;
        }
        if (!result.keySet().containsAll(SS)) {
            System.out.println("Error: some sets are missing from the result!");
            ok -= 1;
        }

        int disJoints = 0;
        for (Map.Entry<Set<Integer>, Set<Set<Integer>>> e : result.entrySet()) {
            Set<Integer> S = e.getKey();
            Set<Set<Integer>> DJ = e.getValue();
            if (DJ == null) {
                System.out.println("Set " + S + " has null as the set of disjoint sets!");
                ok--;
            } else {
                if (DJ.size() > 0) disJoints++;
                if (! SS.containsAll(DJ)) {
                    System.out.println("Disjoint set of set " + S + " contains some sets that are not in the input!");
                    ok--;
                }
                for (Set<Integer> D : DJ)
                    if (! Collections.disjoint(S, D)) {
                        System.out.println("Result of set " + DJ + " contains a set " + D + " has common elements with " + DJ);
                        ok--;
                    }
            }

        }
        return ok < 0 ? ok : disJoints;
    } // checkResult()

    /**
     * Prints the contents of a map where keys are sets of integers and values are sets of sets of integers.
     * Each map entry is printed in the format: "key : [ value1 value2 ... ]".
     * Each key-value pair is separated by a divider line for readability.
     *
     * @param M a map where each key is a set of integers, and the corresponding value is a set of sets of integers
     */
    static void printMap(Map<Set<Integer>, Set<Set<Integer>>> M) {
        System.out.println("-------");
        for (Map.Entry<Set<Integer>, Set<Set<Integer>>> E : M.entrySet()) {
            System.out.print(" " + E.getKey() + " : [ ");
            for (Set<Integer> S : E.getValue())
                System.out.print(S + " ");
            System.out.println("]");
        }
        System.out.println("-------");
    }


    /**
     * Generates a set of sets of integers and optionally creates a copy of the generated set.
     * The method initializes a specified number of sets (`Nsets`) containing random integers.
     * Some elements are optionally removed from specific sets to ensure certain conditions.
     *
     * @param Nsets       the number of sets to generate
     * @param Nelements   the number of elements in each set
     * @param multiplier  a factor to scale the range of random integers for element generation
     * @param remove      the number of removal operations to perform between sets
     * @param SS          the resulting set of sets where the generated data will be stored
     * @param SScopy      an optional copy of the generated set of sets; if null, no copy is created
     */
    static void makeInput(int Nsets, int Nelements,
                          int multiplier, int remove, Set<Set<Integer>> SS,
                          Set<Set<Integer>> SScopy) {

        SS.clear();
        ArrayList<Set<Integer>> SSA = new ArrayList<>(Nsets);

        for (int i = 0; i < Nsets; i++) {
            Set<Integer> Si = new HashSet<>();
            for (int j = 0; j < Nelements; j++) {
                Si.add(rnd.nextInt(Nelements*multiplier));
            }
            SSA.add(Si);
        }

        for (int k = 0; k < remove; k++) {
            int i = rnd.nextInt(Nsets);
            int j = rnd.nextInt(Nsets);
            if (i == j) j = (j+1)%Nsets;
            SSA.get(i).removeAll(SSA.get(j));
        }

        for (int i = 0; i < Nsets; i++) {
            SS.add(SSA.get(i));
        }

        if (SScopy != null) {
            for (Set<Integer> S : SSA)
                SScopy.add(new HashSet<>(S));
        }

    } // makeInput()


} // class TRAI_24_X6_test
