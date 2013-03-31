package battleship;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Martin Baillie, mbaill02
 * @version 9
 */
public class OceanImpl implements Ocean {

    /** the size of ocean and the number of ships */
    private static final int UPPER;
    /** used to quickly determine which ship is in any given location */
    private final Ship[][] ships;
    /** the total number of shotsfired by the user */
    private int shotsFired;
    /** the number of times a shot hit a ship. If the user shoots the same part of
     * a ship more than once, every hit is counted, even though the additional hits don't
     * do the user any good.
     */
    private int hitCount;
    /** the number of ships sunk */
    private int shipsSunk;

    static {
        UPPER = 10;
    }

    /**
     * Constructor for the <code>Ocean</code>class
     */
    public OceanImpl(){
        ships = new ShipImpl[UPPER][UPPER];

        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                ships[i][j] = new EmptySeaImpl();
            }
        }

        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
    }

    /**
     * Places a fleet of ships randomly around the <code>Ocean</code> object.
     * Of the 10 available 'spaces' for ships it creates 1 ship of each kind.
     * Then the remaining siz ships are generated randomly.
     * This ensures that the fleet always contains at least one ship of each kind.
     *
     * TODO This method is too big and should to be broken up into smaller methods.
     */
    @Override
    public void placeAllShipsRandomly() {

        Random r = new Random();
        Ship[] fleet = new Ship[UPPER];

        // create one ship of each type

        fleet[0] = new BattleshipImpl();
        fleet[1] = new CruiserImpl();
        fleet[2] = new DestroyerImpl();
        fleet[3] = new SubmarineImpl();

        final int NO_OF_SHIP_TYPES = 4;
        final int MAX_BATTLESHIPS = 2;
        final int MAX_CRUISERS = 3;
        final int MAX_DESTROYERS= 4;
        final int MAX_SUBMARINES = 5;

        int count = 4;
        int countBattleships = 1;
        int countCruiser = 1;
        int countDestroyer = 1;
        int countSubmarine = 1;

        // create the rest of the fleet randomly

        do {
            int shipNo = r.nextInt(NO_OF_SHIP_TYPES);
            if (shipNo == 0 && countBattleships < MAX_BATTLESHIPS) {
                fleet[count] = new BattleshipImpl();
                count++;
                countBattleships++;
            }
            if (shipNo == 1 && countCruiser < MAX_CRUISERS) {
                fleet[count] = new CruiserImpl();
                count++;
                countCruiser++;
            }
            if (shipNo == 2 && countDestroyer < MAX_DESTROYERS) {
                fleet[count] = new DestroyerImpl();
                count++;
                countDestroyer++;
            }
            if (shipNo == 3 && countSubmarine < MAX_SUBMARINES) {
                fleet[count] = new SubmarineImpl();
                count++;
                countSubmarine++;
            }
        } while(count < UPPER);

        // order fleet from largest,battleship, to smallest submarine.
        Arrays.sort(fleet);

        int row;
        int column;
        boolean horizontal;

        // place the ships randomly around the ocean
        for (Ship ship : fleet) {
            do {
                row = r.nextInt(UPPER);
                column = r.nextInt(UPPER);
                horizontal = r.nextInt(2) == 1;
            } while (!ship.okToPlaceShipAt(row, column, horizontal, this));
            ship.placeShipAt(row, column, horizontal, this);
        }
    }

    /**
     * Confirms if a location is an <code>EmptySea</code> object.
     *
     * @param row                               the y-coordinate of a ships bow
     * @param column                            the x-coordinate of a ships bow
     * @throws ArrayIndexOutOfBoundsException   if coordinates are greater than <code>UPPER</code>
     * @return                                  <code>true</code> if the coordinate is occupied by a ship;
     *                                          <code>false</code> otherwise.
     */
    @Override
    public boolean isOccupied(int row, int column) {
        try {
            return !(ships[row][column] instanceof EmptySea);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Checks if a given location contains a real ship still afloat.
     * In addition, this method updates the number of shots that have been red, and the number of hits.
     * @param row       the y-coordinate of the shot
     * @param column    the x-coordinate of the shot
     * @return          <code>true</code> if the coordinates contain an unsunk ship and an unhit section;
     *                  <code>false</code> otherwise
     */
    @Override
    public boolean shootAt(int row, int column) {
        shotsFired = getShotsFired() + 1;

        if (isOccupied(row, column)) {

            if(isShipSunk(row,column)) {
                return false;
            }

            if (ships[row][column].shootAt(row, column)) {
                hitCount = getHitCount() + 1;
                if(ships[row][column].isSunk()){
                    shipsSunk = getShipsSunk() + 1;
                }
                return true;
            } else {
                return false;
            }

        } else {
            ships[row][column].shootAt(row, column);
            return false;
        }

    }

    /**
     * Checks if a ship at the given location is sunk
     * @param row       the y-coordinate
     * @param column    the x-coordinate
     * @return          <code>true</code> if ship is sunk;
     *                  <code>false</code> otherwise.
     */
    @Override
    public boolean isShipSunk(int row, int column) {
        return ships[row][column].isSunk();
    }

    /**
     * Checks for the name of a ship at the given location
     * @param row       the y-coordinate
     * @param column    the x-coordinate
     * @return          the name of the ship
     */
    @Override
    public String nameOfShip(int row, int column) {
        return ships[row][column].getShipType();
    }

    /**
     * Gets the size of this <code>Ocean</code> and the number of ships in the fleet
     * @return the size of this <code>Ocean</code> or the number of ships
     */
    @Override
    public int getUPPER(){
        return UPPER;
    }

    /**
     * Gets the number of shots fired by the user.
     * @return the number of shots fired by the user
     */
    @Override
    public int getShotsFired() {
        return shotsFired;
    }

    /**
     * Gets the number of times the user has hit a ship.
     * @return the number of times the user has hit a ship
     */
    @Override
    public int getHitCount() {
        return hitCount;
    }

    /**
     * Gets the number of ships the user has sunk
     * @return the number of ships the user has sunk
     */
    @Override
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * Calculates if the users game is over.
     * @return  <code>true</code> if the number of ships sunk is equal to the number fo ships in the fleet;
     *          <code>false</code> otherwise.
     */
    @Override
    public boolean isGameOver() {
        return getShipsSunk() == getUPPER();
    }

    /**
     * Gets the array that stores the locations of the various ships. Only to be sued for testing.
     * @return  all ships in the current game
     */
    @Override
    public Ship[][] getShipArray() {
        return ships;
    }

    /**
     * Creates the 'board' to display to the user.
     * @return a series of lines in the console to represent the board
     */
    @Override
    public String toString() {
        final String SPACE = " ";
        StringBuilder buffer = new StringBuilder();


        buffer.append(" ");
        for (int i = 0; i < ships[0].length; i++) {
            buffer.append(SPACE);
            buffer.append(i);
        }
        buffer.append("\n");

        for (int i = 0; i < ships.length; i++) {
            buffer.append(i);
            for (int j = 0; j < ships[0].length; j++) {

                buffer.append(SPACE);
                buffer.append(ships[i][j].toString(i,j));
            }
            buffer.append("\n");
        }

        return buffer.toString();
    }
}
