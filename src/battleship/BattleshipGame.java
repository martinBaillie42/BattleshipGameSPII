package battleship;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
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
        String newGame;
        Scanner input = new Scanner(System.in);

        do {
            Ocean oc = new OceanImpl();
            limit = oc.getUPPER();
            oc.placeAllShipsRandomly();

            System.out.println();
            System.out.println(oc);

            do {
                Position p = getValidInput(input, limit);
                System.out.println(displayOutcome(oc, p));
            } while (!oc.isGameOver());

            System.out.println(displayEndGame(oc));

            newGame = input.next();
        } while (replies.contains(newGame));
    }

    /**
     * Displays the outcome of each shot to the user. Including the updated board.
     * @param   oc a reference to an instance of the Ocean class
     * @param   p a reference to an instance of the Position object
     * @return  text displaying teh board and the outcome of users shot
     */
    private static String displayOutcome(Ocean oc, Position p){
        StringBuilder strbld = new StringBuilder();
        strbld.append("\n");
        strbld.append("-------------------------------------------------------------\n");
        strbld.append("\n");
        if (oc.shootAt(p.getRow(), p.getColumn())) {// a miss
            if (oc.isShipSunk(p.getRow(), p.getColumn())) {
                strbld.append("You just sunk a " +  oc.nameOfShip(p.getRow(), p.getColumn()) + "! Well done.");
            } else {
                strbld.append("A hit at x = " + p.getRow() + ", y = " + p.getColumn() + ". Well done");
            }
        } else {
            strbld.append("A miss at x = " + p.getRow() + ", y = " + p.getColumn() + ". Try again.");
        }
        strbld.append("\n");
        strbld.append("\n");
        strbld.append(oc);
        strbld.append("\n");
        strbld.append(". is empty sea\n- is a miss\nS is a hit\nX is a sunken ship\n");

        return strbld.toString();
    }

    /**
     * Displays text to the user giving results of the game and asks if they want to play again
     * @param   oc a reference to an instance of the Ocean class
     * @return  text giving results of game and request to play again
     */
    private static String displayEndGame(Ocean oc) {
        StringBuilder strbld = new StringBuilder();
        strbld.append("\nCongratulations, the game is over\n");
        strbld.append("You sunk the fleet in ").append(oc.getShotsFired()).append(" shots.\n");
        strbld.append("\nDo you want to play again (Yes or No)?");

        return strbld.toString();
    }

    /**
     * Obtains the coordinates from the user to shoot at. Adapted from code provided during help session.
     * @param input a reference to an instance of the Scanner class
     * @param limit the size of the board
     * @return      an instance of the <code>Position</code> class
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
     * Validates the user input and either returns the value or displays an error until valid
     * value is entered. Adapted from code provided during help session.
     * @param input     an instance of the Scanner class
     * @param rowCol    the prompt text to display to the user
     * @param limit     the size of the board
     * @return          the valid value entered by the user
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
            }
            catch (Exception ex) {
                System.err.println("Invalid answer - please enter a number between 0 - " + limit + ".");
                input.nextLine();
            }
        } while (true);
    }

}
