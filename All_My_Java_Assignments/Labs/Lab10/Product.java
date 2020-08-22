public class Product {
    //Initialize private variables
    private int id;
    private float price;
    private int quantity;
    private String productName;
    private String description;

    public Product(int id, float price, int quantity, String productName, String description) {//Constructor
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.productName = productName;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override public String toString() {
        return "Product [id=" + this.id + ", price=" + this.price + ", quantity=" + this.quantity + ", productName=" + this.productName + ", description=" + this.description + "]";
    }
}