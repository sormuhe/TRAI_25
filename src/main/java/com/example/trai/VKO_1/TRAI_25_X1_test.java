package com.example.trai.VKO_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

    /**
     * Test class for TRA I 2025 task X1.
     */
    public class TRAI_25_X1_test {

        static Random rnd = new Random();

        static TRAI_25_X1 mySolution = new TRAI_25_X1_sormuhei(); /* <-- Own userid here  */


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
            ok &= testResultX1(new Integer[]{3, 1, 4, 4, 3}, 3, print);
            ok &= testResultX1(new Integer[]{3, 1, 2, 3, 1}, 1, print);


            // test with fixed inputs
            // feel free to add more tests
            ok &= testResultX1(new Integer[]{2, 1}, 2, print);
            ok &= testResultX1(new Integer[]{1, 2}, 2, print);
            ok &= testResultX1(new Integer[]{1, 1}, 1, print);

            ok &= testResultX1(new Integer[]{1, 2, 3}, 2, print);
            ok &= testResultX1(new Integer[]{3, 2, 1}, 2, print);
            ok &= testResultX1(new Integer[]{2, 2, 3}, 2, print);
            ok &= testResultX1(new Integer[]{2, 1, 3}, 2, print);
            ok &= testResultX1(new Integer[]{1, 3, 2}, 2, print);
            ok &= testResultX1(new Integer[]{2, 2, 2}, 2, print);
            ok &= testResultX1(new Integer[]{-2, -2, -2}, -2, print);

            // test with generated inputs
            ok &= testResultX1(2, 2, 2, print);
            ok &= testResultX1(2, 2, 0, print);
            ok &= testResultX1(3, 1, 5, print);
            ok &= testResultX1(3, -101, 5, print);
            ok &= testResultX1(4, 100, 10, print);
            ok &= testResultX1(N, 1, N, print);
            ok &= testResultX1(N, 1, N*2, print);
            ok &= testResultX1(N/2, 1, N, print);
            ok &= testResultX1(N*2, 0, N, print);
            ok &= testResultX1(2, 300, 310, print);    // toimiihan myÃ¶s isommilla luvuilla?
            ok &= testResultX1(5, 300, 310, print);

            ok &= testResultX1(new Integer[]{}, null, print);
            ok &= testResultX1(new Integer[]{1}, null, print);


            if (ok)
                System.out.println("All fixed tests were correct.");

            // set "random" seed
            rnd.setSeed(System.currentTimeMillis());

            // test many random inputs
            int nTest = 1000;
            int k = 0;
            int errors = 0;
            while (k < nTest) {
                k++;
                if (! testResultX1(rnd.nextInt(nTest)+2, rnd.nextInt(nTest), rnd.nextInt(nTest) + nTest, 0))
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

        }   // main()


        /**
         * Test the task with given input
         * @param A input array
         * @param secondSmallest expected result
         * @param print amount of printing
         * @return true if the test result ok, false otherwise
         */
        static boolean testResultX1(Integer[] A, Integer secondSmallest, int print) {
            int n = A.length;
            if (print > 0) System.out.println("\nTest n="+n + " expected="+secondSmallest);
            if (n < 20 && print > 2 || print > 5) System.out.println("A[" + n + "]: " + Arrays.toString(A));

            Integer[] cA = Arrays.copyOf(A, n);

            Integer expected = secondSmallest; // expected result
            if (n < 2)
                expected = null; // expected result for n<2

            // make the call for your solution
            Integer result = null;
            try {
                result = mySolution.secondSmallest(A);
            } catch (Exception e) {
                System.out.println("Exception in secondSmallest: " + e);
                return false;
            }

            // compare to expected result
            boolean equal = java.util.Objects.equals(result, expected);

            // print results
            if (print > 1) System.out.println("Result: " + result);
            if (print > 0 && ! equal)
                System.out.println("Wrong result: " + result + ", expected: " + expected);

            boolean contentUnchanged = Arrays.equals(A, cA);
            if (! contentUnchanged && print > 0)
                System.out.println("Error: method modifies the content of the input!");

            if (print > 1 && equal && contentUnchanged)
                System.out.println("Test ok");

            return equal && contentUnchanged;

        }

        /**
         * Test the tasks with a random input.
         * @param n input size
         * @param secondSmallest smallest element
         * @param s adjustement to the smallest element
         * @param print amount of printing
         * @return true if the result is correct, false otherwise
         */
        static boolean testResultX1(int n, Integer secondSmallest, int s, int print) {

            // generate input, make a copy of input
            Integer[] A = randomArray(n, secondSmallest, s);
            return testResultX1(A, secondSmallest, print);

        }



        /**
         * Generate a random array of size n where secondSmallest is the second-smallest element.
         * @param n number of elements
         * @param secondSmallest smallest element
         * @param s how much smaller is the smallest
         * @return the generated arrasy
         */
        static Integer[] randomArray(int n, int secondSmallest, int s) {

            ArrayList<Integer> list = new ArrayList<>(n);

            list.add(secondSmallest);   // add the second-smallest element
            list.add(secondSmallest - rnd.nextInt(s+1));    // and a random smaller or equal element

            // add the rest of the elements, larger or equal to the second-smallest element
            for (int i = 2; i < n; i++) {
                list.add(secondSmallest + rnd.nextInt(i));
            }

            // If the request was n<2, remove enough elements.
            // Then the second-smallest does not apply.
            while (list.size() > n) {
                list.remove(list.size()-1);
            }

            // randomly shuffle the list
            Collections.shuffle(list, rnd);

            return list.toArray(new Integer[n]);
        }

    }


