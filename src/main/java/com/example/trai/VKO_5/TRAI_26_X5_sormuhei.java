package com.example.trai.VKO_5;

import java.util.HashSet;
import java.util.Set;

public class TRAI_26_X5_sormuhei implements TRAI_26_X5 {
    /**
     * SELF-EVALUATION HERE:
     * Joukkojen joukon läpikäynti vaatii kyllä harjoittelua, lähtee edelleen liian vaikeasti ajattelemaan
     * Loppujen lopuksi kuitenkin pääsi jollain tavalla jyvälle asiasta.
     * Aikavaativuus: O (n +m)?
     * Jokaisen joukon alkiot käydään läpi, sekä jokainen joukko käydään läpi
     *  n = joukkojen lkm
     *  m = alkioiden lkm
     */
    /**
     * Find all those elements that are in all of the sets of inAll,
     * are in at least one of the sets of inSome,
     * and are in none of the sets of inNone.
     * @param inAll     Set of sets, the elements of the result must be in all of these sets.
     * @param inSome    Set of sets, the elements of the result must be in at least one of these sets.
     * @param inNone    Set of sets, the elements of the result may not be in any of these sets.
     * @return          The set containing the elements fulfilling the above requirements.
     * @param <E>       Element type.
     */
    public <E> Set<E> inAllSomeNone(Set<Set<E>> inAll, Set<Set<E>> inSome, Set<Set<E>> inNone) {
        Set<E> result = new HashSet<>();

        // TODO

        // inAll-joukkojen läpikäynti apujoukon avulla
        // jos tulos on tyhjä, lisätään sinne ensimmäisen käsiteltävän joukon alkiot,
        // seuraavilla kierroksilla poistetaan sellaiset alkiot, jotka eivät ole in All-joukoissa

        for (Set<E>  osaJoukkoinAll: inAll) {
            if (result.isEmpty()) {
                result.addAll(osaJoukkoinAll);
            } else {
                result.retainAll(osaJoukkoinAll);
            }
        }

        // käydään apujoukon kanssa läpi inSome-joukot
        // lisätään kaikki alkiot inSomeAlkiot, jonka jälkeen säilytetään
        // yhdiste tuloksesta ja inSomeAlkioista.
        Set<E> inSomeAlkiot = new HashSet<>();

        for (Set<E> osaJoukkoinSome : inSome) {
            inSomeAlkiot.addAll(osaJoukkoinSome);
        }
        result.retainAll(inSomeAlkiot);

        // samalla tavoin inNone-joukot, luodaan apujoukko alkioille,
        // ne jotka ovat myös tuloksissa poistetaan tuloksista
        Set<E> inNoneAlkiot = new HashSet<>();

        for (Set<E> osaJoukkoinNone : inNone) {
            inNoneAlkiot.addAll(osaJoukkoinNone);
        }

        result.removeAll(inNoneAlkiot);

        return result;
    }

}
