import java.util.Scanner;

class Car {

    int efficiency; //declaring the instance variables
    float gas=0;
    Car(int e) //constructor to intialize the efficiency variable
    {
        efficiency=e;
    }
    void addGas(int g) //method to add gas
    {
        gas=g;
    }
    float getGasInTank()   //method to get gas remaining in the tank
    {
        return gas;
    }
    void drive(int distance) //method for drive
        {
        float b=distance/efficiency;
        gas-=b;
    }
}
public class CarTester{
    public static void main(String []args){
        Car c=new Car(50); //creating car object
        c.addGas(20); //adding gas

        Scanner i=new Scanner(System.in);   //take the value of distance from user

        System.out.println("enter the distance");

        int distance=i.nextInt();
        if(distance<(c.gas*c.efficiency))   //checking whether the distance is less than the gas * efficiency
        {
            c.drive(100);   //calling drive method
        }
        System.out.println(c.getGasInTank()); //printig remaing gas in the tank
    }
}