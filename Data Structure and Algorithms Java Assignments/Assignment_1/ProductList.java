package Ass1;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductList {

    // Make a list of products
    LinkedList<Product> list = new LinkedList<Product>();
    Scanner sc = new Scanner(System.in);
    int id;
    String name;
    double price;
    String description;
    int reviews;
    double rating;
    int day, month, year;

    //******* Define functions....

    // Delete a product based on name or id
    public void Delete() {

        System.out.printf("\t1. Remove by name\n\t2. Remove by id\n\tEnter choice: ");

        int choice = sc.nextInt();

        if(choice==1) {
            String name;
            System.out.println("Enter name of product: ");
            sc.nextLine();
            name = sc.nextLine();

            for(Product p: list){
                if(p.getName().equals(name))
                {
                    list.remove(p);
                    System.out.println("LinkedList.Product removed");
                }
            }
        }else if(choice==2)
        {
            int id;
            System.out.println("Enter Id of product: ");
            id = sc.nextInt();

            for(Product p: list){
                if(p.getId() == id)
                {
                    list.remove(p);
                    System.out.println("LinkedList.Product removed");
                }
            }
        }

    }

    // Delete all products
    public void DeleteAll()
    {
        list.clear();
        System.out.println("\nLinkedList.Product list is deleted");
    }

    // Add a new product into list
    public void SaveProduct()
    {
        System.out.println("\nEnter product details...");

        System.out.println("Enter LinkedList.Product Id: ");
        id = sc.nextInt();

        System.out.println("Enter LinkedList.Product Name: ");
        sc.nextLine();
        name = sc.nextLine();

        System.out.println("Enter Price: ");
        price = sc.nextDouble();

        System.out.println("Enter Description: ");
        sc.nextLine();
        description = sc.nextLine();

        System.out.println("Enter No. of reviews: ");
        reviews = sc.nextInt();

        System.out.println("Enter LinkedList.Product Rating: ");
        rating = sc.nextDouble();

        System.out.println("Enter day: ");
        day = sc.nextInt();

        System.out.println("Enter month: ");
        month = sc.nextInt();

        System.out.println("Enter year: ");
        year = sc.nextInt();

        Product p = new Product(id, name, price, description, reviews, rating, day, month, year);
        list.add(p);

    }

    // Display size of list i.e. total products available
    public void DisplaySize()
    {
        int size = list.size();
        System.out.println("\nTotal number of products: "+size);
    }

    // Display first product entry
    public void DisplaySingle()
    {
        Product p1 = list.getFirst();
        System.out.println("Product Id: "+p1.getId()+"\nName: "+p1.getName()+"\nPrice: "+p1.getPrice()+"\nDescription: "+p1.getDescription()+"\nNo. of reviews: "+p1.getReviews()+"\nRating: "+p1.getRating()+"\nPossible shipping: "+p1.getDay()+"-"+p1.getMonth()+"-"+p1.getYear()+"\n");

    }

    // Display all products
    public void Display()
    {

        System.out.println("\nDisplaying all products......\n");

        for(Product p1: list)
        {
            System.out.println("Product Id: "+p1.getId()+"\nName: "+p1.getName()+"\nPrice: "+p1.getPrice()+"\nDescription: "+p1.getDescription()+"\nNo. of reviews: "+p1.getReviews()+"\nRating: "+p1.getRating()+"\nPossible shipping: "+p1.getDay()+"-"+p1.getMonth()+"-"+p1.getYear()+"\n");        }
    }

    public static void main(String[] args) {

        ProductList l = new ProductList();
        Scanner sc = new Scanner(System.in);

        int choice;

        // Execution until user stops
        do{

            System.out.println("\n1. Display all products\n2. Display a single product\n3. Display the number of products\n4. Save a new product\n6. Delete a product\n7. Delete all products\n8. Exit");
            System.out.print("===> Please enter an integer between 1 and 8: ");
            choice = sc.nextInt();

            switch(choice){

                case 1:
                    l.Display();
                    break;

                case 2:
                    System.out.println("\nDisplaying first product in list..");
                    l.DisplaySingle();
                    break;

                case 3:
                    l.DisplaySize();
                    break;

                case 4:
                    l.SaveProduct();
                    break;

                case 6:
                    l.Delete();
                    break;

                case 7:
                    l.DeleteAll();
                    break;

                case 8:
                    break;

                default:
                    System.out.println("INVALID CHOICE");
            }

        }while(choice!=8);

        sc.close();
    }
}
