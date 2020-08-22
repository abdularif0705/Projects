/*
Abdul Arif
105075345
 */
import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter city, state, country and zip: ");
        String city = sc.nextLine();
        String state = sc.nextLine();
        String country = sc.nextLine();
        String zip = sc.nextLine();
        Address ads = new Address(city, state, country, zip);
        System.out.println("Enter product details in order- id, price, quantity, productName, description: ");
        int id = sc.nextInt();
        float price = sc.nextFloat();
        int quantity = sc.nextInt();
        sc.nextLine();
        String productName = sc.nextLine();
        String description = sc.nextLine();
        Product prd = new Product(id, price, quantity, productName, description);
        ArrayList<Product> prodlist = new ArrayList();
        prodlist.add(prd);
        System.out.println("Enter line item - id and name: ");
        id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        LineItem item = new LineItem(id, name);
        ArrayList<LineItem> itemlist = new ArrayList();
        itemlist.add(item);
        InvoiceSystem obj = new InvoiceSystem(prodlist, ads, itemlist);
        System.out.println(obj.getInvoiceString());
    }
}
