package com.example.trai.VKO_4;



import fi.uef.cs.tra.*;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class TRAI_26_t18_skeleton {

    public static void main(String[] args) {

        BTree<Integer> tree = null;

        int N = 11;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);


        // test first with fixed trees

        tree = exampleBTree();
        System.out.println("Inorder recursively:");
        inorderPrint(tree);


        BTreeNode<Integer> n = deepestTwoChilded(tree);
        if (n != null)
            System.out.println("Deepest two childed = " + n.getElement());
        else
            System.out.println("No two childed");

        tree = exampleBTree2();
        System.out.println("Inorder recursively:");
        inorderPrint(tree);


        n = deepestTwoChilded(tree);
        if (n != null)
            System.out.println("Deepest two-childed= " + n.getElement());
        else
            System.out.println("No two childed");


        // make a new tree

        tree = new BTree<>();


        System.out.println("\nInsert:");
        Random r = new Random(N);
        Integer x = null;
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N * 2);
            System.out.print(x + " ");
            inorderInsert(tree, x);
        }
        System.out.println();

        System.out.println("Inorder recursively:");
        inorderPrint(tree);

        n = deepestTwoChilded(tree);
        if (n != null)
            System.out.println("Deepest two-childed= " + n.getElement());
        else
            System.out.println("No two childed");

    } // main()

    /**
     * 18. Write an algorithm that finds the deepest (longest path from the root) node in a binary tree
     * that has two children. Hint: level-order traversal. If there are no nodes with exactly
     * two children, return null. What is the time complexity?
     *
     * @param T binary tree
     * @return deepest node with two children, or null if there is no such node.
     */
    public static <E> BTreeNode<E> deepestTwoChilded(BTree<E> T) {
        LinkedQueue<BTreeNode> Q = new LinkedQueue<BTreeNode>();

        if (T.getRoot() == null)
            return null;

        if (T.getRoot()!= null) {
            Q.offer((BTreeNode) T.getRoot());
        }

        BTreeNode<E> deepest = null;

        while (!Q.isEmpty()) {
            BTreeNode node = Q.poll(); // hakee ja poistaa jonon ensimmäisen

            if (node.getLeftChild() != null) {
                Q.offer((BTreeNode) node.getLeftChild());   // vasen lapsi jonoon
            }

            if (node.getRightChild() != null) {
                Q.offer((BTreeNode) node.getRightChild());  // oikea lapsi jonoon
            }

            if (node.getLeftChild() != null && node.getRightChild() != null) {
                deepest = node;
            }
        }
        // TODO



        return deepest;
    } // deepestTwoChilded()



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


    public static BTree<Integer> exampleBTree2() {

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

        // right branch
        l = n.getRightChild();

        l.setLeftChild(new BTreeNode<Integer>(12));
        l.setRightChild(new BTreeNode<Integer>(18));


        System.out.println("                 ");
        System.out.println("       9        ");
        System.out.println("    __/  \\__     ");
        System.out.println("   5        15   ");
        System.out.println("  / \\      /  \\  ");
        System.out.println(" 3   8   12    18");
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
                // x already in tree, no add, no sugar
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


    /**
     * Print in in-order recursively
     *
     * @param T tree to be printed
     */
    public static <E> void inorderPrint(BTree<E> T) {
        inorderPrintBranch(T.getRoot());
        System.out.println();
    } // inorderPrint()


    /**
     * Tulostus sisÃ¤jÃ¤rjestyksessÃ¤ rekursiivisesti.
     *
     * @param n tulostettavan alipuun juuri
     */
    public static <E> void inorderPrintBranch(BTreeNode<E> n) {
        if (n == null)
            return;

        inorderPrintBranch(n.getLeftChild());
        System.out.print(n.getElement() + " ");
        inorderPrintBranch(n.getRightChild());

    } // inorderPrintBranch()


} // class TRAI_26_t18.java
