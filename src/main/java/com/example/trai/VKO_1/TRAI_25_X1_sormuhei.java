package com.example.trai.VKO_1;

public class TRAI_25_X1_sormuhei implements TRAI_25_X1 {
        // ^^ replace with your own userid here  ^^

        /**
         * SELF-EVALUATION HERE:
         *
         *
         *
         */
        /**
         * Second-smallest element of an array.
         *
         * The input array contains only valid integers (i.e., no null values).
         *
         * @param A Input array
         * @return the second-smallest element, or null if the array is empty or contains only one element.
         */
        @Override
        public Integer secondSmallest(Integer[] A) {

            // Plan your solution first, then implement it.
            // See exercises 3-4 for an example of approach.

            if ( A == null || A.length <= 1 ) {
                return null;
            }

            // asetetaan min muuttuja, jonka avulla etsitään taulukon pienin muuttuja
            int min = A [0];

            /**
             * käydään taulukon alkiot muuuttujan avulla läpi.
             * jos muuttuja k on pienempi kuin  min asetettu arvo
             * -> asetetaan se muuttujaan min
             */
            for (int k = 0; k < A.length ; k++) {
                if (A[k] < min) {
                    min = A[k];
                }
            }

            int secondsmallest = Integer.MAX_VALUE; // asetetaan suurin mahdollinen, jotta alkiot varmasti pienempiä
            int smallesti = Integer.MAX_VALUE;

            for (int i = 0; i < A.length; i++ ) {
                if ( min < secondsmallest ) {
                    secondsmallest = min;
                    smallesti = min;
                }
                else if (secondsmallest >= smallesti) {
                   // secondsmallest = ??;

                }

            return secondsmallest;

            }

            return 0; // TODO


        }

    }

