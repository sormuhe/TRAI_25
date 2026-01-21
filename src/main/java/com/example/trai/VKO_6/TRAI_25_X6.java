package com.example.trai.VKO_6;

import java.util.Map;
import java.util.Set;

public interface TRAI_25_X6 {

    /**
     * Computes which sets are disjoint with each other.
     * The resulting mapping contains as a key each set Si of input SS and as the value
     * a set of all those sets Sj that are disjoint with Si.
     * @param SS input (set of sets)
     * @param <E> element type of sets
     * @return mapping showing the information which sets are disjoint with each other
     */
    public <E> Map<Set<E>, Set<Set<E>>> disjointSets(Set<Set<E>> SS);
}
