import java.util.*;

public class Person{

    private String Name;
    private ArrayList<String> Friends;

//constructor
    public Person(String name, ArrayList<String> friends){
        Name =name;
        Friends = new ArrayList<String>(friends);
    }
//get Friend at particular index
    public String getFriend(int index){

        if(index < Friends.size())
            return Friends.get(index);
        return " ";
    }
//return all friends
    public ArrayList<String> getFriends(){
        return Friends;
    }
//set friend at particular index
    public void setFriend(int index, String friendName){
        if(index < Friends.size())
            Friends.set(index,friendName);
    }
//geter for name
    public String getName(){
        return Name;
    }
}


