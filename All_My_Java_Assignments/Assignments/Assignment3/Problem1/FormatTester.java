package Problem1;
/*
Abdul Arif
ID: 105075345
Assignment 3
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class FormatTester{
  public static void main(String[] args){
        try{
          File numFile = new File("Numbers.txt");
          Scanner numScan = new Scanner(numFile);
          ArrayList<Integer> numbers = new ArrayList<Integer>();
          int num;
          while((numScan.hasNextInt())){
            num = numScan.nextInt();
            numbers.add(num);
          }
          numScan.close();

          File formatFile = new File("FormattedNumbers.txt");
          PrintWriter pw = new PrintWriter(formatFile);
          DefaultFormatter defFMT = new DefaultFormatter();
          DecimalFormatter deciFMT = new DecimalFormatter();
          AccountingFormatter accFMT = new AccountingFormatter();
          BaseFormatter baseFMT = new BaseFormatter(16); // base 16
          BaseFormatter baseFMT2 = new BaseFormatter(2); // base 2
          String s;

          pw.write("Default Format: ");
          for(int i = 0; i < numbers.size(); i++){
            s = String.format("%s ",defFMT.format(numbers.get(i)));
            pw.write(s);
          }
          pw.println();
          pw.write("Decimal Format: ");
          for(int i = 0; i < numbers.size(); i++){
            s = String.format("%s ",deciFMT.format(numbers.get(i)));
            pw.write(s);
          }
          pw.println();
          pw.write("Accounting Format: ");
          for(int i = 0; i < numbers.size(); i++){
            s = String.format("%s ",accFMT.format(numbers.get(i)));
            pw.write(s);
          }
          pw.println();
          pw.write("Base 16 Format: ");
          for(int i = 0; i < numbers.size(); i++){
            s = String.format("%s ",baseFMT.format(numbers.get(i)));
            pw.write(s);
          }
          pw.println();
          pw.write("Base 2 Format: ");
          for(int i = 0; i < numbers.size(); i++){
            s = String.format("%s ",baseFMT2.format(numbers.get(i)));
            pw.write(s);
          }
          System.out.println("Success!");
          pw.flush();
          pw.close();
        }
        catch(FileNotFoundException exception){
          System.out.println("File doesn't exist.");
        }
      }
  }
