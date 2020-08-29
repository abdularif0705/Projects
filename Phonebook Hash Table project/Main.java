//Final Project: Data Structures & algorithms.
//Implement class using Hash tables.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook<String, Integer> contacts = new PhoneBook<>();//create phonebook object
        boolean close = false;
        Scanner scan = new Scanner(System.in);

        while (close == false) {
            System.out.println("What do you want to do?");
            System.out.println("1. Add a contact");
            System.out.println("2. Show a contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. Show all contacts");
            System.out.println("5. Show all names");
            System.out.println("6. Show all numbers");
            System.out.println("7. Show size of phonebook");
            System.out.println("8. Exit");
            System.out.print("Select a number: ");

            int action = scan.nextInt();
            switch (action){
                case 1://add
                    System.out.println("Enter name: ");
                    String name= scan.next();
                    System.out.println("Enter number: ");
                    int number = scan.nextInt();
                    contacts.add(name,number);
                    break;

                case 2://get a contact
                    System.out.println("Enter name: ");
                    String name2 =scan.next();
                    System.out.println(contacts.get(name2));
                    break;

                case 3://delete
                    System.out.println("Enter name");
                    String name1 =scan.next();
                    contacts.remove(name1);
                    break;

                case 4://whole set
                   // System.out.println(contacts.size());
                    contacts.entrySet();
                    break;
                case 5://keys
                    contacts.keySet();
                    break;
                case 6://values
                    contacts.values();
                    break;
                case 7://size
                    System.out.println(contacts.size());
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    close = true;
                    break;
                default:
                    System.out.println("Invalid.");
                    System.out.print("Select a number: ");
                    break;
            }
        }
    }
}