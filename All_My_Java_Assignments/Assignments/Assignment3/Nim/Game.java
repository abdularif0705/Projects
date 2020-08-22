//Saeed's solution
package Nim;

import java.util.Scanner;

public class Game {

    /**
     *
     * @param p1    First player
     * @param p2    Second Player
     * @param pile  Pile of marbles
     * @param turn  Player who has to play first
     */
    public static void runOneGame(Player p1, Player p2, Pile pile, Player turn) {

        while (pile.getCurrentNumberOfMarbles() > 1) {
            if (turn instanceof ComputerPlayer) {
                int num = turn.play(pile);
                pile.takeMarbles(num);
                System.out.println(turn.getName() + " takes " + num + " marbles.");
                System.out.println("There are " + pile.getCurrentNumberOfMarbles() + " marbles left.");
                System.out.println(pile.showPile());
            }
            else {
                int num = turn.play(pile);
                pile.takeMarbles(num);
                System.out.println("There are " + pile.getCurrentNumberOfMarbles() + " marbles left.");
                System.out.println(pile.showPile());
            }

            if (turn==p1)
                turn = p2;
            else
                turn = p1;
        }

        System.out.println("*** " + (turn==p1?p2:p1).getName() + " is the winner! ***");
        p1.setNumberOfPlays(p1.getNumberOfPlays()+1);
        p2.setNumberOfPlays(p2.getNumberOfPlays()+1);
        if (turn==p2)
            p1.setScore(p1.getScore()+1);
        else
            p2.setScore(p2.getScore()+1);
    }

    /**
     *
     * @param p1    First player
     * @param p2    Second Player
     * @param pile  Pile of marbles
     * @param turn  Player who has to play first
     */
    public static String gameStatus(Player p1, Player p2, Pile pile, Player turn) {
        return "This is a game between " + p1.getName() + " and " + p2.getName() +
                ".\nInitial number of piles: " + pile.getInitialNumberOfMarbles() +
                ".\nCurrent number of piles: " + pile.getCurrentNumberOfMarbles() +
                ".\n" + pile.showPile() + "\nIt is " + turn.getName() + "'s turn to play.";
    }

    public static void main(String[] args) {

        // Print out a welcome message
        System.out.println("Welcome to the game of Nim!");
        System.out.println("---------------------------");

        Player p1,p2;
        Scanner console = new Scanner(System.in);

        do {

            System.out.println("H)Human-Human  C)Computer-Human");
            if (console.nextLine().toUpperCase().equals("H")) {
                // The first player is human
                System.out.println("Name of the first player: ");
                p1 = new HumanPlayer(console.nextLine());
            } else {
                // The first player is the Computer.
                boolean smart = Utilities.randomInteger(0, 1) != 0;
                p1 = new ComputerPlayer(smart);
            }
            // The second player is human
            System.out.println("Name of the second player: ");
            p2 = new HumanPlayer(console.nextLine());

            do {

                // Create a pile of marbles, randomly between 10 to 100 marbles.
                Pile pile = new Pile(Utilities.randomInteger(10, 100));

                // Randomly select the player who should play first.
                Player turn = Utilities.randomInteger(1, 2) == 1 ? p1 : p2;

                // Print out game information
                System.out.println(gameStatus(p1, p2, pile, turn));

                // Start playing a game
                runOneGame(p1, p2, pile, turn);

                System.out.println(p1);
                System.out.println(p2);

                System.out.println("P)lay again  Q)uit");

            } while (console.nextLine().toUpperCase().equals("P"));

            System.out.println("N)ew play set  E)xit");

        } while (console.nextLine().toUpperCase().equals("N"));
    }
}
