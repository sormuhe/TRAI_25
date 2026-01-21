package com.example.trai.VKO_6;

import java.util.*;

public class TRAI_25_X6_sormuhei implements TRAI_25_X6 {

    /**
     * SELF-EVALUATION HERE:
     * Tämän viikon X oli todella vaikea, mutta niin oli viimekin viikolla. Tällä viikolla käytin enemmän aikaa
     * asian ymmärtämiseen ja tutkimiseen. Monen youtube-videon jälkeen ehkä ymmärsin joukkoja hieman paremmin.
     * Pyysin tekoälyä käymään läpi joukkojen läpikäymisen tarkasti ja selittäen, kuitenkaan ratkaisua pyytämättä.
     * Se selvensi hieman, ja sain raavittua kasaan hieman koodia, joka ei kuitenkaan päässyt loppuun asti.
     * Aloin tekemään tehtäviä liian myöhään, enkä ehtinyt tutkia asiaa tarpeeksi, jotta olisin saanut täysin toimivan
     * algoritmin kasaan.
     */

    /**
     * Computes which sets are disjoint with each other.
     * The resulting mapping contains as a key each set Si of input SS and as the value
     * a set of all those sets Sj that are disjoint with Si.
     * @param SS input (set of sets)
     * @param <E> element type of sets
     * @return mapping showing the information which sets are disjoint with each other
     */
    @Override
    public <E> Map<Set<E>, Set<Set<E>>> disjointSets(Set<Set<E>> SS) {
                                                                // yksi joukon Set<Set<E>> alkioista on joukko Set<E>
        Map<Set<E>, Set<Set<E>>> result = new HashMap<>();      // --> apujoukon oltava samaa tyyppiä

       Set<Set<E>> eivatOleSamoja = new HashSet<>();            // luodaan joukkojen joukko, johon lisätään joukot,
                                                                // jotka eivät sisällä samoja alkioita

        for ( Set<E> apustaja1 : SS) {                          // otetaan jokin joukko SS:stä, jolle toistetaan
            for (Set<E> apustaja2 : SS) {                       // otetaan seuraava joukko SS:stä, jolle

                Set<E> apuJouko = new HashSet<>(apustaja1);     // luodaan apujoukko, johon kopioidaan ulomman silmukan
                                                                // läpikäytävä joukko apustaja1

                if (apuJouko == apustaja2) {                    // tarkastellaan, ettei vertailtavat joukot ole samoja
                    // jos olisivat samat tehdään jotain?
                }

                apuJouko.retainAll(apustaja2);                  // säilyttää alkiot, jotka ovat joukossa apustaja2
                                                                // joukkojen apuJouko ja apustaja2 leikkaus!

                if (apuJouko.isEmpty()) {                       // jos apujoukko tyhjä
                    eivatOleSamoja.add(apustaja2);              // lisätään apustaja2 niihin joukkoihin,
                                                                // joissa ei ole samoja alkioita kuin apustaja1-joukossa
                }
            }
        }



        return result;
    }
}