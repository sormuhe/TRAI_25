package com.example.trai.VKO_5;

// TRAI_26_t21.java SJ

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TRAI_26_t21_skeleton {

    public static void main(String[] args) {

        int N = 10;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        Set<Integer> JS1 = new HashSet<>();
        Set<Integer> JS2 = new HashSet<>();
        Set<Integer> JS3 = new HashSet<>();

        Random r = new Random(42);
        Integer x, y;
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N + 2);
            y = r.nextInt(N + 2);
            JS1.add(x);
            JS2.add(x - y);
            JS3.add(x + y);
        }

        System.out.println("S1:      " + JS1);
        System.out.println("S2:      " + JS2);
        System.out.println("S3:      " + JS3);

        System.out.println("oneInTreeJava: " + oneInThree(JS1, JS2, JS3));

    } // main()




    public static <E> Set<E> oneInThree(Set<E> s1, Set<E> s2, Set<E> s3) {


        Set<E> result = new HashSet<>();

        // TODO

        Set<E> kopioS1 = new HashSet<>(s1);
        Set<E> kopioS2 = new HashSet<>(s2);
        Set<E> kopioS3 = new HashSet<>(s3);

        kopioS1.addAll(s1);
        kopioS1.removeAll(s2);
        kopioS1.removeAll(s3);

        kopioS2.addAll(s2);
        kopioS2.removeAll(s1);
        kopioS2.removeAll(s3);

        kopioS3.addAll(s3);
        kopioS3.removeAll(s1);
        kopioS3.removeAll(s2);

        result.addAll(kopioS1);
        result.addAll(kopioS2);
        result.addAll(kopioS3);

        return result;
    }
} //
