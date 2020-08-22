package Activity2;

public class Employee implements Payable{

    private double hourlyRate = 0.0;
    private int workingHours = 0;

    public Employee(){
        this.hourlyRate = 0.0;
        this.workingHours = 0;
    }

    public Employee(double inpRate, int inpHour){
        this.hourlyRate = inpRate;
        this.workingHours = inpHour;
    }

    public void setHourlyRate(double newRate){
        this.hourlyRate = newRate;
    }

    public void setWorkingHours(int newHours){
        this.workingHours = newHours;
    }

    public double getHourlyRate(){
        return hourlyRate;
    }

    public int getWorkingHours(){
        return workingHours;
    }

    @Override 
    public double getPaymentAmount(){
        return hourlyRate * workingHours;
    }
}