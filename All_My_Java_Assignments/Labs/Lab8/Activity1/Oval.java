package Activity1;

public class Oval extends Shape {

    private double horiRadius;
    private double vertRadius;

    public Oval(double horiRadius, double vertRadius){
        this.setName("Oval");
        this.horiRadius = horiRadius;
        this.vertRadius = vertRadius;
    }

    public double getHoriRadius() {
        return horiRadius;
    }

    public double getVertRadius() {
        return vertRadius;
    }

    @Override
    public double area() {
        return Math.PI * this.horiRadius * this.vertRadius;
    }

    @Override
    public String toString(){
        return getName() + ": Horizontal Radius = " + getHoriRadius() + ", Vertical Radius = " + getVertRadius() + ", Area = " + area(); 
    }

}