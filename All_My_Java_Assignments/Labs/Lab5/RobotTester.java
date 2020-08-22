import java.awt.Point;
import java.util.ArrayList;

/**
A class to test the RobotTester.Robot class.
*/
public class RobotTester{
/**
Tests the methods of the RobotTester.Robot class.
@param args not used
    */
    public static void main(String[] args){

        // Create a new RobotTester.Robot object with the initial position of (5,5) and
        // initial direction to the East (1).
        Robot robot = new Robot(new Point(5, 5), "E");
        robot.move(); // 6, 5, 1
        robot.turnRight(); // 6, 5, 2
        robot.move(); // 6, 6, 2
        robot.move(); // 6, 7, 2
        robot.turnRight(); // 6, 7, 3
        robot.move(); // 5, 7, 3
        robot.move(); // 4, 7, 3
        robot.turnLeft(); // 4, 7, 2
        robot.move(); // 4, 8, 2
        Point location = robot.getLocation();
        System.out.println("Location: " + location.x + ", " + location.y);
        System.out.println("Expected: 4, 8");
        System.out.println("Direction: " + robot.getDirection());
        System.out.println("Expected: S");

        robot.printArray();
    }

    public static class Robot {

        private Point robot_location;
        private String robot_direction;
        private ArrayList<Integer> pointListX = new ArrayList<Integer>();
        private ArrayList<Integer> pointListY = new ArrayList<Integer>();
        private ArrayList<String> directionList = new ArrayList<String>();

        public Robot() {
            robot_location = new Point(0, 0);
            robot_direction = "N";
            pointListX.add(robot_location.x);
            pointListY.add(robot_location.y);
            directionList.add(robot_direction);
        }

        public Robot(Point p, String x) {
            this.robot_location = p;
            this.robot_direction = x;
            pointListX.add(robot_location.x);
            pointListY.add(robot_location.y);
            directionList.add(robot_direction);
        }

        public void turnLeft() {
            if (robot_direction.equals("N")) {
                robot_direction = "W";
            } else if (robot_direction.equals("W")) {
                robot_direction = "S";
            } else if (robot_direction.equals("S")) {
                robot_direction = "E";
            } else if (robot_direction.equals("E")) {
                robot_direction = "N";
            }
            pointListX.add(robot_location.x);
            pointListY.add(robot_location.y);
            directionList.add(robot_direction);
        }

        public void turnRight() {
            if (robot_direction.equals("N")) {
                robot_direction = "E";
            } else if (robot_direction.equals("W")) {
                robot_direction = "N";
            } else if (robot_direction.equals("S")) {
                robot_direction = "W";
            } else if (robot_direction.equals("E")) {
                robot_direction = "S";
            }
            pointListX.add(robot_location.x);
            pointListY.add(robot_location.y);
            directionList.add(robot_direction);
        }

        public void move() {
            int x = robot_location.x;
            int y = robot_location.y;
    //
            if (robot_direction.equals("N")) {
               robot_location.setLocation(x, y + 1);
            } else if (robot_direction.equals("W")) {
                robot_location.setLocation(x - 1, y);
            } else if (robot_direction.equals("S")) {
                robot_location.setLocation(x, y - 1);
            } else if (robot_direction.equals("E")) {
                robot_location.setLocation(x + 1, y);
            }
            pointListX.add(robot_location.x);
            pointListY.add(robot_location.y);
            directionList.add(robot_direction);
        }

        public Point getLocation() {
            return robot_location;
        }

        public String getDirection() {
            return robot_direction;
        }

        public String toString() {
            return String.format("%d %d %s", robot_location.x, robot_location.y, robot_direction);
        }

        public void printArray() {
            for (int i =0; i<pointListX.size(); i++) {
                System.out.println("(" + pointListX.get(i) + "," + pointListY.get(i) + "), " + directionList.get(i));
            }
        }
    }
}