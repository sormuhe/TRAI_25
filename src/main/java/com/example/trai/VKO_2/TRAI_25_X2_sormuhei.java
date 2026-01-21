package com.example.trai.VKO_2;

import com.example.trai.VKO_2.TRAI_25_X2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class TRAI_25_X2_sormuhei implements TRAI_25_X2 {

    /**
     * SELF-EVALUATION HERE:
     *
     * Tehtävä oli varsin haastava. En ole todellakaan hyvä koodaamaan, ja tämä kurssi vie oppimiseni sekä
     * osaamiseni äärirajoille.
     *
     * Ensin yritin käyttää toimintoja hasNExt ja next, mutta koska
     * tyhjien listojen tarkastus sekä hasNextin vaatiminen jokaisella kerralla kun kasvatetaan nextiä ei taipunut
     * käsissäni koodiksi mitenkään. Tai jos olisi taipunut, olisi koodi vaatinut monta sisäkkäistä
     * if-loopia, eikä se olisi ollut kovin tehokasta.
     *
     * Vertaisten avulla sekä kyselemällä tekoälyltä kysymyksiä sain lopulta vaikeuksien kautta lopulta koodin
     * toimimaan ja ymmärrän sen toiminnan. Tahtoisin korostaa, etten pyytänyt missään vaiheessa tekoälyltä valmista
     * koodia käyttööni, vaan pyysin sen kertomaan kuinka pointereita käytetään, kuinka niillä edetään ym.
     * Lopulta, kun koodini lisäsi vain indeksejä listaan eikä alkioita, syötin koodini tekoälylle, joka kertoi,
     * että ainoastaan lisäystoimintoni oli siinä vaiheessa enää väärin.
     *
     * Voisin sanoa, että taitoni ja ymmärrykseni on todella loivassa nousussa viime vuoteen verrattuna.
     * Uskoisin, että pystyn kuitenkin kurssin edetessä kehittymään koodaamisen sekä algoritmin suunnittelussa,
     * jotta kurssin läpäisy voisi olla edes mahdollisesti mahdollista.
     *
     * Jätin kommentteihin räpellyksiä, huonot yritykseni ja onnistumisen.
     *
     */

    /**
     * Difference of two lists that are in ascending order.
     *
     * Returns a new list that contains all the elements that are in list A and in list B,
     * If an element is in A and B several times, it will be in the result list as many times
     * as in the list that has fewer occurrences.
     * Result list will be in ascending order.
     * If either of the lists is not in ascending order, result can be anything.
     * @param A first input list, elements in ascending order
     * @param B second input list, elements in ascending order
     * @return intersection list, elements in ascending order
     */
    public ArrayList<Integer> intersectionOfGrowingLists(ArrayList<Integer> A, ArrayList<Integer> B) {

        ArrayList<Integer> result = new ArrayList<>();

//        Iterator<Integer> l = A.iterator();
//        Iterator<Integer> k = B.iterator();

//        if (!l.hasNext() || !k.hasNext()) {           //jos jompikumpi listoista on tyhjä, palautetaan tyhjä taulukko
//            return result;
//        }

        // kaksi osoitinta, yksi molempien listojen alkuun oma
        int i = 0;
        int j = 0;


        /**
         * Jos i:n tai j:n arvo on pienempi kuin listan koko
         *  -> jos A:asta haettu listan alkio on samankokoinen kuin B:stö haettu listan arvo
         *          lisätään A:sta haettu alkio i tuloslistaan
         *          kasvatetaan sekä i:n ja j:n arvoa
         *     jos A:sta saatu arvo on pienempi kuin listasta B saatu arvo
         *          kasvatetaan i:n arvoa yhdellä - siirrytään A listassa eteenpäin
         *     muutoin kasvatetaan j:n arvoa
         *
         *     Algoritmin aikavaativuus on O(n+m) ?
         *      - käydään listan A koko läpi = n
         *      - käydään listan B koko läpi = m
         *      - pahimmillaan käydään molempien listojen kaikki alkiot kerran läpi
         *      - ArrayListin operaatiot .add(), .get() ovat vakioaikaisia O(1)
         */
        while ( i < A.size() && j < B.size()) {
            if (Objects.equals(A.get(i), B.get(j))) {
                result.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i = i+1;
            } else {
                j = j+1;
            }
        }


//        while (l.hasNext() == true && k.hasNext() == true) {
//            if (l.next().equals(k.next)) {
//                result.add(i); ???
//    int a = A.get(i);
//            int b = B.get(j);
//
//            if ( a  < b ) {
//                i++;                        // ei olla leikkauspisteessä, kasvata i:tä
//            }
//            if (a > b) {
//                j++;                        // ei olla leikkauspisteessä, kasvata j:tä
//            }
//            if (a == b) {
//                result.add(i);
//                i++;
//                j++;
//            } else {
//                break;
//            }
//        }

        return result;
    }

}
