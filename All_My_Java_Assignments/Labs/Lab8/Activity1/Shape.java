package Activity1;

public class Shape implements Comparable{

    private String name;

    public Shape(){
        this.name = "General Shape";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double area() {
        return 0;
    };

    public int compareTo(Object otherShape){
        Shape other = (Shape) otherShape;
        if(this.area() > other.area()){
            return 1;
        }
        else if(this.area() < other.area()){
            return -1;
        }
        else if(this.area() == other.area()){
            return 0;
        }
        return -6;
    }

}