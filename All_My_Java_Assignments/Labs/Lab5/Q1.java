import java.awt.Point;
import java.util.ArrayList;

public class Q1 {
    // fields
    private Point location;
    private int direction;
    // array list to store the list of Strings representing Robot's movement
    // history
    private ArrayList<String> movementHistory;
    // constructor taking initial location and direction
    public Q1(Point location, int direction) {
        this.location = location;
        // validating direction before setting
        if (direction >= 0 && direction <= 3)
            this.direction = direction;
        // initializing array list
        movementHistory = new ArrayList<String>();
        // adding current position and direction to the list
        movementHistory.add(String.format("(%d,%d), %s", location.x, location.y,
                getDirection()));
    }
    // method to turn left
    public void turnLeft() {
        direction--;
        // wrapping around if necessary
        if (direction < 0) {
            direction = 3;
        }
        // adding current position and direction to the list
        movementHistory.add(String.format("(%d,%d), %s", location.x, location.y,
                getDirection()));
    }
    // method to turn right
    public void turnRight() {
        direction++;
        // wrapping around if necessary
        if (direction > 3) {
            direction = 0;
        }
        // adding current position and direction to the list
        movementHistory.add(String.format("(%d,%d), %s", location.x, location.y,
                getDirection()));
    }
    // method to move 1 unit distance in current direction
    public void move() {
        // based on direction, updating x or y coordinate of location
        switch (direction) {
            case 0:
                location.y--; // north
                break;
            case 1:
                location.x++; // east
                break;
            case 2:
                location.y++; // south
                break;
            case 3:
                location.x--; // west
                break;
        }
        // adding current position and direction to the list
        movementHistory.add(String.format("(%d,%d), %s", location.x, location.y,
                getDirection()));
    }
    // returns the location
    public Point getLocation() {
        return location;
    }
    // returns the direction as single character String
    public String getDirection() {
        switch (direction) {
            case 0:
                return "N";
            case 1:
                return "E";
            case 2:
                return "S";
            default:
                return "W";
        }
    }
    // getter for movement history
    public ArrayList<String> getMovementHistory() {
        return movementHistory;
    }
}