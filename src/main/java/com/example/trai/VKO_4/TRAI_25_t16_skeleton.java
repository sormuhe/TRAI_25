package com.example.trai.VKO_4;

import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

import java.util.Random;

public class TRAI_25_t16_skeleton {

    public static void main(String[] args) {

        BTree<Integer> tree = null;

        int N = 15;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);


        // test with example tree

        tree = exampleBTree();
        System.out.println("Reverse in-order print:");
        inorderPrintReverse(tree);

        // print with task 16
        System.out.println("Reverse in-order t16:");
        BTreeNode<Integer> n = inorderLast(tree);
        while (n != null) {
            System.out.print(n.getElement() + " ");
            n = inorderPrevious(n);
        }
        System.out.println();


        // a new random tree

        tree = new BTree<Integer>();


        System.out.println("\nInto tree:");
        Random r = new Random(42);
        Integer x = null;
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N * 2);
            System.out.print(x + " ");
            inorderInsert(tree, x);
        }
        System.out.println();

        System.out.println("Reverse in-order print:");
        inorderPrintReverse(tree);

        // print with task 16
        System.out.println("Reverse in-order t16:");
        n = inorderLast(tree);
        while (n != null) {
            System.out.print(n.getElement() + " ");
            n = inorderPrevious(n);
        }
        System.out.println();


    } // main()


    /**
     * Last node of the tree in in-order.

     * @param T input tree
     * @return The last node in in-order, or null if the tree is empty
     */
    public static <E> BTreeNode<E> inorderLast(BTree<E> T) {
        BTreeNode<E> n = T.getRoot();
        if (n == null)  // empty
            return null;
        while (n.getRightChild() != null)
            n = n.getRightChild();
        return n;

    }

    /**
     * 16. Write an operation inorderPrevious() that takes a node of a binary tree as a parameter
     and returns the predecessor of that node in in-order. The algorithm does not inspect the
     contents of the nodes, only the structure of the tree. The predecessor of a node is the
     rightmost descendant of its left child, or, if there is no left child, the ancestor whose right
     subtree contains the original node. If there is no predecessor, inorderPrevious() returns
     null. inorderNext() from lectures as an example. What is the time complexity? By calling
     first the algorithm above and then repeatedly this one, the elements of a binary tree
     can be traversed in reverse in-order. What is the time complexity of the entire traversal?

     * @param n   Tree node
     * @param <E> element type
     * @return predessor node, or null if there is no predessor
     */
    public static <E> BTreeNode<E> inorderPrevious(BTreeNode<E> n) {

        // TODO
        // check lecture 7

        return null;
    }


    // examples

    public static BTree<Integer> exampleBTree() {

        BTree<Integer> T = new BTree<>();

        // root
        T.setRoot(new BTreeNode<Integer>(9));

        BTreeNode<Integer> n = T.getRoot();

        // children of root
        n.setLeftChild(new BTreeNode<Integer>(5));
        n.setRightChild(new BTreeNode<Integer>(15));

        // left branch
        BTreeNode<Integer> l = n.getLeftChild();

        l.setLeftChild(new BTreeNode<Integer>(3));
        l.setRightChild(new BTreeNode<Integer>(8));

        l.getLeftChild().setRightChild(new BTreeNode<Integer>(4));

        // right branch
        l = n.getRightChild();

        l.setLeftChild(new BTreeNode<Integer>(12));
        l.setRightChild(new BTreeNode<Integer>(18));

        l.getLeftChild().setLeftChild(new BTreeNode<Integer>(11));
        l.getLeftChild().setRightChild(new BTreeNode<Integer>(13));


        System.out.println("                 ");
        System.out.println("       9        ");
        System.out.println("    __/  \\__     ");
        System.out.println("   5        15   ");
        System.out.println("  / \\      /  \\  ");
        System.out.println(" 3   8   12    18");
        System.out.println("  \\      /\\      ");
        System.out.println("   4    11 13    ");
        System.out.println("                 ");

        return T;

    } // exampleBTree()


    /**
     * 15. Insert to in-ordered binary tree
     *
     * @param T in-ordered binary tree
     * @param x the element to be added
     * @return true if element was added, false if the element was already in the tree
     */
    public static <E extends Comparable<? super E>>
    boolean inorderInsert(BTree<E> T, E x) {

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


    // Reverse norder print
    public static <E> void inorderPrintReverse(BTree<E>  T) {
        inorderPrintBranchReverse(T.getRoot());
        System.out.println();
    } // inorderPrint()


    public static <E> void inorderPrintBranchReverse(BTreeNode<E>  n) {
        if (n == null)
            return;
        inorderPrintBranchReverse(n.getRightChild());
        System.out.print(n.getElement() + " ");
        inorderPrintBranchReverse(n.getLeftChild());

    } // inorderPrintBranch()


} // class TRAI_22_t17.java
