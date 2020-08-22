package Problem7;
/*
Abdul Arif
ID: 105075345
Assignment 3
 */
public class ComputerPlayer extends Player{

   private Boolean smart; //Boolean value to determine computer difficulty

    /**
     * Creates computer player object with default novice difficulty
     * and initializes plays and score to 0, name is "Computer"
     */
    public ComputerPlayer(){
        smart = false;
        this.setName("Computer");
        this.setNumberOfPlays(0);
        this.setScore(0);
    }

    /**
     * Creates computer player object with input boolean difficulty
     * (true is smart, false is novice), and initializes plays and 
     * scores to 0, name is "Computer" 
     * @param smart input boolean value to determine difficulty
     */
    public ComputerPlayer(boolean smart){
        this.smart = smart;
        this.setName("Computer");
        this.setNumberOfPlays(0);
        this.setScore(0);
    }

    /**
     * Gets and returns boolean value of "smart" computer difficulty
     * @return true/false value of "smart" computer difficulty
     */
    public Boolean getSmart(){
        return smart;
    }

    /**
     * Changes computer difficulty level to input boolean value
     * @param smart new input boolean value for computer difficulty
     */
    public void setSmart(Boolean smart) {
        this.smart = smart;
    }

    /**
     * Simulates a computer's turn for takingg marbles from the pile,
     * and employs 2^n-1 strategy for smart computer, random selection
     * for novice computer. Returns value at end to match int return type.
     * @param pile input Pile object of current amount of marbles left
     * @return 0 when finished to match int return type
     */
    @Override
    public int play(Pile pile){
        int marbles  = 0 ;

        if(smart){ //Smart pathway
            boolean flag = false;
            for(int i = 1; i <= (pile.getCurrentNumberOfMarbles() / 2) ; i++){ //Checking all powers of two until num of marbles is passed
                if(Utilities.isPowerOfTwo(pile.getCurrentNumberOfMarbles() - i + 1)){ //Checks if num of marbles can be left as 2^n-1
                    pile.takeMarbles(i);
                    flag = true;
                    System.out.println("Smart computer has taken " + i + " marbles.");
                    break;
                }
            }
            if(!flag){ //If prior strategy fails, takes random value like Novice
                marbles = Utilities.randomInteger(1, (pile.getCurrentNumberOfMarbles() / 2));
                pile.takeMarbles(marbles);
                System.out.println("Smart computer has taken " + marbles + " marbles.");
            }
        }

        else{ //Novice pathway
            marbles = Utilities.randomInteger(1, (pile.getCurrentNumberOfMarbles() / 2));
            pile.takeMarbles(marbles);
            System.out.println("Novice computer has taken " + marbles + " marbles.");
        }

        return 0;
    }
}
