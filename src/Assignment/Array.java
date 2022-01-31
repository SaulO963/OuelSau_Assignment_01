package Assignment;

import java.util.Scanner;

/***
 * class used to do various array manipulations.
 */
public class Array {

    /***
     * function displays 1D array using a for loop
     * @param intArr supplies 1D int array to function
     */
    public static void display(int intArr[]){
        System.out.print("[");
        for(int i = 0; i < intArr.length; i++){
            System.out.print(intArr[i]);
            if(i != intArr.length-1)
                System.out.print(", ");
        }
        System.out.print("]\n");
    }

    /***
     * function checks to see if 2 1D arrays are equal by comparing each element. If an inconsistency
     * is found, prints the index at which it is found.
     * @param a supplies first 1D array to function
     * @param b supplies second 1D array to function
     * @return returns a boolean
     */
    public static boolean equal(int[] a, int[] b){
        if(a.length != b.length){
            System.out.println("Arrays are not the same length! Returning false");
            return false;
        }
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]) {
                System.out.println("Elements aren't equal at index " + i + ", returning false");
                return false;
            }
        }
        System.out.println("Arrays are equal, returning true");
        return true;
    }

    /***
     * Function copies a portion of a given array
     * @param a supplies initial 1D array to function
     * @param start start index from where to begin the copy
     * @param upto end index from where the copy will end (up to but not including)
     * @return returns an int array
     */
    public static int[] slice(int[] a, int start, int upto){
        if(upto > a.length || start < 0){
            System.out.println("Start can't be negative, and end can't be larger than length of ori" +
             "ginal array! Returning null.");
            return null;
        }
        int result[] = new int[upto-start];  //initialize result, size is difference between end/start
        for(int i = 0; i < upto-start; i++){
            result[i] = a[start+i];
        }
        return result;
    }

    /***
     * function will sum all the rows in a given 2D array (or matrix)
     * @param a supplies function with 2D int array
     * @return function returns an int of the sum
     */
    public static int sumMatrix(int[][] a){
        int sum = 0;
        for(int i = 0; i < a.length; i++)
            for(int j = 0; j < a[i].length; j++){
                sum += a[i][j];
            }
        System.out.println(sum);

        return sum;
    }

    /***
     * function will find hamming distance of 2 given int arrays (aka how many corresponding
     * positions in both arrays
     * are different)
     * @param a supplies first 1D int array
     * @param b supplies second 1D int array
     * @return returns hamming distance as an int
     */
    public static int hamDis(int []a, int []b){
        if(a.length != b.length){
            System.out.println("Array lengths not equal! Returning 0.");
            return 0;
        }
        int count = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                count++;
            }
        }
        System.out.println("Hamming Distance: " + count);
        return count;
    }

    /***
     * function will prompt user to enter 2 string inputs in the form of an int array, convert the
     * strings to int arrays, run them through the hamDis function, then return the result.
     * @return returns the int hamming distance of 2 int arrays
     */
    public static int hamDisScan(){
        System.out.println("Enter int arrays you would like to check. Input of format should be:1 2 3" +
         " 54 101 ...");
        System.out.println("Array 1: ");
        Scanner sc = new Scanner(System.in);    //initialize Scanner object
        String array1 = sc.nextLine();          //Get our next line as a String
        System.out.println("Array 2: ");
        String array2 = sc.nextLine();          //Get our other line as a String

        String[] a = array1.split(" ");  //Split String into array with whitespace divider
        int[] a1 = new int[a.length];
        for(int i = 0; i < a1.length; i++){     //Populate int array, parsing each String as an int
            a1[i] = Integer.parseInt(a[i]);
        }

        String[] b = array2.split(" ");
        int[] b1 = new int[b.length];
        for(int i = 0; i < b1.length; i++){
            b1[i] = Integer.parseInt(b[i]);
        }

        int check = hamDis(a1,b1);              //throw these sons of guns over to good ol hamDis

        return check;
    }

    /***
     * function is 1st step to a binary search given a key and an array. Used to set up recursive search
     * function more easily so we only need to provide a key and an int rather than the start and end
     * as well.
     * @param key supplies search with key element to search for in array
     * @param a supplies search with the 1D (presorted) int array.
     * @return returns boolean if key was found or not
     */
    public static boolean binSearch(int key, int a[]){
        return (search(key, a, 0,a.length));
    }

    /***
     * function is 2nd step to binary search given a key, an array, a start, and an end. Function will do
     * recursive calls relying on conditional relations between the mid-point element and the given key
     * in order to search the array and its segments for a given key. Returns true if key is the middle
     * elem -- false if indexes overlap.
     * @param key supplies key element to function
     * @param a supplies int array or segment of int array
     * @param start supplies beginning of array or array segment
     * @param end supplies end of array or end of array segment
     * @return returns boolean if key was found or not found
     */
    private static boolean search(int key, int[] a,int start, int end){
        while(start < end){
            int mid = (start + end)/2;
            if(key == a[mid]){
                System.out.println("Key found at index " + mid + "! Returning true");
                return true;
            }
            else if(key > a[mid]){
                return search(key, a, mid+1,end);
            }
            else
                return search(key, a,start,mid-1);
        }
        System.out.println("Key not Found! Returning false");
        return false;
    }

}
