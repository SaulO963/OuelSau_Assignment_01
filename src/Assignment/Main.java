/**
 * Name: Saul Ouellet
 * Date: Feb 1st 2022
 * Description: A bunch of random array manipulations including equality checks, copying, summing, checking the
 * Hamming distance, and a good ol recursive binary search. Also implemented a scanner to check hamming distance of
 * 2 user inputted strings.
 */

package Assignment;

/***
 * Main is used as our testing area for our Array class
 */
public class Main {

        /***
         * it's a main function, what else is there to say?
         * @param args supplies arguments to the main function.
         */
        public static void main(String[] args){
                int test1[] = {0,1,2,3,4,5,6,7,8,9};
                int test2[] = {0,1,2,3,4,5,6,7,8,9};
                int test3[] = {1};
                int test4[] = {2};
                int test5[] = {9,8,7,6,5,4,3,2,1,0};
                int test6[][] = {
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11,12,13,14,15},
                };

                System.out.println("==================== Q1 Equality testing ====================");

                Array.equal(test1,test2);   //should be true
                Array.equal(test2,test3);   //not same length == false
                Array.equal(test3,test4);   //should be false

                System.out.println("==================== Q2 Copying testing ====================");

                int[] check1 = Array.slice(test1,0,10); //slices whole array
                int[] check2 = Array.slice(test1,4,9);  //slices part of array
                int[] check3 = Array.slice(test1,7,11); //fails -- out of index reach
                Array.display(check1);
                Array.display(check2);

                System.out.println("==================== Q3 Sum testing ====================");

                Array.sumMatrix(test6);

                System.out.println("==================== Q4 Hamming Distance testing ====================");

                Array.hamDis(test1,test5);

                System.out.println("==================== Q5 Binary Search testing ====================");

                Array.binSearch(9,test2);

                System.out.println("==================== Q6 User Input Hamming Distance testing ====================");

                Array.hamDisScan();

    }

}
