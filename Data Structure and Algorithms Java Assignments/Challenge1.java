package Challenges;

public class Challenge1{
    public static void main(String[] args){
        System.out.println("Student ID: 105075345, Name: Abdul Arif"); //My ID and name
        String[] item1 = {"COMP2540", "uWindsor", "data", "structures", "uWindsor"};//declare string variable item1
        String[] query1 = {"2540", "uWindsor", "data"};//declare string variable query1

        int[] test1 = findCountArray(item1, query1);//send arguments item1 and query1 to findCountArray

        System.out.println("["+test1[0]+", "+test1[1]+", "+test1[2]+"]");//print array test1

        String[] item2 = {"25", "40", "25", "array", "LinkedList", "25", "trees"};//declare string variable item2
        String[] query2 = {"hashing", "25", "array", "2540"};//declare string variable query2

        int[] test2 = findCountArray(item2, query2);//send arguments item2 and query2 to findCountArray

        System.out.println("["+test2[0]+", "+test2[1]+", "+test2[2]+", "+test2[3]+"]");//print array test2
    }

    public static int[] findCountArray(String[] item, String[] query){ //method to  find the number of times the elements in the query string array appears in the item string array.
        int[] result = new int[query.length];//declare integer array with the number of values inside the parameter query
        int i = 0;
        for (String q: query){//use enhanced for loop to go through each element in query
            int count = 0;//declare count
            for (String it: item){//use enhanced for loop to go through each element in item
                if (q.equals(it) == true){//test if words are equal
                    count++;//increase count by 1
                }
            }
            result[i++] = count;//ith value in result array equals to count
        }
        return result;//return result array
    }
}