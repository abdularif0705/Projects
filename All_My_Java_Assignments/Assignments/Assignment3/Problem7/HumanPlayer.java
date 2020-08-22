package Problem7;
/*
Abdul Arif
ID: 105075345
Assignment 3
 */
import java.util.Scanner;

public class HumanPlayer extends Player{

    private int age; //Integer variable for player age

    /**
     * Creates HumanPlayer object with input name and age,
     * initializing plays and score to 0.
     * @param name string input for player name
     * @param age integer value for player age
     */
    public HumanPlayer(String name, int age){
        this.age = age;
        this.setName(name);
        this.setNumberOfPlays(0);
        this.setScore(0);
    }

    /**
     * Gets and returns age of human player
     * @return integer value of age
     */
    public int getAge(){
        return age;
    }

    /**
     * Sets age of human player to input age value 
     * @param age new age value to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Player takes some number (within a range) of marbles from pile,
     * and if input is invalid/out of range, they are prompted until valid.
     * Returns value at end to match int return type.
     * @param pile Pile object of current amount of marbles left
     * @return 0 when done to match int return type
     */
    @Override
    public int play(Pile pile){
        Scanner in = new Scanner(System.in);

        System.out.println(this.name + ", How many marbles do you take? (min = 1, max = " + (pile.getCurrentNumberOfMarbles() / 2) + ")");
        int marbles = in.nextInt();

        while(!pile.takeMarbles(marbles)){ //Checks for valid num of marbles taken
            System.out.println("Please enter a valid number of marbles. (min = 1, max = " + (pile.getCurrentNumberOfMarbles() / 2) + ")");
            marbles = in.nextInt();
        }
        return 0;
    }
}
