package Problem3;

import java.util.Scanner;

public class PersonTester {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Person[] people = new Person[10];
        for (int i = 0; i < people.length; i++) {
            System.out.print("Enter name of person " + (i+1) + ": ");
            people[i] = new Person(in.nextLine());
        }

        Person first = people[0], last = people[0];
        for (int i = 0; i < people.length; i++) {
            if (people[i].compareTo(first) < 0) first = people[i];
            if (people[i].compareTo(last) > 0) last = people[i];
        }

        System.out.println("First person is " + first.getName());
        System.out.println("Last person is " + last.getName());

        in.close();
    }
}
