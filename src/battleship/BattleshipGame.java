package battleship;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 28/01/13
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
public class BattleshipGame {

    public static void main(String[] args){

        Set<String> replies = new HashSet<>();
        replies.add("Yes");
        replies.add("yes");
        replies.add("y");

        int limit;
        String reply;
        Scanner input = new Scanner(System.in);

        do {
            // set up the game
            Ocean oc = new OceanImpl();
            oc.placeAllShipsRandomly();
            System.out.println();
            System.out.println(oc);
            limit = oc.getUPPER();

            do {
                // read in the shot
                Position p = getValidInput(input, limit);
                // accept shots & check whether it'sa hit (in Ocean)
//                System.out.println(oc.shootAt(p.getRow(), p.getColumn()));
                if (oc.shootAt(p.getRow(), p.getColumn())) {// a miss
                    System.out.println("A hit! Well done");
                } else {
                    System.out.println("A miss, try again.");
                }
                System.out.println(oc);
                System.out.println("[. is empty sea; - is a miss; S is a hit; X is a sunken ship]");
                System.out.println();
            } while (!oc.isGameOver());
            // print out final scores
            //System.out.println(oc.printFinalScores());

            System.out.print("Do you want to play again (Yes or No)?");
            reply = input.next();
        } while (replies.contains(reply)); // play again?

    }

    private static Position getValidInput (Scanner input, int limit) {
        int row;
        int column;
        System.out.println();
        System.out.println("Where do you want to fire (x,y)?");
        column = askForInput(input, "x/column = ", limit);
        row = askForInput(input, "y/row = ", limit);
        return new PositionImpl(row, column);

    }

    private static int askForInput(Scanner input, String rowCol, int limit) {
        int coordinate;
        do {
            try {
                do {
                    System.out.print(rowCol);
                    coordinate = input.nextInt();
                } while (coordinate < 0 || coordinate > limit - 1);
                return coordinate;
            } // checks for not an integer
            catch (Exception ex) {
                System.err
                        .println("Invalid answer - please enter a number between 0 - " + limit + ".");
                input.nextLine();
            } // end of catch
        } while (true);
    }


}
