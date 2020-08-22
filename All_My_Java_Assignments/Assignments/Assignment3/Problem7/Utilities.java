package Problem7;
/*
Abdul Arif
ID: 105075345
Assignment 3
 */
import java.util.Random;

public class Utilities{

    static Random r = new Random(System.currentTimeMillis());

    /**
     * Creates and returns random integer with input bounds
     * @param start Lower bound of the random value you want to generate, inclusive.
     * @param end   Upper bound of the random value you want to generate, inclusive.
     * @return      A random integer number inclusively between start and end
     */
    static int randomInteger(int start, int end){
        return r.nextInt((end-start)+1) + start;
    }

    /**
     * Checks if an integer is a power of two, and returns true if true
     * @param x An integer number
     * @return  True if x is a power of two, otherwise false
     */
    static boolean isPowerOfTwo(int x){
        double p = Math.pow(2,Math.round(Math.log(x)/Math.log(2)));
        if (p == x)
            return true;
        else
            return false;
    }
}