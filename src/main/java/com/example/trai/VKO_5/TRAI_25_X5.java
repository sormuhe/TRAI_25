package com.example.trai.VKO_5;

import java.util.Set;

public interface TRAI_25_X5 {

    /**
     * Find those elements that are in all of the sets of inAll,
     * are in at least one of the sets of inSome,
     * and are in none of the sets of inNone.
     *
     * @param inAll  Set of sets, the result elements must be in all of these sets.
     * @param inSome Set of sets, the result elements must be in at least one of these sets.
     * @param inNone Set of sets, the result elements may not be in any of these sets.
     * @param <E>    Element type.
     * @return The set containing the elements fulfilling the above requirements.
     */
    public <E> Set<E> inAllSomeNone(Set<Set<E>> inAll, Set<Set<E>> inSome, Set<Set<E>> inNone);

}
