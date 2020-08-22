package Activity1;

import java.util.*;

public class ShapeTester{
    public static void main(String[] args){
        ArrayList<Shape> shapeList = new ArrayList<Shape>();
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Please enter a letter to create a shape (T = Triangle, C = Circle, S = Square, O = Oval), E to exit: ");
        String shapeType = input.nextLine();
        while(!shapeType.equals("E")){
            if(shapeType.equals("T")){
                double base = rand.nextInt(100) + 1;
                double height = rand.nextInt(100) + 1;
                Triangle newTri = new Triangle(base, height);
                shapeList.add(newTri);
            }
            if(shapeType.equals("C")){
                double radius = rand.nextInt(100) + 1;
                Circle newCirc = new Circle(radius);
                shapeList.add(newCirc);
            }
            if(shapeType.equals("S")){
                double side = rand.nextInt(100) + 1;
                Square newSquare = new Square(side);
                shapeList.add(newSquare);
            }
            if(shapeType.equals("O")){
                double horiRadius = rand.nextInt(100) + 1;
                double vertRadius = rand.nextInt(100) + 1;
                Oval newOval = new Oval(horiRadius, vertRadius);
                shapeList.add(newOval); 
            }
            shapeType = input.nextLine();
        }
        for(Shape shape: shapeList){
            System.out.println(shape);
        }
        Shape shape1 = shapeList.get(0);
        Shape shape2 = shapeList.get(1);
        System.out.println("Area comparison between first two shapes: " + shape1.compareTo(shape2));
    }
}