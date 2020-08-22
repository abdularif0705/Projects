package Nim;

public class ComputerPlayer extends Player{
    private boolean smart;

    public ComputerPlayer() {
        this.smart = false;
        this.name = "Novice Computer";
    }

    public ComputerPlayer(boolean smart) {
        this.smart = smart;
        this.name = this.smart?"Smart Computer":"Novice Computer";
    }

    public String getName() {

        return this.name;
    }

    public boolean isSmart() {
        return smart;
    }

    public void setSmart(boolean smart) {

        this.smart = smart;
    }

    @Override
    public int play(Pile pile) {
        int num = 0;
        if (this.isSmart()) {
            for (int i = 1; i <= pile.getCurrentNumberOfMarbles()/2; i++) {
                if (Utilities.isPowerOfTwo(pile.getCurrentNumberOfMarbles()-i+1)) {
                    num = i;
                    break;
                }
            }
            if (num == 0)
                num = Utilities.randomInteger(1,pile.getCurrentNumberOfMarbles()/2);
        }
        else {
            num = Utilities.randomInteger(1,pile.getCurrentNumberOfMarbles()/2);
        }
        return num;
    }

}
