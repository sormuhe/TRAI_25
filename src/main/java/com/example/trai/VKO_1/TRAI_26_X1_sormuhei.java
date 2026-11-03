package com.example.trai.VKO_1;

import java.util.Objects;

public class TRAI_26_X1_sormuhei implements TRAI_26_X1 {
    //                    ^^^^^ OWN ID HERE
    // Name your file TRAI_26_X1_yourid.java

    /**
     *  SELF-EVALUATION HERE:
     * Aikavativuus O(n^2), koska kaksi sisäkkäistä for-loopia, jotka käyvät pahimmassa tapauksessa jokaisen
     * taulukon alkion läpi
     *
     * Lähden edelleen ajattelemaan ratkaisuja liian monimutkaisesti. Lähdin ensin pohtimaan, että tarvitsen boolean-
     * muuttujan "loytyisama", jonka totuuasarvoa muuttaisin koodin edetessä. Ajattelin myös jotenkin tarvitsevani kaksi
     * erillistä muuttujaa i ja j (jotka olisin määritellyt ensin) ja suorittanut niiden vertailemista.
     * Pitkä koodaamattomuusjakso on vaatinut veronsa, ja muistuttelua kaipaa kovasti.
     **/

    /**
     * Does an array have duplicate(s) or not?
     *
     * If all integers of the array are distinct
     * (or there are only 0 or 1 elements), return false.
     * If some integer(s) occurs two or more times, return true.
     * You may assume all elements to be proper values (not nulls).
     *
     * @param A Input array
     * @return true if some element occurs at least two times, otherwise false
     */
    @Override
    public boolean haveDuplicates(Integer[] A) {

        // TODO

//        boolean loytyisama = false;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (Objects.equals(A[i], A[j])) {
                    return true;
                }
            }
        }

        return false;
    }
}
