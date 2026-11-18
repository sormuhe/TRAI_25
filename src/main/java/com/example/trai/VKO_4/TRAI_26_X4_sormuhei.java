package com.example.trai.VKO_4;

import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

import java.util.ArrayList;

public class TRAI_26_X4_sormuhei implements TRAI_26_X4 {

    /**
     * SELF-EVALUATION HERE:
     *
     *
     *
     */

    /**
     * Are the elements of a tree in in-order or not.
     * You may write additional methods as well as long as you keep this method header unchanged.
     *
     * @param T   binary tree to check
     * @param <E> element type
     * @return true if the elements are in in-order, false otherwise
     */
    @Override
    public <E extends Comparable<? super E>> boolean isInOrdered(BTree<E> T) {
        // TODO
        BTreeNode<E> juuri = T.getRoot();

        if (juuri == null) {
            return true;
        }

        ArrayList edellinen = new ArrayList(1);             // yhden alkion taulukko

        return sisaJarjestys(juuri, edellinen);         // rekursiivinen kutsu aliohjelmalle

    }

    private <E extends Comparable<? super E>> boolean sisaJarjestys(BTreeNode<E> solmu, ArrayList edellinen) {

        if (solmu == null) {
            return true;
        }

        // vasen alipuu
        if (!sisaJarjestys(solmu.getLeftChild(), edellinen)) {
            return false;
        }

        E nykyinen = solmu.getElement();

        if ( edellinen.get(0) != null) {
            E aiempi = (E) edellinen.get(0);

            if (nykyinen.compareTo(aiempi) < 0) {
                return false;
            }
        }

        edellinen.set(0, nykyinen);

        return true;
    }


        //return onsisajarjestyksessa;

}

//private <E extends Comparable<? super E>> boolean sisaJarjestys(BTreeNode<E> solmu, ArrayList edellinen) {
//
//    if (solmu == null) {
//        return true;
//    }
//
//    // vasen alipuu
//    if (!sisaJarjestys(solmu.getLeftChild(), edellinen)) {
//        return false;
//    }
//
//    E nykyinen = solmu.getElement();
//
//    if ( edellinen != null) {
//
//        E aiempi = (E) nykyinen;
//
//        if (nykyinen.compareTo(aiempi) < 0) {
//            return false;
//        }
//    }
//
//    return true;
//}