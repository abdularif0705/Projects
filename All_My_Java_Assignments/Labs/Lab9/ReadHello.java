import java.io.*;
import java.util.Scanner;

public class ReadHello{
    public static void main(String[] args){
        try{
            File file = new File("hello.txt");//create object file of class File
            PrintWriter pw = new PrintWriter(file);//create object pw of class PrintWriter
            pw.write("Hello World!");//write in hello.txt file
            //pw.flush();//creates new line after flushing
            //pw.append("Hello World!");//write in hello.txt file
            pw.close();//close file

            Scanner sc = new Scanner(file);
            String msg = sc.nextLine();//scans first line in hello.txt
            System.out.println(msg);//then prints it
            sc.close();
        }
        catch(FileNotFoundException exception){
            System.out.println("File doesn't exist.");
        }
    }
}