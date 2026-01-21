package com.example.trai.VKO_4;


import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

import java.util.*;

public class TRAI_25_X4_test {

    static TRAI_25_X4 mySolution = new TRAI_25_X4_sormuhei();/* <-- Own user-id here */
    //

    public static void main(String[] args) {

        // tree size
        int N = 8;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        // seed for random variables
        int seed = 42;
        if (args.length > 1)
            seed = Integer.parseInt(args[1]);
        Random rnd = new Random(seed);

        // amount of printing
        int print = 4;
        if (args.length > 2)
            print = Integer.parseInt(args[2]);


        boolean ok = true;

        // a couple of trivial cases

        ok &= testX4("1 node tree, same elements",
                Arrays.asList(1), Arrays.asList(1), true, print);

        ok &= testX4("1 node tree, different elements",
                Arrays.asList(1), Arrays.asList(2), false, print);

        ok &= testX4("2 node tree, same elements similar structure",
                Arrays.asList(1, 2), Arrays.asList(2, 1), true, print);

        ok &= testX4("2 node tree, same elements different structure",
                Arrays.asList(2, 1), Arrays.asList(2, 1), true, print);

        ok &= testX4("2 node tree, different root, same structure",
                Arrays.asList(2, 3), Arrays.asList(1, 3), false, print);

        ok &= testX4("2 node tree, different right child, same structure",
                Arrays.asList(2, 3), Arrays.asList(2, 4), false, print);

        ok &= testX4("2 node tree, different left child, same structure",
                Arrays.asList(3, 2), Arrays.asList(3, 1), false, print);

        ok &= testX4("3 node tree, same elements, different structure",
                Arrays.asList(2, 1, 3), Arrays.asList(3, 1, 2), true, print);

        ok &= testX4("5 node list-trees, same elements, different structure",
                Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(5, 4, 3, 2, 1), true, print);

        ok &= testX4("5 node trees, same elements, different structure",
                Arrays.asList(3, 2, 1, 4, 5), Arrays.asList(3, 1, 2, 5, 4), true, print);

        ok &= testX4("3 node tree, same string elements, different structure",
                Arrays.asList("bb", "a", "cc"), Arrays.asList("cc", "a", "bb"), true, print);

        ok &= testX4("3 node tree, different string elements, same structure",
                Arrays.asList("bb", "a", "cc"), Arrays.asList("b", "aa", "cc"), false, print);

        ok &= testX4("3 node tree, same double elements, different structure",
                Arrays.asList(2.0, 1.0, 3.0), Arrays.asList(3.0, 1.0, 2.0), true, print);

        ok &= testX4("3 node tree, different double elements, same structure",
                Arrays.asList(2.0, 1.0, 3.0), Arrays.asList(2.0, 1.1, 3.0), false, print);



        System.out.println();

        if (ok)
            System.out.println("\nAll initial tests were correc");
        else
            System.out.println("\nSome problems in initial tests");


        // N tests with different inputs
        for (int i = 5; i < N+5; i++)
            ok &= testX4("Test", i, rnd.nextInt(i),
                    (rnd.nextBoolean() ? 0 : rnd.nextInt(4)), rnd, print);


        if (ok)
            System.out.println("\nFixed tests ok");
        else
            System.out.println("\nSome problems in fixed tests");

        // max 1000 random tests
        rnd.setSeed(System.currentTimeMillis());
        int nTest = 1000;
        int test = 0;
        int errors = 0;
        while (test < nTest) {
            test++;
            if (!testX4("Test", test+1, rnd.nextInt(test),
                    (rnd.nextBoolean() ? 0 : rnd.nextInt(4)), rnd, 0))
                errors++;
            if (errors > 30)
                break;
        }
        if (errors > 0)
            ok = false;

        System.out.println("\nOut of " + test + " random tests, " + (test-errors) + " were correct.");

        if (ok)
            System.out.println("\nAll tests gave correct answer.\n\nRemeber self-evaluation.");
        else
            System.out.println("\nSome tests had errors.");


    } // main()


    /**
     * Test X4 with size n trees.
     *
     * @param testName  String to display in the beginning of the test
     * @param n           number of treenodes
     * @param changeOrder   Change the order of elements
     * @param changeValue   Change some elements
     * @param rnd         random number generator
     * @param print       amount of print
     * @return true if test gave correct answer, false otherwise
     */
    static boolean testX4(String testName, int n, int changeOrder, int changeValue, Random rnd, int print) {
        ArrayList<Integer> AL1 = createRandomList(n, rnd);
        ArrayList<Integer> AL2 = new ArrayList<>(AL1);

        if (changeOrder > 0)
            messOrder(AL1, changeOrder, rnd); // possibly mess the list order
        if (changeOrder > 1 && (changeOrder % 2 == 0))
            messOrder(AL2, changeOrder, rnd);

        if (changeValue > 0 && changeValue % 2 == 0)
            changeValues(AL1, changeValue, rnd);
        else if (changeValue % 2 == 1)
            changeValues(AL2, changeValue, rnd);

        return testX4(testName + " N=" + n, AL1, AL2, changeValue==0, print);
    }

    /**
     * Test X4 with tree build using a list
     *
     * @param testName String to display in the beginning of the test
     * @param L1       the elements that will be put to the tree 1
     * @param L2       the elements that will be put to the tree 1
     * @param same     do the lists have the same elements or not (expected result)
     * @param print    amount of print
     * @return true if test gave correct answer, false otherwise
     */
    static <E extends Comparable<? super E>> boolean testX4(String testName, List<E> L1, List<E> L2,
                                                            boolean same, int print) {

        if (print > 0)
            System.out.println("\nTest \"" + testName + "\", n1 = " + L1.size() + " , n2 = " + L2.size() + " expected result=" + same);

        if (print > 3 && L1.size() <= 20)
            System.out.println("L1=" + L1);
        if (print > 3 && L2.size() <= 20)
            System.out.println("L2=" + L2);

        BTree<E> T1 = listToTreeInOrder(L1);
        BTree<E> T2 = listToTreeInOrder(L2);

        boolean result;
        try {
            result = mySolution.haveSameElements(T1, T2);
        } catch (Exception e) {
            if (print > 0) System.out.println("Exception from test: " + e);
            return false;
        }

        if (print > 1) {
            System.out.println("Have same elements (result):    " + result);
        }

        if (result == same) {
            if (print > 0) System.out.println("Correct result");
            return true;
        } else {
            if (print > 0) System.out.println("Not correct result");
            return false;
        }

    }


    /**
     * Create random list of unique elements
     * @param n input size
     * @param rnd random number generator
     * @return random list
     */
    public static ArrayList<Integer> createRandomList(int n, Random rnd) {
        HashSet<Integer> HS = new HashSet<>(n*2);
        ArrayList<Integer> AL = new ArrayList<>(n);
        int i = 0;
        while (i < n) {
            int x = rnd.nextInt(n*2+1);
            if (HS.add(x)) {
                AL.add(x);
                i++;
            }
        }
        return AL;
    }

    /**
     * Create random ascending list of unique elements
     * @param n input size
     * @param rnd random number generator
     * @return random list
     */
    public static ArrayList<Integer> createRandomAscendingList(int n, Random rnd) {
        ArrayList<Integer> AL = createRandomList(n, rnd);
        Collections.sort(AL);
        return AL;
    }

    /**
     * Swaps two random elements
     *
     * @param <E>   element type
     * @param AL    list to modify
     * @param times how many elements to change
     * @param rnd   random number generator
     */
    public static <E> void messOrder(ArrayList<E> AL, int times, Random rnd) {

        // 0-1 elements: order wont't be changed
        if (AL.size() < 2)
            return;

        while (times-- > 0) {
            // two different random indexes
            int i1 = rnd.nextInt(AL.size());
            int i2;
            do {
                i2 = rnd.nextInt(AL.size());
            } while (i2 == i1);

            // swap the elements
            E tmp = AL.get(i1);
            AL.set(i1, AL.get(i2));
            AL.set(i2, tmp);
        }
    }

    public static void changeValues(ArrayList<Integer> AL, int times, Random rnd) {

        // 0-1 elements: elements wont't be changed
        if (AL.isEmpty())
            return;

        HashSet<Integer> HS = new HashSet<>(AL);

        while (times-- > 0) {
            int i = rnd.nextInt(AL.size());
            int y = AL.get(i);
            int x = y+1;
            while (HS.contains(x)) {
                x++;
            }
            AL.set(i, x);
            HS.remove(y);
            HS.add(x);
        }

    }

    /**
     * Creates a tree out of array elements
     * Middle alement will be root of the tree, first half to left, last part to right.
     * If the elements were in ascending order, the tree will be in-ordered.
     * @param elements elements to add to tree
     * @param <E> element type
     * @return new tree
     */
    public static <E extends Comparable<? super E>> BTree<E> listToTreeInOrder(List<E> elements) {
        BTree<E> tree = new BTree<>();
        for (E e : elements) {
            inorderInsert(tree, e);
        }
        return tree;
    }


    /**
     * 15. Insert to in-ordered binary tree
     * @param T in-ordered binary tree
     * @param x the element to be added
     * @return true if element was added, false if the element was already in the tree
     */
    public static <E extends Comparable<? super E>> boolean inorderInsert(BTree<E> T, E x) {
        BTreeNode<E> n = T.getRoot();

        // empty tree as a special case
        if (n == null) {
            T.setRoot(new BTreeNode<E>(x));
            return true;
        }

        // find the place
        while (true) {

            if (x.compareTo(n.getElement()) == 0)
                // x already in tree, no add
                return false;

            else if (x.compareTo(n.getElement()) < 0) {
                // x precedes element of n
                if (n.getLeftChild() == null) {
                    // addition point found
                    n.setLeftChild(new BTreeNode<>(x));
                    return true;
                } else
                    n = n.getLeftChild();
            } else {
                // x follows element of n
                if (n.getRightChild() == null) {
                    // addition point found
                    n.setRightChild(new BTreeNode<>(x));
                    return true;
                } else
                    n = n.getRightChild();
            }
        } // while

    } // inorderInsert()

}
