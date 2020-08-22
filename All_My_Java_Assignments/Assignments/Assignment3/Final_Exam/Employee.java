package Final_Exam;// Complete the code for Final_Exam.Employee class here:

public class Employee implements Payable {
    private int hoursOfWork;
    private double wage;
    private double bonus;
    private double paymentAmount;

    public Employee(int hoursOfWork, double wage, double bonus) {
        this.hoursOfWork = hoursOfWork;
        this.wage = wage;
        this.bonus = bonus;
    }

    @Override
    public double getPaymentAmount() {
        this.paymentAmount = this.hoursOfWork * this.wage + this.bonus;
        return this.paymentAmount;
    }
}