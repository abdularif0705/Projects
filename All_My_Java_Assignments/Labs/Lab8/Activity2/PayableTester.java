package Activity2;

public class PayableTester{
    public static void main(String[] args){
        Employee emp = new Employee(15.50, 40);
        Invoice inv = new Invoice(20.25, 10, 1.13);
        System.out.println("Employee: Wage = $" + emp.getHourlyRate() + ", Hours = " + emp.getWorkingHours());
        System.out.println("Invoice: Unit Price = $" + inv.getUnitPrice() + ", Quantity = " + inv.getNumberOfProduct());
        System.out.println("Employee Payment: $" + emp.getPaymentAmount());
        System.out.println("Invoice Payment: $" + inv.getPaymentAmount());
    }
}