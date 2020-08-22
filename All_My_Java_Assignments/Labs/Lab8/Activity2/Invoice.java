package Activity2;

public class Invoice implements Payable{
    
    private double unitPrice = 0.0;
    private int numberOfProduct = 0;
    private double taxRate = 0.0;

    public Invoice(){
        this.unitPrice = 0.0;
        this.numberOfProduct = 0;
        this.taxRate = 1.13;
    }

    public Invoice(double inpPrice, int inpProduct, double inpTax){
        this.unitPrice = inpPrice;
        this.numberOfProduct = inpProduct;
        this.taxRate = inpTax;
    }

    public void setUnitPrice(double newPrice){
        this.unitPrice = newPrice;
    }

    public void setNumberOfProduct(int newProduct){
        this.numberOfProduct = newProduct;
    }

    public void setTaxRate(double newTax){
        this.taxRate = newTax;
    }

    public double getUnitPrice(){
        return unitPrice;
    }

    public int getNumberOfProduct(){
        return numberOfProduct;
    }

    public double getTaxRate(){
        return taxRate;
    }

    @Override
    public double getPaymentAmount(){
        return numberOfProduct * unitPrice * taxRate;
    }
}