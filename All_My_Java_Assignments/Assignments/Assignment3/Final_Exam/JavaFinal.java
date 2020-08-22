package Final_Exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class JavaFinal {
    public static void main(String[] args) {
        try {
            File numFile = new File("Numbers.txt");
            Scanner in = new Scanner(numFile);
            String result = "";

            int number = 0;

            if (in.hasNextInt())

                number = in.nextInt();

            result = in.next();

            System.out.println(result);
            System.out.println(number);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //Suppose the abstract class Message is defined as below:

    public abstract class Message {

        private String value;

        public Message(String initial){

            value = initial;

        }

        public String getMessage(){

            return value;

        }

        public abstract String translate();

        public abstract boolean isTranslated();


    }
    //What is the output of the following code?

    public class ArrayDemo {

       // public static void main(String[] args) {

            //int[] a = { 1, 4, 9 };

            //System.out.print(Arrays.binarySearch(a, 7)+”,”);

            //System.out.println(Arrays.binarySearch(a, 4));

        }

    }
