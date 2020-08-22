import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PatientTester{
   public static void main(String[] args){
       PatientList list = new PatientList();
       list.add1();
       list.add2();
       list.showAll();
       list.changeSignature("DR LITTLE");
       list.updateNum(8847536, "Jaquan The Third");
       list.updateCode("+226", "Jaquan The Third");
       System.out.println("\nUpdated contact info\n\n");
       list.showAt("Jaquan The Third");
       list.updateCity("Vancouver", "Seana");
       list.updateProv("BC", "Seana");
       System.out.println("\nUpdated contact info\n\n");
       list.showAt("Seana");
       list.deleteData(0);
       System.out.println("\nAfter deleting 1st data\n\n");
       list.showAll();
       String str = "Hello.";
       for (int i = 0; i < str.length(); i++){
           char ch = str.charAt(i);
           System.out.print(ch);
       }
       double[] values = new double[10];
       double[] scores = { 10, 9, 7, 4, 5 };
       values = scores;
       int pos = 2;
       int currentSize = 0;
       Scanner in = new Scanner(System.in);
       while (in.hasNextDouble())
       {
           if (currentSize < values.length)
           {
               values[currentSize] = in.nextDouble();  currentSize++;
           }
       }

       currentSize = values.length;
       for (int i = pos + 1; i < currentSize; i++)
       {
           values[i - 1] = values[i];
       }
       currentSize--;
       double total = 0;
       for (double element : values)//You can use the enhanced for loop to visit all elements of an array.  Totaling the elements in an array with the enhanced for loop
       {
           total = total + element;//The loop body is executed for each element in the array values.  Read the loop as “for each element in values.”
           /*Traditional alternative:
           for (int i = 0; i < values.length; i++)
{
double element = values[i];  total = total + element;
}
for (double element : values)
{
element = 0; // ERROR: this assignment does not modify array elements
}

for (int i = 0; i < values.length; i++)
{
values[i] = 0; // OK
}

*/


       }
       double[] prices = Arrays.copyOf(values, values.length);
       ArrayList<Double> inputs = new ArrayList<Double>();  while (in.hasNextDouble())
       {
           inputs.add(in.nextDouble());
       }

   }

}