import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {
    public static void main(String args[]){
        Scanner fibNum = new Scanner(System.in);
        System.out.print("Enter a value for n fibonacci numbers:");
        int n = fibNum.nextInt();

        ArrayList<Integer> fibList = new ArrayList<Integer>();
        fibList.add(0);
        fibList.add(1);
        for(int i = 2; i < n; i++){
            fibList.add(fibList.get(i-1) + fibList.get(i-2));
        }
        for(int i = 0; i < n; i++){
            System.out.println(fibList.get(i));
        }

        Scanner checkNum = new Scanner(System.in);
        System.out.println("Enter an integer to check if it's in fibonnaci sequence");
        int check = checkNum.nextInt();

        for (int j=0; j<n; j++){
            if(check == fibList.get(j)){
                System.out.println("Your integer matches with array #"+(j+1));
                break;
            }
        }
    }

}