package com.example.trai.VKO_3;

import fi.uef.cs.tra.BTreeNode;
//
//public class leveyssyynta {
//
//    BTreeNode<E> n = T.getRoot;
//    queue.offer(n);
//
//    boolean hasLeft = true;
//    boolean hasRight = true;
//
//    if (n.getLeftChild != null) {
//        hasLeft = true;
//    }
//    if (n.getRightChild != null) {
//        hasRight = true;
//    }
//    if (hasLeft && hasRight) {
//        deepest = n
//    }
//
//}

/**
 * AL lista
 *
 * rekursio get Root, lista
 *
 * for loop missä int i = 1, i < AL.size; i++
 *  jos lista get -1, compareTo lista get i <= 0
 *  return false.
 *
 * void rekursio, parametreine BTREENODE puunhaaralistaansisajarjestyksessa ja AL lista --> Tämä on metodi
 *
 * jos solmu == null
 *  * return
 *
 * rekursio(solmu.getElftChild().lista); ensin vasen alipuu läpi, siihen asti kun tulee null ja sen jälkeen ylöspäin
 * lista.add(solmu.getLeftElement());    lista lisää sillä hetkellä käsiteltävän solmun listaan
 * rekursio(solmu.getRightChlid(), lista); rekursio käy läpi oikean alipuun
 */