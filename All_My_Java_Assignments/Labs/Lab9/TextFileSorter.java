import java.util.*;
import java.io.*;

public class TextFileSorter{

    private String inputFileName, outputFileName, data;   // Names of input & output file names, data string 
    private char order; //Order of sorting (ascending/descending)

    public TextFileSorter(){
        this.inputFileName = "";
        this.outputFileName = "";
        this.data = "";
    }

    /**
     * Read data information from input file
     */
    public void readFromFile(){
        String line;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)))){
            while ((line = br.readLine()) != null){  // reading till EOF
                data += line + "\n";  // storing data information from input file into "data"
            }
        }
        catch(Exception exception){
            System.out.println("Exception Occurred:\n" + exception);
        }
    }

    /**
     * Sorts file contents based on data type and stores into seperate file
     * @throws Exception
     */
    public void sorting() throws Exception{  
        String[] values = data.split("\\n");   //creating a string array from the values read from the file.
        PrintWriter pw = new PrintWriter(outputFileName);

        if(data.startsWith("Integer")){   //Integer pathway
            ArrayList<Integer> list1 = new ArrayList<Integer>(); 
            for(int i=1; i<values.length; i++){
                try{
                    list1.add(Integer.parseInt(values[i]));  //forces all values to be integers
                }
                catch(Exception exception){}
            }
            if(order == 'a')  //sorting in ascending order
                Collections.sort(list1);
            else if(order == 'd')  //sorting in descending order
                Collections.sort(list1, Collections.reverseOrder());

            pw.println("Integer, " + list1.size());

            for(Integer a : list1){
                pw.println(a);
            }
        }

        else if(data.startsWith("Float")){  //Float pathway
            ArrayList<Float> list1 = new ArrayList<Float>();
            for(int i = 1; i < values.length; i++){
                try{
                    list1.add(Float.parseFloat(values[i]));
                }
                catch(Exception exception){}
            }
            if(order == 'a')
                Collections.sort(list1);
            else if(order == 'd')
                Collections.sort(list1, Collections.reverseOrder());

            pw.println("Float, " + list1.size());

            for(Float a : list1){
                pw.println(a);
            }
        }

        else if(data.startsWith("Double")){  //Double pathway
            ArrayList<Double> list1 = new ArrayList<Double>();
            for(int i = 1; i < values.length; i++){
                try{
                    list1.add(Double.parseDouble(values[i]));
                }
                catch(Exception exception){}
            }
            if(order == 'a')
                Collections.sort(list1);
            else if(order == 'd')
                Collections.sort(list1, Collections.reverseOrder());

            pw.println("Double, " + list1.size());

            for( Double a : list1){
                pw.println(a);
            }
        }

        else{  //String/Others pathway
            ArrayList<String> list1 = new ArrayList<String>();
            for(int i = 1; i < values.length; i++){
                list1.add(values[i]);
            }

            if(order == 'a')
                Collections.sort(list1);
            else if(order == 'd')
                Collections.sort(list1, Collections.reverseOrder());

            pw.println(values[0]+ ", " + list1.size());

            for(String a : list1){
                pw.println(a);
            }

        }

        pw.close();
    }

    /**
     * Changes input file name to input string
     * @param newInpFile Input string file name
     */
    public void setInput(String newInpFile){
        this.inputFileName = newInpFile;
    }

    /**
     * Changes output file name to input string
     * @param newOutFile Input string file name
     */
    public void setOutput(String newOutFile){
        this.outputFileName = newOutFile;
    }

    /**
     * Changes sorting order to input char
     * @param newOrder Input char sorting order
     */
    public void setOrder(char newOrder){
        this.order = newOrder;
    }
}