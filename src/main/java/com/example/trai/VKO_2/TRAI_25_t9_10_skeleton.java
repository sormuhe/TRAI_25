package com.example.trai.VKO_2;
import java.util.*;


/**
 * 8. Carefully design an algorithm that takes as its parameters two unsorted lists A and B (ArrayList), and removes
 * from list A all those elements that appear in list B. The algorithm returns the number of removed elements. In this
 * case, no new list is created; instead, the given parameter list is modified. Do not use the built-in remove(Object)
 * or removeAll() operations. First, draw a diagram of the problem, then clearly write down the solution principle in
 * English. After this, start refining the solution principle into a more precise algorithm in 1â€“3 steps so that the
 * final solution principle is described very precisely and can be mechanically converted into a working subroutine. Do
 * not modify the input list B. What is the time complexity of your algorithm? Could it be improved?
 *
 * 9. Implement in Java the algorithm you designed in the previous task 8. The parameters are two unsorted lists A and B
 * (ArrayList), and the algorithm removes from list A all those elements that appear in list B. The algorithm returns
 * the number of removed elements. In this case, no new list is created; instead, the given parameter list is modified.
 * Do not use the built-in remove(Object) or removeAll() operations. What is the time complexity? How could the time
 * complexity be improved?
 *
 * 10. Write an algorithm that takes as its parameters two unsorted lists A and B (LinkedList), and removes from list A
 * all those elements that appear in list B. The algorithm returns the number of removed elements. In this case, no new
 * list is created; instead, the given parameter list is modified. Do not use the built-in remove(Object) or removeAll()
 * operations. What is the time complexity? How could the time complexity be improved?
 */

public class TRAI_25_t9_10_skeleton {


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

        int removed = removeAll9(AL1, AL2);

        System.out.print("Task 9, AL1\\AL2: removed " + removed + " elements, remaining elements: ");
        if (n1 <= 20 && n2 <= 20) {
            System.out.println(AL1);
        } else {
            System.out.println(AL1.size() + " elements");
        }

        // test task 10

        removed = removeAll10(LL1, LL2);

        System.out.print("Task 10, LL1\\LL2: removed " + removed + " elements, remaining elements ");
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
     * Remove in A all the elements of B, retain all other elements.
     *
     * @param A list to be modified.
     * @param B elements to remove
     * @return number of elements removed
     */
    public static <E> int removeAll9(ArrayList<E> A, ArrayList<E> B) {

        int removed = 0;
        int writehead = 0;  // kirjoitetaan päälle

        Set<E> bSet = new HashSet<>(B);     // O(n)

        for (int readHead = 0; readHead < A.size();) {
            if (!bSet.contains(A.get(readHead))) {
                A.set(writehead, A.get(readHead));
                writehead++;
            } else {
                removed++;
            }
            readHead++;
        }

        for (int i = 0; i < removed; i++) {
            A.remove(A.size()-1);       //remove last
        }

        return removed;

    }

    /**
     * Remove in A all the elements of B, retain all other elements.
     *
     * @param A list to be modified.
     * @param B elements to remove
     * @return number of elements removed
     */
    public static <E> int removeAll10(LinkedList<E> A, LinkedList<E> B) {
        int removed = 0;
        ListIterator<E> iteraattori = A.listIterator();     //iteraattori

        while (iteraattori.hasNext()) {                     // käydään läpi niin kauan kuin iter. löytää alkioita
            E elementti = iteraattori.next();               // haetaan seuraava alkio ja tallennetaan se muuttujaan
            boolean poistaa = false;

            for (int j = 0; j < B.size(); j++) {            // käydään toinen kokoelma läpi
                E nykyinen = B.get(j);
                if (elementti.equals(nykyinen)) {           // jos käsiteltävä alkio on sama kuin B-listan alkio
                    poistaa = true;                         // poistetaan alkio
                    break;
                }
            }
            if (poistaa) {                                  // jos alkio poistettiin
                iteraattori.remove();                       // poistetaan alkio iteraattorin kautta
            }
        }

        return removed;
    }


} // class

