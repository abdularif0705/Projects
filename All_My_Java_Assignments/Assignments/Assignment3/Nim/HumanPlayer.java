package Nim;

import java.util.Scanner;

public class HumanPlayer extends Player {

    int age;

    public HumanPlayer(String name) {
        this.name = name;
    }

    public HumanPlayer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int play(Pile pile) {
        int num = 0;
        Scanner input = new Scanner(System.in);
        while ((num < 1) || (num > pile.getCurrentNumberOfMarbles()/2)){
            System.out.print(this.getName() + ", how many marbles do you take? (min=1, max=" +
                    pile.getCurrentNumberOfMarbles()/2 + ")");
            try {
                num = Integer.parseInt(input.nextLine());
            }
            catch (NumberFormatException ex) {
                num = 0;
            }
        }
        return num;
    }

}
