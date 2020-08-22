package Problem7;
/*
Abdul Arif
ID: 105075345
Assignment 3
 */
public abstract class Player {

    protected String name;
    private int numberOfPlays;
    private int score;

    public Player(){}

    /**
     *
     * @param name
     */
    public Player(String name){
        this.name = name;
    }
    
    /**
     *
     * @return
     */
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNumberOfPlays(){
        return numberOfPlays;
    }

    public int getScore(){
        return score;
    }

    public void setNumberOfPlays(int number){
        this.numberOfPlays = number;
    }

    public void setScore(int number){
        this.score = number;
    }

    public abstract int play(Pile pile);

    @Override
    public String toString(){
        return "Player Name: " + this.name +", Number of Plays: " + this.getNumberOfPlays() +", Score: " + this.getScore();
    }
}