package com.example.trai.VKO_6;


import java.util.*;

/**
 * Test class for 2025 task 30.
 */
public class TRAI_25_t30_test {

    static Random rnd = new Random();

    // hake two stacks
    static TRAI_25_t30<Integer> testedPeekStack = new TRAI_25_t30_skeleton<>();
    static TRAI_25_t30<Double> testedPeekStack2 = new TRAI_25_t30_skeleton<>();


    public static void main(String[] args) {

        // input sizes
        int N = 8;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        // random seed
        int seed = (int)(System.currentTimeMillis() & 0xfffffffl);
        if (args.length > 1)
            seed = Integer.parseInt(args[1]);

        rnd.setSeed(seed);

        boolean ok = true;

        ok &= test_t30_1(testedPeekStack);
        ok &= test_t30_2(testedPeekStack);
        ok &= test_t30_N(testedPeekStack, N);
        ok &= test_t30_N(testedPeekStack, N*2);
        ok &= test_t30_N(testedPeekStack, rnd.nextInt(N*4));
        for (int i = 4; i <= 24; i+=2)
            ok &= test_t30_N(testedPeekStack, 1<<i);

        ok &= testWithDoubles(testedPeekStack2, rnd);

        System.out.println("\nAll ok: " + ok);

    }


    /**
     * Empties stack.
     * @param S
     */
    public static void popUntilEmpty(TRAI_25_t30 S) {
        System.out.println("\npopUntilEmpty.");
        while (!S.isEmpty())
            S.pop();
    }



    /**
     * Test one element function.
     * Assumes empty stack.
     * @param stack peek stack under test
     * @return true if all tests were ok, otherwise false
     */
    public static boolean test_t30_1(TRAI_25_t30<Integer> stack) {

        boolean ok = true;

        // popUntilEmpty(stack);

        ok &= testEmpty(stack, "Start_1", true);
        ok &= testSize(stack, "Start_1", 0);

        ok &= testPush(stack, "Add 0 (element zero)", 0);
        ok &= testEmpty(stack, "One element added", false);
        ok &= testSize(stack, "One element added", 1);
        ok &= testPopTop(stack, 0, "0 on top", false, true, false);

        ok &= testPopTop(stack, 0, "pop 0", true, true, false);
        ok &= testEmpty(stack, "Only removed", true);

        ok &= testPopTop(stack, null, "Top from empty", false, true, true);
        ok &= testPopTop(stack, null, "Remove from empty", true, true, true);

        System.out.println("Testi_1: " + ok + "\n");

        return ok;

    }

    /**
     * Test a couple of elements.
     * Assumes empty stack.
     * @param stack peek stack under test
     * @return true if all tests were ok, otherwise false
     */
    public static boolean test_t30_2(TRAI_25_t30<Integer> stack) {

        boolean ok = true;

        ok &= testEmpty(stack, "test_2 start ", true);

        ok &= testPush(stack, "Add 0", 0);
        ok &= testPush(stack, "Add 1", 1);

        ok &= testSize(stack, "Two", 2);

        ok &= testPopTop(stack, 1, "Top 1", false, true, false);
        ok &= testPopTop(stack, 1, "Pop 1", true, true, false);
        ok &= testEmpty(stack, "One left ", false);
        ok &= testSize(stack, "One left ", 1);
        ok &= testPopTop(stack, 0, "0 at top", false, true, false);

        ok &= testPopTop(stack, 0, "top2 from single element", false, false, true);
        ok &= testPopTop(stack, 0, "pop2 from single element", true, false, true);

        ok &= testPush(stack, "Add 2", 2);
        ok &= testPush(stack, "Add 3", 3);

        ok &= testPopTop(stack, 2, "2 as top2", false, false, false);
        ok &= testPopTop(stack, 2, "pop2 2", true, false, false);
        ok &= testPopTop(stack, 3, "top 3", false, true, false);

        ok &= testPopTop(stack, 0, "pop2 0 ", true, false, false);
        ok &= testPopTop(stack, 3, "pop 3", true, true, false);

        ok &= testEmpty(stack, "Empty", true);

        System.out.println("Test_2: " + ok + "\n");

        return ok;

    }

    /**
     * Test adding several elements.
     * @param stack to test
     * @param n number of elements
     * @return true if all tests ok, otherwise false
     */
    public static boolean test_t30_N(TRAI_25_t30<Integer> stack, int n) {

        System.out.println("Test_N n=" + n + " ");
        boolean ok = true;
        int errors = 0;
        try {
            for (int i = 0; i < n; i++) {
                stack.push(i);
            }
        } catch (Exception e) {
            System.out.println("Got exception " + e + " instead of adding element i");
            return false;
        }

        testPopTop(stack, n-1, "test_" + n + "_added, top ", false, true, n==0);

        try {
            for (int i = n-1; i >= 0; i--) {
                Integer x =  stack.pop();
                if (! x.equals(i)) {
                    errors++;
                    ok = false;
                    System.out.println("pop returned wrong element " + x + ", expected " + i);
                }
                if (errors > 20) {
                    System.out.println("Too much errors, break");
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Got unexpected exception " + e + "");
            return false;
        }

        ok &= testEmpty(stack, "Empty at end", true);

        System.out.println(" ok " + ok + "\n");
        return ok;

    }

    /**
     * Testa isEmpty -operation.
     * @param stack to test
     * @param text text to print
     * @param expected empty or not
     * @param <E> element type
     * @return true if emptiness is expected, otherwise false
     */
    static <E> boolean testEmpty(TRAI_25_t30<E> stack, String text, boolean expected) {
        if (stack.isEmpty() == expected) {
            System.out.println(text + ": isEmpty correct: " + expected);
            return true;
        } else {
            if (expected)
                System.out.println(text + " Stack is not empty even if it should be.");
            else
                System.out.println(text + " Stack is empty even if it should not.");
        }
        return false;
    }


    /**
     * Test isEmpty -operation.
     * @param stack to test
     * @param text text to print
     * @param expected size
     * @param <E> element type
     * @return true if size is expected, otherwise false
     */
    static <E> boolean testSize(TRAI_25_t30<E> stack, String text, int expected) {
        if (stack.size() == expected) {
            System.out.println(text + ": size ok: " + expected);
            return true;
        } else {
            System.out.println(text + " Stack has " +  stack.size() + " elements, expected " + expected);
            return false;
        }
    }

    /**
     * Adds element. Does not test whether the element was added as push does not report
     * @param stack to test
     * @param text text to print
     * @param elementToAdd
     * @param <E> element type
     * @return true if size is expected, otherwise false
     */
    static <E> boolean testPush(TRAI_25_t30<E> stack, String text, E elementToAdd) {
        System.out.print(text + " add " + elementToAdd + ":");
        try {
            stack.push(elementToAdd);
        } catch (Exception e) {
            System.out.println("Got execption " + e + " even if was supposed to add element " + elementToAdd);
            return false;
        }
        System.out.println(" push called");
        return true;
    }


    /**
     * Test one pop/peek.
     * @param stack      stack to test
     * @param expected         expected element
     * @param text    message to start of text
     * @param remove    pop or peek
     * @param top      top or top2
     * @param exception  is exeption exepted
     * @param <E>       element type
     * @return true if all ok, otherwise false
     */
    static <E> boolean testPopTop(TRAI_25_t30<E> stack, E expected, String text, boolean remove, boolean top, boolean exception) {
        try {

            System.out.print("Test " + text + " " + (remove ? "pop" : "top")
                    + (top ? "" : "2") + " : ");

            E x = null;

            if (top) { // top element
                if (remove)
                    x = stack.pop();
                else
                    x = stack.top();
            } else {    // second element
                if (remove)
                    x = stack.pop2();
                else
                    x = stack.top2();
            }

            if (expected != null && expected.equals(x))
                System.out.println("result ok : " + expected);
            else {
                if (!exception)
                    System.out.println("Got " + x + " instead of " + expected);
                else
                    System.out.println("Got " + x + " instead of exception NoSuchElementException");

                return false;
            }

        } catch (NoSuchElementException e) {
            if (exception)   // exception exepected
                System.out.println("exception ok");
            else {
                System.out.println("Got exception NoSuchElementException even if expected element " + expected);
                return false;
            }

        } catch (Exception e) {
            if (!exception)
                System.out.println("Got exception " + e + " even if expected element " + expected);
            else
                System.out.println("Got exception " + e + " even if expected exception NoSuchElementException");
            return false;
        }
        return true;
    }


    /**
     * Test stack with doubles
     * @param stack stack of Doubles
     * @param rnd random number generator
     * @return true if tests were ok, false otherwise
     */
    public static boolean testWithDoubles(TRAI_25_t30<Double> stack, Random rnd) {
        Stack<Double> compareStack = new Stack<>();

        System.out.println("Test with doubles");

        for (int i = 0; i < 20; i++) {
            Double d = rnd.nextDouble() * 200 - 100;
            compareStack.push(d);
            stack.push(d);
        }
        while (!compareStack.isEmpty() && !stack.isEmpty()) {
            if (Double.compare(compareStack.pop(), stack.pop()) != 0) {
                System.out.println("Wrong double from stack");
                popUntilEmpty(stack);
                return false;
            }
        }

        if (!compareStack.isEmpty() && !stack.isEmpty()) {
            System.out.println("Wrong number of elements from double stack");
            popUntilEmpty(stack);
            return false;
        }
        return true;
    }


}
