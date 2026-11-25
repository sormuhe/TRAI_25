package com.example.trai.VKO_5;

// TRAI_26_t23.java SJ

import java.util.*;
import java.util.Map;
import java.util.HashMap;


public class TRAI_26_t23_skeleton {

    public static void main(String[] args) {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter two strings (. . to stop): ");
            String A = sc.next();
            String B = sc.next();
            if (A.equals(".") || B.equals(".")) break;

            System.out.println("Are anagrams?: " + areAnagrams(A, B));
        }
    } // main()

    /**
     * 23. Write an efficient algorithm that checks whether two strings are anagrams of each other
     * (that is, whether one can be transformed into the other merely by rearranging the letters). In
     * other words, do the strings contain the same number of occurrences of each distinct letter? The
     * algorithm takes two strings as parameters and returns a boolean. Hint: Use a map to count the
     * occurrences of each letter. Since we are practising the use of maps, do not use the easy
     * approach of converting the strings to arrays, sorting them, and comparing them. What is the
     * time complexity of your algorithm?
     *
     * @param A input string
     * @param B input string
     * @return true if A and B are anagrams, false otherwise
     */
    public static boolean areAnagrams(String A, String B) {
        // TODO

        boolean onanagrammit = true;

        Map<Character, Integer> laskuri = new HashMap<>();

        if (A.length() != B.length()) return false; // jos merkkijonot ei yhtäpitkät --> false

        for (int i = 0; i < A.length(); i++) {
            if (laskuri.containsKey(A.charAt(i))) {
                laskuri.put(A.charAt(i), laskuri.get(A.charAt(i)) + 1);
            } else {
                laskuri.put(A.charAt(i), 1);
            }
        }

        for (int j = 0; j < B.length(); j++) {
            if (laskuri.containsKey(B.charAt(j))) {
                laskuri.put(B.charAt(j), laskuri.get(B.charAt(j)) - 1);
            } else {
                return false;
            }
        }

        return onanagrammit;
    }

    /**
     * Character list out of string.
     *
     * @param s input string
     * @return list of Characters in the list
     */
    static List<Character> stringToCharacterList(String s) {
        char[] ca = s.toCharArray();
        List<Character> AL = new ArrayList<>(s.length());
        for (char c : ca) AL.add(c);
        return AL;
    }
} // class
