package com.example.trai.VKO_2;


import java.util.*;


/**
 * 8. Carefully design an algorithm that takes two unsorted lists A and B (ArrayList)
 * as parameters and removes from list A all elements that do not appear in list B. The
 * algorithm returns the number of elements removed. Thus, no new list is created; instead,
 * the parameter list is modified. Do not use the predefined remove(Object) or retainAll()
 * operations. First, draw a diagram of the problem, then clearly write down the solution
 * principle in English. After that, start refining the solution principle into a more precise
 * algorithm in 1-3 steps, ensuring that the final solution principle is described very precisely
 * and can be mechanically converted into a working subroutine. Do not modify the input
 * list B. What is the time complexity of your algorithm? Could it be improved? Hint for
 * improvement: create a set (HashSet) from list B, and use contains -operaation.
 * <p>
 * 9. Write an algorithm that takes two unsorted lists A and B (ArrayList) as parameters and
 * removes from list A all elements that do not appear in list B. Do not use the predefined
 * retainAll() operation. What is the time complexity? How could the time complexity be
 * improved? You will get the most out of this task if you make it work in linear time by
 * utilizing set as a helper. Use operations that are efficient for ArrayList.
 * <p>
 * 10. Write an algorithm that takes two unsorted lists A and B (LinkedList) as parameters and
 * removes from list A all elements that do not appear in list B. Do not use the predefined
 * retainAll() operation. What is the time complexity? How could the time complexity be
 * improved? You will get the most out of this task if you make it work in linear time by
 * utilizing set as a helper. Use operations that are efficient for LinkedList.
 */

public class TRAI_26_t9_10_skeleton {


    public static void main(String[] args) {

        // input sizes
        int n1 = 10;
        if (args.length > 0)
            n1 = Integer.parseInt(args[0]);

        int n2 = n1 + 2;
        if (args.length > 1)
            n2 = Integer.parseInt(args[1]);

        int len = 1; // string lengths
        if (n1 > 30)
            len = 2;

        // random number seed
        int seed = 42;
        if (args.length > 2)
            seed = Integer.parseInt(args[2]);


        // use strings this time

        ArrayList<String> AL1 = new ArrayList<>(n1);
        ArrayList<String> AL2 = new ArrayList<>(n2);

        // fill with elements
        Random r = new Random(seed);
        for (int i = 0; i < n1; i++) {
            AL1.add(randomString(r, len));
        }

        for (int i = 0; i < n2; i++) {
            AL2.add(randomString(r, len));
        }

        // print intput
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("AL1: " + AL1);
            System.out.println("AL2: " + AL2);
        }

        // take copies for task 10
        LinkedList<String> LL1 = new LinkedList<>(AL1);
        LinkedList<String> LL2 = new LinkedList<>(AL2);


        // test task 9

        int removed = retainAll9(AL1, AL2);

        System.out.print("Task 9, AL1^AL2: removed " + removed + " elements ");
        if (n1 <= 20 && n2 <= 20) {
            System.out.println(AL1);
        } else {
            System.out.println(AL1.size() + " elements");
        }

        // test task 10

        removed = retainAll10(LL1, LL2);

        System.out.print("Task 10, LL1^LL2: removed " + removed + " elements ");
        if (n1 <= 20 && n2 <= 20) {
            System.out.println(LL1);
        } else {
            System.out.println(LL1.size() + " elements");
        }


    } // main()


    /**
     * Returns a random string of length len
     *
     * @param r   random number generator
     * @param len string length
     * @return new string
     */
    public static String randomString(Random r, int len) {
        char[] C = new char[len];
        for (int i = 0; i < len; i++)
            C[i] = (char) (r.nextInt(26) + 'a');
        return new String(C);
    }


    /**
     * Retain in A all the elements of B, remove all other elements.
     *
     * @param A list to be modified.
     * @param B elements to retain
     * @return number of elements removed
     */
    public static <E> int retainAll9(ArrayList<E> A, ArrayList<E> B) {

        int removed = 0;
        int i = 0;

        while (i < A.size()) {

            boolean loytyi = false;
            int j = 0;

            while (j < B.size()) {
                if (A.get(i).equals(B.get(j))) {
                    loytyi = true;
                    break;
                }
                    j++;
            }

            if (!loytyi) {
                A.remove(i);
                removed++;
            } else {
                i++;
            }
        }


        // hint: if you put the content of B to a HashSet (will be showed later in the course),
        // then HashSet.contains(Object) is constant time!
        // Set<E> Bcopy = new HashSet(B);
        // if (Bcopy.contains(x)) ... // O(1)!

        return removed;
    }

    /**
     * Retain in A all the elements of B, remove all other elements.
     *
     * @param A list to be modified.
     * @param B elements to retain
     * @return number of elements removed
     */
    public static <E> int retainAll10(LinkedList<E> A, LinkedList<E> B) {
        int removed = 0;
        Set<E> Bcopy = new HashSet(B);

        boolean loytyi = false;

        Iterator <E> iteraattori = A.iterator();
        // hint: if you put the content of B to a HashSet (will be showed later in the course),
        // then HashSet.contains(Object) is constant time!
        while (iteraattori.hasNext()) {
            E alkio = iteraattori.next();

            if (Bcopy.contains(alkio)) {
                loytyi = true;
                // O(1)!
            }
            else {
                iteraattori.remove();
                removed++;
            }
        }


        return removed;
    }


} // class
