package com.example.trai.VKO_4;

import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

import java.util.ArrayList;

public class TRAI_25_X4_sormuhei implements TRAI_25_X4 {
    //                   ^^^^^
    //                   own userid here

    /**
     * SELF-EVALUATION HERE:
     *
     * Aluksi ei ollut mitään ymmärrystä puun käyttämisestä, koska viime viikon
     * tehtäviä ei tullut tehtyä.
     * Ohjauksessa sain apua ja selitystä rekursiivisuuteen sekä ohjaajalta
     * että vertaisilta, jotta sain lopulta koodin toimimaan.
     *
     */

    /**
     * Do two in-ordered binary trees contain the same elements or not?
     *
     * @param T1  in-ordered binary tree to check
     * @param T2  in-ordered binary tree to check
     * @param <E> element type
     * @return true if both binary trees contain the same elements, false otherwise
     */
    @Override
    public <E extends Comparable<? super E>> boolean haveSameElements(BTree<E> T1, BTree<E> T2) {
        // TODO

        BTreeNode<E> n = T1.getRoot();                       // haetaan juurisolmu muuttujaan n
        BTreeNode<E> o = T2.getRoot();                       // haetaan juurisolmu muuttujaan 0

        ArrayList<E> AL1 = new ArrayList<>();               // luodaan lista AL1
        ArrayList<E> AL2 = new ArrayList<>();               // luodaan lista AL2

        // jos molemmat puut ovat tyhjiä, palauttaa truen
        if (T1 == null && T2 == null) {
            return true;
        }

        // jos toinen puista on tyhjä -- false
        if (T1 == null || T2 == null) {
            return false;
        }

        // käytetään apumetodia, lisätään puusta T1 listaan AL1
        lisataanListaan(n, AL1 );
        // käytetään apumetodia, lisätään puusta T2 listaan AL2
        lisataanListaan(o, AL2);

        // jos lista AL1 on sama kuin AL2, palauttaa truen, muutoin false
        if (AL1.equals(AL2)) {
            return true;
        } else {
            return false;
        }

    }

public static <E> void lisataanListaan(BTreeNode<E> solmu,  ArrayList<E> AL ) {

    if (solmu == null)
        return;

    lisataanListaan(solmu.getLeftChild(),AL);
    AL.add(solmu.getElement());
    lisataanListaan(solmu.getRightChild(), AL);

}


}