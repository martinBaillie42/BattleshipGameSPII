package battleship;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 *
 * @author Martin Baillie, mbaill02
 * @version 9
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
            Ocean oc = new OceanImpl();
            limit = oc.getUPPER();
            oc.placeAllShipsRandomly();

            System.out.println();
            System.out.println(oc);

            do {
                Position p = getValidInput(input, limit);
                System.out.println();
                System.out.println("-------------------------------------------------------------");
                System.out.println();
                if (oc.shootAt(p.getRow(), p.getColumn())) {// a miss
                    if (oc.isShipSunk(p.getRow(), p.getColumn())) {
                        System.out.println("You just sunk a " +  oc.nameOfShip(p.getRow(), p.getColumn()) + "! Well done.");
                    } else {
                        System.out.println("A hit at x = " + p.getRow() + ", y = " + p.getColumn() + ". Well done");
                    }
                } else {
                    System.out.println("A miss at x = " + p.getRow() + ", y = " + p.getColumn() + ". Try again.");
                }
                System.out.println();
                System.out.println(oc);
                System.out.println("[. is empty sea; - is a miss; S is a hit; X is a sunken ship]");
                System.out.println();
            } while (!oc.isGameOver());

            System.out.println("Congratulations, the game is over");
            System.out.println("You sunk the fleet in " + oc.getShotsFired() + " shots.");
            System.out.println();
            System.out.print("Do you want to play again (Yes or No)?");
            reply = input.next();
        } while (replies.contains(reply));
    }

    /**
     *
     * @param input
     * @param limit
     * @return
     */
    private static Position getValidInput (Scanner input, int limit) {
        int row;
        int column;
        System.out.println("Where do you want to fire (x,y)?");
        column = askForInput(input, "x/column = ", limit);
        row = askForInput(input, "y/row = ", limit);
        System.out.println();
        return new PositionImpl(row, column);
    }

    /**
     *
     * @param input
     * @param rowCol
     * @param limit
     * @return
     */
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
                System.err.println("Invalid answer - please enter a number between 0 - " + limit + ".");
                input.nextLine();
            } // end of catch
        } while (true);
    }

}
