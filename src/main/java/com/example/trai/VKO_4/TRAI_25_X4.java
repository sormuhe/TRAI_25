package com.example.trai.VKO_4;

import fi.uef.cs.tra.BTree;

public interface TRAI_25_X4 {

    /**
     * Do two in-ordered binary trees contain the same elements or not.
     *
     * @param T1  in-ordered binary tree to check
     * @param T2  in-ordered binary tree to check
     * @param <E> element type
     * @return True, if both binary trees contain the same elements, false otherwise.
     */
    public <E extends Comparable<? super E>> boolean haveSameElements(BTree<E> T1, BTree<E> T2);

}