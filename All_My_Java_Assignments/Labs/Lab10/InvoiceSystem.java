import java.util.ArrayList;
import java.util.List;

public class InvoiceSystem {
    //Initialize private variables
    private ArrayList<Product> productList; //instantiated with class Product
    private Address address;
    private ArrayList<LineItem> lineItemList; //instantiated with class LineItem

    public InvoiceSystem(ArrayList<Product> productList, Address address, ArrayList<LineItem> lineItemList) {//Constructor
        this.productList = productList;
        this.address = address;
        this.lineItemList = lineItemList;
    }
    public float amountDue() {
        float total = 0;
        for (Product p: productList)
            total = total + p.getPrice() * p.getQuantity();
        return total;
    }
    public String getInvoiceString() {
        return "InvoiceSystem [productList=" + this.productList.toString() + ", address=" + this.address + ", lineItems=" + this.lineItemList + "]";
    }
    public void addLineItem(LineItem lineItem) { this.lineItemList.add(lineItem); }

    public List<LineItem> getLineItem() { return this.lineItemList; }

    public Address getAddress() { return this.address; }

    public void setValueOfDescription(String description, int productId) {
        Product product = this.productList.get(0);
        product.setDescription(description);
    }

    public void setValueOfPrice(float unitPrice, int productId) {
        var product = (Product) this.productList.get(0);//Typecast to Product
        product.setPrice(unitPrice);
    }
}