package com.example.trai.VKO_3;

// TRAI_25_t14_15.java SJ

// Take TRA-library from Moodle
// instruction in lecture 5

import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

import java.util.Random;

public class TRAI_26_t14_15_skeleton {

    public static void main(String[] args) {

        BTree<Integer> tree;

        int N = 12;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        // test with example tree

        tree = exampleBTree();
        System.out.println("Inorder::");
        inorderPrint(tree);

        System.out.println("Height = " + height(tree));

        System.out.println();


        // generate a new one, and test task 15

        tree = new BTree<>();

        System.out.println("\nInsert to tree:");
        Random r = new Random(42);
        Integer x = null;
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N * 2);
            System.out.print(x + " ");
            inorderInsert(tree, x);
        }
        System.out.println();

        System.out.println("Inorder:");
        inorderPrint(tree);

        System.out.println("Height = " + height(tree));

        // test search
        for (int i = 0; i < N * 2; i++) {
            System.out.println("Contains? " + i + " : " +
                    inorderMember(tree, i));
        }

    } // main()

    /**
     * 14. Height of a tree
     * @param t tree to measure height
     * @return tree height, or -1 if tree is empty
     **/
    public static <E> int height(BTree<E> t) {
        // TODO
        // see lecture 7 for the algorithm
        return 0;
    }

    /**
     * Height of a tree node.
     * @param n tree node to measure height
     * @return tree node height, or -1 if tree node is empty
     */
    public static <E> int height(BTreeNode<E> n) {

        // TODO
        return 0;
    }

    /**
     * 15. Insert to in-ordered binary tree
     * @param T in-ordered binary tree
     * @param x the element to be added
     * @return true if element was added, false if the element was already in the tree
     */
    public static <E extends Comparable<? super E>> boolean inorderInsert(BTree<E> T, E x) {

        // TODO
        // see lecture 7 for the algorithm
        return false;

    } // inorderInsert()


    // -------------------------------
    // examples


    public static BTree<Integer> exampleBTree() {

        BTree<Integer> T = new BTree<>();

        // root
        T.setRoot(new BTreeNode<>(9));

        BTreeNode<Integer> n = T.getRoot();

        // children of root
        n.setLeftChild(new BTreeNode<>(5));
        n.setRightChild(new BTreeNode<>(15));

        // left branch
        BTreeNode<Integer> l = n.getLeftChild();

        l.setLeftChild(new BTreeNode<>(3));
        l.setRightChild(new BTreeNode<>(8));

        l.getLeftChild().setRightChild(new BTreeNode<Integer>(4));

        // right branch
        l = n.getRightChild();

        l.setLeftChild(new BTreeNode<>(12));
        l.setRightChild(new BTreeNode<>(18));

        l.getLeftChild().setLeftChild(new BTreeNode<>(11));
        l.getLeftChild().setRightChild(new BTreeNode<>(13));


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
     * Is the element in a in-order btree or not
     * @param T in-ordered binary tree
     * @param x element to be found
     * @param <E> element type
     * @return true if the element x is in the tree, false otherwise.
     */
    public static <E extends Comparable<? super E>> boolean inorderMember(BTree<E> T, E x) {
        BTreeNode<E> n = T.getRoot();

        while (n != null) {
            if (x.compareTo(n.getElement()) == 0)
                return true;
            else if (x.compareTo(n.getElement()) < 0)
                n = n.getLeftChild();
            else
                n = n.getRightChild();
        } // while
        return false;

    } // inorderMember()


    /**
     * Print in in-order recursively
     * @param T tree to be printed
     */
    public static <E> void inorderPrint(BTree<E> T) {
        inorderPrintBranch(T.getRoot());
        System.out.println();
    } // inorderPrint()


    /**
     * Print in in-order recursively
     * @param n root of the subtree
     */
    public static <E> void inorderPrintBranch(BTreeNode<E> n) {
        if (n == null)
            return;

        inorderPrintBranch(n.getLeftChild());
        System.out.print(n.getElement() + " ");
        inorderPrintBranch(n.getRightChild());

    } // inorderPrintBranch()


} // class TRAI_25_t14_15.java
