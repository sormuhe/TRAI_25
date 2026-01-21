package com.example.trai.VKO_5;

// TRAI_24_X5_test.java SJ

import java.util.*;

public class TRAI_25_X5_test {


    static TRAI_25_X5 mySolution = new TRAI_25_X5_sormuhei(); /* <-- Own user-id here */
    static int print = 4;

    public static void main(String[] args) {

        int N = 5;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        int seed = N;
        if (args.length > 0)
            seed = Integer.parseInt(args[1]);

        if (args.length > 0)
            print = Integer.parseInt(args[2]);

        Random r = new Random(seed);

        boolean ok = true;

        // test some smallish sets
        ok &= testX5(r, 0, 0, 0, print);
        ok &= testX5(r, 1, 2, 1, print);
        ok &= testX5(r, 2, 2, 1, print);
        ok &= testX5(r, 3, 10, 2, print);
        ok &= testX5(r, 4, 10, 2, print);
        ok &= testX5(r, 5, 15, 3, print);

        ok &= testX5(r, 0, 0, 0, print);



        // test larger inputs, until it is too slow

        long start = System.currentTimeMillis();
        int n = 16;
        while (n <= 1_024 && System.currentTimeMillis() < start+5_000) {
            ok &= testX5(r, n, 10*n, 10, print);
            n *= 2;
        }


        if (ok)
            System.out.println("\n All tests ok");
        else
            System.out.println("\n Some errors");


    } // main()

    /**
     * Test X5 method with given input size
     *
     * @param r          random number generator
     * @param sets       S1 size
     * @param elements   S2 size
     * @param resultSize S3 size
     * @param print
     * @return true if results were correct, false otherwise
     */
    static boolean testX5(Random r, int sets, int elements, int resultSize, int print) {

        if (print > 0)
            System.out.println("\nTesting sets~" + sets + ", elem/set~" +
                    elements + ", resultsize~" + resultSize);
        boolean ok = true;

        Set<Set<Integer>> inAll = new HashSet<>();
        Set<Set<Integer>> inSome = new HashSet<>();
        Set<Set<Integer>> inNone = new HashSet<>();
        Set<Integer> expected = new HashSet<>();

        generateInput(r, sets, elements, resultSize, inAll, inSome, inNone, expected);

        printInput(inAll, inSome, inNone, print);
        if (print > 1 && expected.size() <= 10 || print > 5)
            System.out.println("Expected = " + expected);

        Set<Integer> result = mySolution.inAllSomeNone(inAll, inSome, inNone);

        if (print > 1 && expected.size() <= 10 || print > 5)
            System.out.println("Result   = " + result);

        ok = expected.equals(result);
        if (print > 0) System.out.println("Test ok: " + ok);

        return ok;

    }


    static void printSetSet(Set<Set<Integer>> sets, int print) {
        int elements = sumSize(sets);
        if (print > 5 || elements <= 40)
            System.out.println(sets);
        else
            System.out.println(sets.size() + " sets, " + elements + " elements");
    }
    static void printInput(Set<Set<Integer>> inAll, Set<Set<Integer>> inSome,
                           Set<Set<Integer>> inNone, int print) {
        if (print < 2)
            return;
        System.out.print("inAll:");
        printSetSet(inAll, print);

        System.out.print("inSome:");
        printSetSet(inSome, print);

        System.out.print("inNone:");
        printSetSet(inNone, print);
    }

    static int sumSize(Set<Set<Integer>> sets) {
        int sum = 0;
        for (Set<Integer> set : sets) {
            sum += set.size();
        }
        return sum;
    }

    static boolean generateInput(Random r, int sets, int elements, int resSize,
                                 Set<Set<Integer>> inAll, Set<Set<Integer>> inSome,
                                 Set<Set<Integer>> inNone, Set<Integer> result)  {
        inAll.clear();
        inSome.clear();
        inNone.clear();
        result.clear();

        ArrayList<Set<Integer>> listAll = new ArrayList<>();
        ArrayList<Set<Integer>> listSome = new ArrayList<>();
        ArrayList<Set<Integer>> listNone = new ArrayList<>();

        // put some random elements
        for (int i = 0; i < sets; i++) {
            listAll.add(new HashSet<>());
            listSome.add(new HashSet<>());
            listNone.add(new HashSet<>());
            for (int j = 0; j < elements; j++) {
                listAll.get(i).add(r.nextInt(elements + 1));
                listSome.get(i).add(r.nextInt(elements *3));
                listNone.get(i).add(r.nextInt(elements/2 + 1));
            }
        }

        Set<Integer> res = new HashSet<>();
        // preliminary result
        int kk = resSize;
        while (kk > 0) {
            if (res.add(r.nextInt(resSize + resSize*2)))
                kk--;
        }

        // ensure elements of pre result
        for (int i = 0; i < sets; i++) {
            listAll.get(i).addAll(res); // add to all inAll
            listNone.get(i).removeAll(res); // remove from all inNone
        }

        // add to one or more of inSome
        if (sets > 0) {
            for (Integer i : res) {
                do {
                    int set = r.nextInt(sets);
                    listSome.get(set).add(i);
                } while (r.nextBoolean());
            }
        }

        // create input sets from lists
        for (int i = 0; i < sets; i++) {
            inAll.add(listAll.get(i));
            inSome.add(listSome.get(i));
            inNone.add(listNone.get(i));
        }

        result.addAll(inAllSomeNoneUsingMaps(inAll, inSome, inNone));

        return true;
    }


    public static <E> Set<E> inAllSomeNoneUsingMaps(Set<Set<E>> inAll, Set<Set<E>> inSome, Set<Set<E>> inNone) {
        Map<E, Integer> all = occ(inAll);
        Map<E, Integer> some = occ(inSome);
        Map<E, Integer> none = occ(inNone);
        Iterator<Map.Entry<E, Integer>> it = all.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<E, Integer> entry = it.next();
            if (entry.getValue() < inAll.size() ||
                    !some.containsKey(entry.getKey()) ||
                    none.containsKey(entry.getKey()))
                it.remove();
        }

        return new HashSet<>(all.keySet());
    }
    public static <E> HashMap<E, Integer> occ(Set<Set<E>> CC) {
        HashMap<E, Integer> es = new HashMap<>();
        for (Set<E> C : CC)
            for (E x : C)
                es.merge(x, 1, Integer::sum);
        return es;
    }


    /**
     * Palauttaa satunnaisen len mittaisen merkkijonon.
     *
     * @param r   satunnaislukugeneraattori
     * @param len merkkijonon pituus
     * @return uusi merkkijono
     */
    public static String randomString(Random r, int len) {
        char[] C = new char[len];
        for (int i = 0; i < len; i++)
            C[i] = (char) (r.nextInt(26) + 'a');
        return new String(C);
    }


} // class TRAI_24_X5_test
