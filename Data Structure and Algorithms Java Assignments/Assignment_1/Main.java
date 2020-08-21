package Ass1;// Created By Kalyani 2020

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList=new LinkedList<Integer>();

        // insert data at rear
        linkedList.insertData(10);
        linkedList.insertData(20);
        linkedList.insertData(30);
        linkedList.insertData(40);

        // Display after inserting
        linkedList.displayData();

        //Insert at the first
        linkedList.insertFirst(5);
        // insert at position 3 an element 15
        linkedList.insertAt(3,15);

        //Check whether an element is existing in the list or not.
        System.out.println("Search a value 30: "+linkedList.isContain(30));

        linkedList.displayData();

        // delete the element at first
        linkedList.deleteFirst();
        System.out.println("After deleting");
        linkedList.displayData();

        // delete at the rear
        linkedList.deleteData();
        System.out.println("After deleting at rear");
        linkedList.displayData();

        // delete an element at position 2
        linkedList.deleteAt(2);
        System.out.println("After deleting at position =2");
        linkedList.displayData();

    }

}