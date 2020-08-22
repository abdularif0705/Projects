import java.util.*;

public class Activity3{
    public static void main(String[] args) {
        ArrayList<String> friends = new ArrayList<String>( Arrays.asList("Steve", "Mandy", "Tim", "Rafal"));
        //create an object of Person Class
        Person person = new Person("Aris", friends);

        //display the name as per new method at index 0
        System.out.println("Friend at 0 index: " + person.getFriend(0));
        //change the name at index 0
        person.setFriend(0,"Cooper");
        System.out.println("Friend at 0 index after name change: " + person.getFriend(0));
        //All Friends name
        System.out.println("Name of all friends for Person " + person.getName() + " : ");
        for (String name : person.getFriends())
            System.out.println(name);
    }
}