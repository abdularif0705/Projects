package Problem6;
/*
Abdul Arif
ID: 105075345
Assignment 3
 */
import java.util.LinkedList;

/**
This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil {
    /**
    Reverses the elements in a linked list
    @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings) {
        if(strings.size()>1) {
            String s= strings.removeFirst();
            reverse(strings);
            strings.addLast(s);
        }
    }
}
