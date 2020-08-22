package Activity1;

public class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle(double base, double height){
        this.setName("Triangle");
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double area() {
        return (this.base * this.height) / 2;
    }

    @Override
    public String toString(){
        return getName() + ": Base = " + getBase() + ", Height = " + getHeight() + ", Area = " + area(); 
    }

}
