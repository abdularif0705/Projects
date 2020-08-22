package Problem4;
/*
Abdul Arif
ID: 105075345
Assignment 3
 */
import java.io.*;
import java.util.*; //Import needed libraries

/**
 * This is a class for sorting and outputting a text files into classes of words based on the first letter
 */
public class FirstLetterMap{

    public static void main(String[] args){
        Scanner fileScan = new Scanner(System.in);
        System.out.println("Enter file name: ");
        File file = new File(fileScan.nextLine()); //Reads user input for text file to read

        try{
            Scanner wordScan = new Scanner(file); //Scanner for reading through text file
            String inputWord;
            Map<Character, Set<String>> hash = new HashMap<>();
            while(wordScan.hasNext()){ //Reads each word in text file
                inputWord = wordScan.next();
                inputWord = inputWord.toLowerCase();
                inputWord = inputWord.replaceAll("[^a-zA-Z]", ""); //Replaces all non-alphabetical characters with nothing
                if(!hash.containsKey(inputWord.charAt(0))){ //Sorts each word by the first character in a tree set for each letter
                    hash.put(inputWord.charAt(0), new TreeSet<>());
                }
                hash.get(inputWord.charAt(0)).add(inputWord);
            }
            for(char key: hash.keySet()){
                System.out.println(key + ":" + hash.get(key)); //Outputs all TreeSets
            }
            wordScan.close();
        }
        catch (FileNotFoundException exception){ //Exception for missing input text file
            System.out.println("File not found.");
        }
        fileScan.close();
    }
}