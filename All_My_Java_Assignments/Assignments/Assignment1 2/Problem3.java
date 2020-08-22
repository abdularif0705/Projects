import java.awt.geom.Ellipse2D; 
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Problem3{

    public static void main(String[] args){

      //Step 1: Create line with specifications
      Line2D.Float line = new Line2D.Float(3,12,17,31);//Create object of

      //Step 2: Change end points of line
      line.setLine(3,12,19,13); //Used setLine to change

      //Step 3: Create Ellipse with coords and dimensions
      Ellipse2D.Float ellipse = new Ellipse2D.Float(4,13,60,25); //Used Ellipse2D
      Point2D point1 = line.getP1();
      Point2D point2 = line.getP2(); //Separates line into two separate defined points for easier display

      //Expected and Actual display
      System.out.println("Expected start of line: (3,12)");
      System.out.printf("Actual start of line: (%d,%d)\n" ,(int)point1.getX(), (int)point1.getY());
      System.out.println("Expected end of line: (19,13)");
      System.out.printf("Actual end of line: (%d,%d)\n" , (int)point2.getX(), (int)point2.getY());

      System.out.println("Expected height of ellipse: 25");
      System.out.printf("Actual height of ellipse: %d\n", (int)ellipse.getHeight());
      System.out.println("Expected width of ellipse: 60");
      System.out.printf("Actual width of ellipse: %d\n", (int)ellipse.getWidth());
      System.out.println("Expected framing x-coord: 4");
      System.out.printf("Actual framing x-coord: %d\n", (int)ellipse.getX());
      System.out.println("Expected framing y-coord: 13");
      System.out.printf("Actual framing y-coord: %d\n", (int)ellipse.getY());
    }
}