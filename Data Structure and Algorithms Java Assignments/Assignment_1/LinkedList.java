package Ass1;//created by Kalyani 2020

public class LinkedList<T> {
    Node head; // head of the list - first element

    //Insert at the front
    public void insertFirst(int data)
    {
        Node newHead=new Node(data);  // crate the new node
        newHead.next=head;       // assign the existing head at next
        head = newHead;         //  assign the new node at head
    }

    public void insertAt(int position,int data)
    {
        if (head==null) return;
        Node newNode=new Node(data);  //create a new node
        Node previous=head;      // temporary node to point head
        int count=1;
        // find the position to insert data
        while(count<position-1)
        {
            previous=previous.next;
            count++;
        }
        Node current=previous.next;     // temporary node
        newNode.next=current;
        previous.next=newNode;
    }

    // Insert at the rear
    public void insertData(int data){
        //check whether you are inserting to the head or node
        if(head==null) {
            head = new Node(data);
            return;
        }
        Node current = head;        // Initialize current
        while(current.next!=null)   //check until last node
        {
            current=current.next;   // move pointer one by one
        }
        current.next=new Node(data); // when the pointer reaches the null pointer, insert the data.
    }

    // delete an element at first
    public void deleteFirst()
    {
        Node current= head;
        head=head.next;
        current.next=null;
    }

    //delete an element at rear
    public void deleteData()
    {
        Node current = head;    // Initialize current
        Node previous=null;

        while(current.next!=null)
        {
            previous=current;
            current=current.next;
        }
        previous.next=null;

    }

    //delete an element at the middle
    public void deleteAt(int position)
    {
        if (head==null) return;
        Node previous=head;      // temporary node to point head
        int count=1;
        // find the position to delete data
        while(count<position-1)
        {
            previous=previous.next;
            count++;
        }
        Node current=previous.next;     // temporary node
        previous.next=current.next;
        current.next=null;
    }

    public boolean isContain(int data)
    {
        Node current = head;
        while (current!=null)
        {
            if(current.data==data)
                return true;
            current=current.next;
        }
        return false;
    }

    // print element in the linkedlist
    public void displayData()
    {
        Node current = head;
        while(current!=null)
        {
            System.out.println(current.data);
            current=current.next;
        }
    }


    public void remove(Product p) {
    }

    public void clear() {
    }

    public void add(Product p) {
    }

    public int size() {
        return 0;
    }

    public Product getFirst() {
        return null;
    }
}