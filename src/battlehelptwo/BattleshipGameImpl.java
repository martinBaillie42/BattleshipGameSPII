package battlehelptwo;

import java.util.Scanner;

/**
 *
 * @author keith
 */
public class BattleshipGameImpl implements BattleshipGame {

    public static void main(String[] args) {
        String reply = "";
        Scanner input = new Scanner(System.in);
        do {
            // setup game
            Ocean oc = new OceanImpl();
            oc.placeAllShipsRandomly();
            oc.print();
            do {
                // read in the shot
                Position p = getValidInput(input);
//                System.out.println("x = " + p.getX());
//                System.out.println("y = " + p.getY());
                // ...
                // accept shots
                oc.print();
            } while (!oc.isGameOver());

            // print final scores

            System.out.print(" do you want to play again(Yes or No)? ");
            reply = input.next();
            // System.out.println("reply is [" + reply + "]");
        } while (reply.equals("Yes")); // play again?
    }

    private static Position getValidInput(Scanner input) {
        int x, y;
//        boolean valid = true;
        do {
            try {
                System.out.println("Where do you want to fire?");
                do {
                    System.out.print("x = ");
                    x = input.nextInt();
                } while (x < 0 || x > 9);
                // maybe factor this out - call twice and write once...
                System.out.print("y = ");
                y = input.nextInt();
                //               valid = true;
                return new Position(x, y);
            } catch (Exception ex) {
                System.err.println("Invalid answer");
                //input.reset(); ?? Maybe
                // clear the input buffer or it may loop
            }
        } while (true);
    }
}

class Position{
    private int x;
    private int y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}