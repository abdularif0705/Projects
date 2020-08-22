package Problem5;
/*
Abdul Arif
ID: 105075345
Assignment 3
 */
import java.util.ArrayList;
/**
 Provide a static method that reverses all the elements of a
 generic ArrayList.
 */
public class ArrayListUtil {
    /**
     * Reverses the order of elements of an input ArrayList
     * @param list input ArrayList to reverse
     */
    public static <E> void reverse(ArrayList<E> list) {//changes value of list
        //Saeed's method is cleaner. I changed mine up.
        int len = list.size(); // go half way through
        for (int i=0; i<len/2; i++) {
            E temp = list.get(i);
            list.set(i, list.get(len-1-i));
            list.set(len-1-i, temp);
        }
    }
    /**
     * Creates a new ArrayList that contains the reversed elements of an
     * input ArrayList
     * @param list input ArrayList to reverse
     * @return reversed ArrayList with original elements
     */
    public static <E> ArrayList<E> reverse2(ArrayList<E> list) {
        int len = list.size(); // go half way through
        ArrayList<E> revArrayList = new ArrayList<E>(len);
        /*
        //Another way to reverse ArrayList
        for (int i=0; i<len; i++) {
            revArrayList.add(list.get(len-i-1));
        }
        */
        for (int i=len-1; i>=0; i--){
            // Append the elements in reverse order
            revArrayList.add(list.get(i));
        }
        return revArrayList;
    }
}
