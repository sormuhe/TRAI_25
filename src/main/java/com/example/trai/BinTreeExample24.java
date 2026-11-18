package com.example.trai;

// BinTreeExample.java SJ

import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

import java.util.Random;

public class BinTreeExample24 {

    public static void main(String[] args) {

        BTree<Integer> tree = new BTree<>();

        int N = 10;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        System.out.println("To tree:");
        Random r = new Random(42);
        Integer x;
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N*2);
            System.out.print(x + " ");
            inorderInsert(tree, x);
        }
        System.out.println();

        System.out.println("Elements in in-order:");
        inorderPrint(tree);

        for (int i = 0; i < 16; i++) {
            System.out.println("Member " + i + " : " +
                    inorderMember(tree, new Integer(i)));
        }

        tree = exampleBTree();

        System.out.println("Elements in in-order:");
        inorderPrint(tree);

        for (int i = 0; i < 20; i++) {
            System.out.println("Member " + i + " : " +
                    inorderMember(tree, new Integer(i)));
        }


        System.out.println("Remove:");
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N*2);
            System.out.print(x + ":");
            BTreeNode<Integer> n = inorderFindNode(tree, x);
            if (n != null) {
                inorderRemoveNode(tree, n);
                inorderPrint(tree);
            } else
                System.out.println();
        }
        System.out.println();


    } // main()

    /* Create small in-ordered example binary tree

           10
        __/  \__
       5        15
      / \      /  \
     3   8   12    18
      \      /\
       4    11 13

    */
    public static BTree<Integer> exampleBTree() {

        BTree<Integer> T = new BTree<Integer>();

        // root

        BTreeNode<Integer> n = T.setRoot(new BTreeNode<Integer>(10));

        // children or root
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
        System.out.println("       10        ");
        System.out.println("    __/  \\__     ");
        System.out.println("   5        15   ");
        System.out.println("  / \\      /  \\  ");
        System.out.println(" 3   8   12    18");
        System.out.println("  \\      /\\      ");
        System.out.println("   4    11 13    ");
        System.out.println("                 ");

        return T;

    } // exampleBTree()


    // Print in in-order
    public static void inorderPrint(BTree T) {
        inorderPrintBranch(T.getRoot());
        System.out.println();
    } // inorderPrint()


    public static void inorderPrintBranch(BTreeNode n) {
        if (n == null)
            return;

        inorderPrintBranch(n.getLeftChild());
        System.out.print(n.getElement() + " ");
        inorderPrintBranch(n.getRightChild());

    } // inorderPrintBranch()


    public static <E extends Comparable<? super E>>
    boolean inorderInsert(BTree<E> T, E x) {

        // TODO: removed until exercises

        return false;

    } // inorderInsert()


    // finds given element from tree, returns boolean value
    public static <E extends Comparable<? super E>>
    boolean inorderMember(BTree<E> T, E x) {
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


    // finds the node of given element in a tree
    public static <E extends Comparable<? super E>>
    BTreeNode<E> inorderFindNode(BTree<E> T, E x) {
        BTreeNode<E> n = T.getRoot();

        while (n != null) {
            if (x.compareTo(n.getElement()) == 0)
                return n;
            else if (x.compareTo(n.getElement()) < 0)
                n = n.getLeftChild();
            else
                n = n.getRightChild();
        } // while
        return null;

    } // inorderFindNode()


    // finds the node of given element in a tree
    // recursive version, just for example

    // recursion starting method
    public static <E extends Comparable<? super E>>
    BTreeNode<E> inorderFindNode2(BTree<E> T, E x) {
        return inorderFindNode2_r(T.getRoot(), x);
    } // inorderFindNode2()

    // actual recursive method
    public static <E extends Comparable<? super E>>
    BTreeNode<E> inorderFindNode2_r(BTreeNode<E> n, E x) {
        if (n == null)
            return null;

        // comparison
        int cmp = x.compareTo(n.getElement());

        if (cmp == 0)   // found here
            return n;

        if (cmp < 0)    // left or right
            return inorderFindNode2_r(n.getLeftChild(), x);
        else
            return inorderFindNode2_r(n.getRightChild(), x);

    } // inorderFindNode2_r()



    public static <E extends Comparable<? super E>>
    BTreeNode<E> inorderNext(BTreeNode<E> n) {

        // if node has right child find it's leftmost
        // descendant
        if (n.getRightChild() != null) {
            BTreeNode<E> m = n.getRightChild();
            while (m.getLeftChild() != null)
                m = m.getLeftChild();
            return m;
        }

        // otherwise, find the first ancestor whose
        // left subtree node n is
        else {
            BTreeNode<E> m = n;
            BTreeNode<E> par = n.getParent();
            while (par != null) {
                if (par.getLeftChild() == m)
                    return par;
                else {
                    m = par;
                    par = par.getParent();
                }
            }

        }

        // not found
        return null;

    } // inorderNext()


    // removes given node so that tree remains in in-order
    public static <E extends Comparable<? super E>>
    void inorderRemoveNode(BTree<E> T, BTreeNode<E> n) {

        // references to relatives
        BTreeNode<E> lc = n.getLeftChild();
        BTreeNode<E> rc = n.getRightChild();

        BTreeNode<E> par = n.getParent();

        // remember whether we a left of right child of the parent
        boolean left = false;
        if (par != null) {
            if (par.getLeftChild() == lc)
                left = true;
            else
                left = false;
        }

        // 0 and 1 child cases

        // if root, no left child: right child replaces
        if (n == T.getRoot() && lc == null) {
            T.setRoot(rc);
            return;
        }

        // if root, no right child: left child replaces
        else if (n == T.getRoot() && rc == null) {
            T.setRoot(lc);
            return;
        }

        // if no root, no left child: right child replaces
        if (lc == null) {
            if (left)
                par.setLeftChild(rc);
            else if (rc != null)
                par.setRightChild(rc);
        }

        // if no root, no right child: left child replaces
        else if (rc == null) {
            if (left)
                par.setLeftChild(lc);
            else if (lc != null)
                par.setRightChild(lc);
        }


        // both children exists
        else {

            BTreeNode<E> repl = inorderNext(n);
            E replElement = repl.getElement();

            // remoce replacing element recursively
            inorderRemoveNode(T, repl);

            // rigth child was possible changed
            rc = n.getRightChild();

            // new node
            repl = new BTreeNode<E>(replElement);
            if (n == T.getRoot())
                T.setRoot(repl);
            else if (left)
                par.setLeftChild(repl);
            else
                par.setRightChild(repl);

            // restore children
            repl.setLeftChild(lc);
            repl.setRightChild(rc);

            // alternative version: no now node, instead
            // replace the element only
            // n.setElement(replElement);

        }


    } // inorderRemoveNode


} // class BinTreeExample
